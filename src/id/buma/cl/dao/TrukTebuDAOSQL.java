/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.dao;

import id.buma.cl.database.DbTimbanganConnectionManager;
import id.buma.cl.model.SampelTebu;
import id.buma.cl.model.TrukTebu;
import id.buma.cl.view.MainWindow;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public class TrukTebuDAOSQL implements TrukTebuDAO{
    /*
         String numerator;
         String noTarra;
         String noPolisi;
         String idPetani;
         String noKebun;
         String rayon;
         String TSTR;
         Integer netto;
         Date periode;
    */

    MainWindow mw;
    private SampelTebuDAO sampelTebuDao;
    
    @Override   
    public List<TrukTebu> getDataTimbangan(String numerator) {
        String numeratorBaru = "";
        List<TrukTebu> trukTebu = new ArrayList<>();
        /*
        String sql = "SELECT T.NUMERATOR, T.NOPOL, T.NOPOL2, T.IDPETANI, T.NOKEBUN, T.NETTO, T.PERIODE, T.TSTR, R.RAYON, A.AFDELING "
                     + " FROM TIMBANG T INNER JOIN AFDELING A ON T.IDAFD=A.IDAFD"
                     + " INNER JOIN RAYON R ON A.IDRAYON=R.IDRAYON"
                     + " WHERE NUMERATOR=? OR NUMERATOR=?";
        */
        String sql =    "select " +
                        "spta.no_spat as numerator," +
                        "selektor.no_angkutan as nopol," +
                        "selektor.no_angkutan as nopol2," +
                        "spta.kode_blok as idpetani," +
                        "spta.kode_blok as nokebun," +
                        "timb.netto as netto," +
                        "selektor.tgl_selektor as periode," +
                        "if (left(spta.kode_kat_lahan,2) = 'TS',1,2) as tstr," +
                        "(" +
                        "if (cast(mid(spta.kode_blok,6,2) as signed) < 5, 'I'," +
                        "if (cast(mid(spta.kode_blok,6,2) as signed) >= 5 && cast(mid(spta.kode_blok,6,2) as signed) < 8, 'II'," +
                        "if (cast(mid(spta.kode_blok,6,2) as signed) >= 8 && cast(mid(spta.kode_blok,6,2) as signed) < 10, 'III'," +
                        "if (cast(mid(spta.kode_blok,6,2) as signed) >= 10 && cast(mid(spta.kode_blok,6,2) as signed) < 17, 'IV', 'TR'))))" +
                        ") as rayon," +
                        "(select mid(spta.kode_blok,6,2)) as afdeling " +
                        "from simpg.t_spta spta " +
                        "inner join simpg.t_selektor as selektor on spta.id = selektor.id_spta " +
                        "inner join simpg.t_timbangan as timb on spta.id = timb.id_spat "+
                        "where spta.no_spat = ?";
        try {
            PreparedStatement ps = DbTimbanganConnectionManager.getConnection().prepareStatement(sql);
            ps.setString(1, numerator);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TrukTebu tt = new TrukTebu(
                        numeratorBaru = rs.getString("NUMERATOR"),
                        rs.getString("nopol"),
                        rs.getString("nopol2"),
                        rs.getString("idPetani"),
                        rs.getString("noKebun"),
                        rs.getInt("netto"),
                        rs.getDate("periode"),
                        rs.getInt("tstr"),
                        rs.getString("rayon"),
                        rs.getString("afdeling")
                );
                trukTebu.add(tt);
            }
        } catch(Exception ex){
            JOptionPane.showMessageDialog(mw, ex.toString());
        }
        return trukTebu;
    }   

    @Override
    public boolean konversiNumerator(String numerator) {
        String sql = "UPDATE TIMBANG SET NUMERATOR=? WHERE NUMERATOR=?";
        try {
            PreparedStatement ps = DbTimbanganConnectionManager.getConnection().prepareStatement(sql);
            ps.setString(1, numerator);
            ps.setString(2, numerator + "XX");
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw, ex.toString());
        }
        return false;
    }

    @Override
    public boolean setRafaksi(String numerator, double jenisRafaksi, java.sql.Date periodeAnalisa) {
        String sql = "UPDATE TIMBANG SET RAFAKSI=? WHERE NUMERATOR=?";
        try {
            PreparedStatement ps = DbTimbanganConnectionManager.getConnection().prepareStatement(sql);
            ps.setInt(1,1);
            ps.setString(2, numerator);
            if (ps.executeUpdate() > 0){
                sql = "INSERT INTO TBL_RAFAKSI_CS (NUMERATOR,JENIS_RAFAKSI,KW_RAFAKSI,PERIODE) VALUES(?,?,?,?)";
                ps = DbTimbanganConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, numerator);
                ps.setDouble(2, jenisRafaksi);
                ps.setInt(3, 0);
                ps.setDate(4, periodeAnalisa);
                if (ps.executeUpdate() == 1){
                    return true;
                }                
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw, "Error setRafaksi!" + '\n' +
                    "Error code : " + ex.toString(), "Error Get Data", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean getNettoTruk(java.sql.Date periode, List<SampelTebu> st) {
        String sql = "SELECT * FROM TIMBANG WHERE NUMERATOR=?";
        int jml = 0;
        int netto = 0;
        JOptionPane.showMessageDialog(mw, st.size());
        for (SampelTebu sampelTebu : st) {
            try {
                PreparedStatement ps = DbTimbanganConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, sampelTebu.getNumerator());
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    jml++;
                    netto = rs.getInt("NETTO");
                }
                sampelTebuDao.updateNetto(sampelTebu.getNumerator(), netto);
                JOptionPane.showMessageDialog(mw, jml);
                return true;
            } catch (Exception ex){
                JOptionPane.showMessageDialog(mw, "Error getNettoTruk! Error code : " +
                        ex.toString(), "", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    @Override
    public int getNettoTruk(String numerator) {
        String sql = "SELECT * FROM TIMBANG WHERE NUMERATOR=?";
        try {
            PreparedStatement ps = DbTimbanganConnectionManager.getConnection().prepareStatement(sql);
            ps.setString(1, numerator);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt("NETTO");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(mw, "Error getNettoTruk!\nError code = " +
                    e.toString(), "", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
    
}
