/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.dao;

import id.buma.cl.database.DbCoreSamplerConnectionManager;
import id.buma.cl.model.SampelTebu;
import id.buma.cl.view.MainWindow;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public class SampelTebuDAOSQL implements SampelTebuDAO{
    private MainWindow mw;
    
    @Override
    public List<SampelTebu> getAllSampelTebu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SampelTebu> getByIdAnalisa(String idAnalisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SampelTebu> getByIdPetani(String idPetani) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SampelTebu> getByIdKebun(String idKebun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertInputData(SampelTebu st) {
        String sql = "INSERT INTO TBL_CORELAB("
                + "ID_ANALISA,"//1
                + "SEQ_NO,"//2
                + "NO_ANALISA,"//3
                + "NUMERATOR,"//4
                + "NO_TARRA,"//5
                + "NO_POLISI,"//6
                + "ID_PETANI,"//7
                + "NO_KEBUN,"//8
                + "RAYON,"//9
                + "TSTR,"//10
                + "PERIODE,"//11
                + "TGL_INPUT,"//12
                + "JAM_INPUT,"//13
                + "TGL_PRESS,"//14
                + "JAM_PRESS,"//15
                + "TGL_XDS,"//16
                + "JAM_XDS,"//17
                + "ID_USER_INPUT,"//18
                + "VERSI_SISTEM,"//19
                + "CETAK_HASIL"//20
                + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            if (DbCoreSamplerConnectionManager.getConnection() == null){
                return false;
            } else {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, st.getIdAnalisa());
                ps.setInt(2, st.getSeqNo());
                ps.setString(3, st.getNoAnalisa());
                ps.setString(4, st.getNumerator());
                ps.setString(5, st.getNoTarra());
                ps.setString(6, st.getNoPolisi());
                ps.setString(7, st.getIdPetani());
                ps.setString(8, st.getNoKebun());
                ps.setString(9, st.getRayon());
                ps.setString(10, st.getTstr());
                ps.setDate(11, new java.sql.Date(st.getPeriode().getTime()));
                ps.setDate(12, new java.sql.Date(st.getTgl_input().getTime()));
                ps.setTime(13, new java.sql.Time(st.getJam_input().getTime()));
                ps.setDate(14, new java.sql.Date(st.getTgl_press().getTime()));
                ps.setTime(15, new java.sql.Time(st.getJam_press().getTime()));
                ps.setDate(16, new java.sql.Date(st.getTgl_xds().getTime()));
                ps.setTime(17, new java.sql.Time(st.getJam_xds().getTime()));
                ps.setString(18, st.getIdUserInput());
                ps.setString(19, st.getVersiSistem());
                ps.setString(20, st.getCetakHasil());
                int row = ps.executeUpdate();
                if (row > 0){
                    return true;
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw,"Error Insert Input Data!"+
                    '\n'+"Error code : "+ex.toString(),"Error Input Data",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean insertDataPress(SampelTebu st) {
        String sql = "UPDATE TBL_CORELAB SET "
                + "TGL_PRESS=?,"
                + "JAM_PRESS=?,"
                + "AMPAS_BASAH=?,"
                + "AMPAS_KERING=?,"
                + "NIRA=?,"
                + "KNPP=?,"
                + "ID_USER_PRESS=? "
                + "WHERE NO_ANALISA=?";
        try {
            if (DbCoreSamplerConnectionManager.getConnection() == null){
               return false;
            } else {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setDate(1, new java.sql.Date(st.getTgl_press().getTime()));
                ps.setTime(2, new java.sql.Time(st.getJam_press().getTime()));
                ps.setDouble(3, st.getAmpasBasah());
                ps.setDouble(4, st.getAmpasKering());
                ps.setDouble(5, st.getNira());
                ps.setDouble(6, st.getKnpp());
                ps.setString(7, st.getIdUserPress());
                ps.setString(8, st.getNoAnalisa());
                int row = ps.executeUpdate();
                if (row > 0){
                    return true;
                }
            }            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw,"Error insertDataPress!"+
                    '\n'+"Error code : "+ex.toString(),"Error Input Data",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean insertDataXds(SampelTebu st) {
        String sql = "UPDATE TBL_CORELAB SET "
                + "TGL_XDS=?,"
                + "JAM_XDS=?,"
                + "BRIX=?,"
                + "POL=?,"
                + "HK=?,"
                + "NNPP=?,"
                + "ID_USER_XDS=? "
                + "WHERE NO_ANALISA=?";
        try {
            if (DbCoreSamplerConnectionManager.getConnection() == null){
                return false;
            } else {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setDate(1, new java.sql.Date(st.getTgl_xds().getTime()));
                ps.setTime(2, new java.sql.Time(st.getJam_xds().getTime()));
                ps.setDouble(3, st.getBrix());
                ps.setDouble(4, st.getPol());
                ps.setDouble(5, st.getHk());
                ps.setDouble(6, st.getNnpp());
                ps.setString(7, st.getIdUserXds());
                ps.setString(8, st.getNoAnalisa());
                int row = ps.executeUpdate();
                if (row > 0){
                    return true;
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw,"Error insertDataXds!"+
                    '\n'+"Error code : "+ex.toString(),"Error Input Data",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public List<SampelTebu> getAllSampelTebu(Date periode) {
        List<SampelTebu> sampelTebu = new ArrayList<>();
        String sql = "SELECT * FROM TBL_CORELAB WHERE PERIODE=? AND CETAK_HASIL=?";
        try {
            if (DbCoreSamplerConnectionManager.isConnect() == true){
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setDate(1, new java.sql.Date(periode.getTime()));
                ps.setString(2, "N");
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    SampelTebu st = new SampelTebu(
                            rs.getString("ID_ANALISA"),
                            rs.getInt("SEQ_NO"),
                            rs.getString("NUMERATOR"),
                            rs.getString("NO_TARRA"),
                            rs.getString("NO_ANALISA"),
                            rs.getString("NO_POLISI"),
                            rs.getString("ID_PETANI"),
                            rs.getString("NO_KEBUN"),
                            rs.getDate("PERIODE"),
                            rs.getString("RAYON"),
                            rs.getString("TSTR"),
                            rs.getDate("TGL_INPUT"),
                            rs.getTime("JAM_INPUT"),
                            rs.getDate("TGL_PRESS"),
                            rs.getTime("JAM_PRESS"),
                            rs.getDate("TGL_XDS"),
                            rs.getTime("JAM_XDS"),
                            rs.getDouble("BRIX"),
                            rs.getDouble("POL"),
                            rs.getDouble("HK"),
                            rs.getDouble("AMPAS_BASAH"),
                            rs.getDouble("AMPAS_KERING"),
                            rs.getDouble("NIRA"),
                            rs.getDouble("KNPP"),
                            rs.getDouble("NNPP"),
                            rs.getInt("NETTO"),
                            rs.getString("ID_USER_INPUT"),
                            rs.getString("ID_USER_PRESS"),
                            rs.getString("ID_USER_XDS"),
                            rs.getString("VERSI_SISTEM"),
                            rs.getString("CETAK_HASIL")
                    );
                    sampelTebu.add(st);
                }
                return sampelTebu;
            } else {
                //TODO : kasih message/indikator
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw, "Error getAllSampelTebu!"+
                    '\n'+"Error code : "+ex.toString(), "Error Get Data", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    @Override
    public double getHkSampelByNumerator(String numerator) {
        String sql = "SELECT HK FROM TBL_CORELAB WHERE NUMERATOR=?";
        Double hk = 0.0;
        if (DbCoreSamplerConnectionManager.isConnect() == true){
            try {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, numerator);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    hk = rs.getDouble("HK");
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(mw, "Error getHkSampel!" + '\n' +
                        "Error code : " +  ex.toString(), "Error Get Data", JOptionPane.ERROR_MESSAGE);
            }
        }
        return hk;
    }

    @Override
    public double getHkSampelByIdAnalisa(String idAnalisa) {
         String sql = "SELECT HK FROM TBL_CORELAB WHERE ID_ANALISA=? AND CETAK_HASIL=?";
        Double hk = 0.0;
        if (DbCoreSamplerConnectionManager.isConnect() == true){
            try {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, idAnalisa);
                ps.setString(2, "N");
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    hk = rs.getDouble("HK");
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(mw, "Error getHkSampel!" + '\n' +
                        "Error code : " +  ex.toString(), "Error Get Data", JOptionPane.ERROR_MESSAGE);
            }
        }
        return hk;
    }

    @Override
    public double getHkSampelKeduaByNumerator(String numerator) {
        String sql = "SELECT HK FROM TBL_CORELAB WHERE NUMERATOR=? AND SEQ_NO=? AND CETAK_HASIL=?";
        Double hk = 0.0;
        if (DbCoreSamplerConnectionManager.isConnect() == true){
            try {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, numerator);
                ps.setInt(2, 2);
                ps.setString(3, "N");
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    hk = rs.getDouble("HK");
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(mw, "Error getHkSampel!" + '\n' +
                        "Error code : " +  ex.toString(), "Error Get Data", JOptionPane.ERROR_MESSAGE);
            }
        }
        return hk;
    }

    @Override
    public SampelTebu getSampelByNumerator(String numerator) {
        SampelTebu st = null;
        String sql = "SELECT * FROM TBL_CORELAB WHERE NUMERATOR=?";
        if (DbCoreSamplerConnectionManager.isConnect() == true){
            try {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, numerator);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    st = new SampelTebu(
                            rs.getString("ID_ANALISA"),
                            rs.getInt("SEQ_NO"),
                            rs.getString("NUMERATOR"),
                            rs.getString("NO_TARRA"),
                            rs.getString("NO_ANALISA"),
                            rs.getString("NO_POLISI"),
                            rs.getString("ID_PETANI"),
                            rs.getString("NO_KEBUN"),
                            rs.getDate("PERIODE"),
                            rs.getString("RAYON"),
                            rs.getString("TSTR"),
                            rs.getDate("TGL_INPUT"),
                            rs.getTime("JAM_INPUT"),
                            rs.getDate("TGL_PRESS"),
                            rs.getTime("JAM_PRESS"),
                            rs.getDate("TGL_XDS"),
                            rs.getTime("JAM_XDS"),
                            rs.getDouble("BRIX"),
                            rs.getDouble("POL"),
                            rs.getDouble("HK"),
                            rs.getDouble("AMPAS_BASAH"),
                            rs.getDouble("AMPAS_KERING"),
                            rs.getDouble("NIRA"),
                            rs.getDouble("KNPP"),
                            rs.getDouble("NNPP"),
                            rs.getInt("NETTO"),
                            rs.getString("ID_USER_INPUT"),
                            rs.getString("ID_USER_PRESS"),
                            rs.getString("ID_USER_XDS"),
                            rs.getString("VERSI_SISTEM"),
                            rs.getString("CETAK_HASIL")
                    );
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(mw, "Error getSampelByNumerator!" +
                        '\n' + "Error code : " + ex.toString(), "Error Get Data", JOptionPane.ERROR_MESSAGE);
            }
        }
        return st;
    }

    @Override
    public List<SampelTebu> getSampelByNumeratorArray(String numerator) {
        List<SampelTebu> arSampelTebu = new ArrayList<>();
        String sql = "SELECT * FROM TBL_CORELAB WHERE NUMERATOR=? AND CETAK_HASIL=?";
        if (DbCoreSamplerConnectionManager.isConnect() == true){
            try {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, numerator);
                ps.setString(2, "N");
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    SampelTebu st = new SampelTebu(
                            rs.getString("ID_ANALISA"),
                            rs.getInt("SEQ_NO"),
                            rs.getString("NUMERATOR"),
                            rs.getString("NO_TARRA"),
                            rs.getString("NO_ANALISA"),
                            rs.getString("NO_POLISI"),
                            rs.getString("ID_PETANI"),
                            rs.getString("NO_KEBUN"),
                            rs.getDate("PERIODE"),
                            rs.getString("RAYON"),
                            rs.getString("TSTR"),
                            rs.getDate("TGL_INPUT"),
                            rs.getTime("JAM_INPUT"),
                            rs.getDate("TGL_PRESS"),
                            rs.getTime("JAM_PRESS"),
                            rs.getDate("TGL_XDS"),
                            rs.getTime("JAM_XDS"),
                            rs.getDouble("BRIX"),
                            rs.getDouble("POL"),
                            rs.getDouble("HK"),
                            rs.getDouble("AMPAS_BASAH"),
                            rs.getDouble("AMPAS_KERING"),
                            rs.getDouble("NIRA"),
                            rs.getDouble("KNPP"),
                            rs.getDouble("NNPP"),
                            rs.getInt("NETTO"),
                            rs.getString("ID_USER_INPUT"),
                            rs.getString("ID_USER_PRESS"),
                            rs.getString("ID_USER_XDS"),
                            rs.getString("VERSI_SISTEM"),
                            rs.getString("CETAK_HASIL")
                    );
                    arSampelTebu.add(st);
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(mw, "Error getSampelByNumerator!" +
                        '\n' + "Error code : " + ex.toString(), "Error Get Data", JOptionPane.ERROR_MESSAGE);
            }
        }
        return arSampelTebu;
    }

    @Override
    public boolean setCetakHasil(String numerator) {
        String sql = "UPDATE TBL_CORELAB SET CETAK_HASIL=? WHERE NUMERATOR=?";
        try {
            if (DbCoreSamplerConnectionManager.isConnect() == true){
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, "Y");
                ps.setString(2, numerator);
                if (ps.executeUpdate() > 0){
                    return true;
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw, "Error setCetakHasil! Error code : " +
                    ex.toString(), "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public SampelTebu getSampelByIdAnalisa(String idAnalisa) {
        SampelTebu st = null;
        String sql = "SELECT * FROM TBL_CORELAB WHERE ID_ANALISA=?";
        try {
            if (DbCoreSamplerConnectionManager.isConnect() == true){
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, idAnalisa);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    st = new SampelTebu(
                            rs.getString("ID_ANALISA"),
                            rs.getInt("SEQ_NO"),
                            rs.getString("NUMERATOR"),
                            rs.getString("NO_TARRA"),
                            rs.getString("NO_ANALISA"),
                            rs.getString("NO_POLISI"),
                            rs.getString("ID_PETANI"),
                            rs.getString("NO_KEBUN"),
                            rs.getDate("PERIODE"),
                            rs.getString("RAYON"),
                            rs.getString("TSTR"),
                            rs.getDate("TGL_INPUT"),
                            rs.getTime("JAM_INPUT"),
                            rs.getDate("TGL_PRESS"),
                            rs.getTime("JAM_PRESS"),
                            rs.getDate("TGL_XDS"),
                            rs.getTime("JAM_XDS"),
                            rs.getDouble("BRIX"),
                            rs.getDouble("POL"),
                            rs.getDouble("HK"),
                            rs.getDouble("AMPAS_BASAH"),
                            rs.getDouble("AMPAS_KERING"),
                            rs.getDouble("NIRA"),
                            rs.getDouble("KNPP"),
                            rs.getDouble("NNPP"),
                            rs.getInt("NETTO"),
                            rs.getString("ID_USER_INPUT"),
                            rs.getString("ID_USER_PRESS"),
                            rs.getString("ID_USER_XDS"),
                            rs.getString("VERSI_SISTEM"),
                            rs.getString("CETAK_HASIL")
                    );
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw, "Error getSampelByIdAnalisa! Error code : " +
                    ex.toString(), "Error Get Data", JOptionPane.ERROR_MESSAGE);
        }
        return st;
    }

    @Override
    public boolean updateBeratAmpas(String statusNira, String idAnalisa, int beratAmpas, String idUser) {
        String sql = null;
        PreparedStatement ps = null;
        switch (statusNira){
            case "CACAH":
                sql = "UPDATE TBL_CORELAB SET AMPAS_BASAH=? WHERE ID_ANALISA=?";
                try {
                    if (DbCoreSamplerConnectionManager.isConnect() == true){
                        ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                        ps.setInt(1, beratAmpas);
                        ps.setString(2, idAnalisa);
                        if (ps.executeUpdate() == 1){
                            return true;
                        }                       
                    } else {
                        JOptionPane.showMessageDialog(mw, "Database Coresampler tidak tersambung!",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(mw, "Error updateBeratAmpas! Error code: " +
                            ex.toString(),"", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "PRESS":
                sql = "UPDATE TBL_CORELAB SET AMPAS_KERING=?,NIRA=?,KNPP=?,TGL_PRESS=?, "
                        + "JAM_PRESS=?, ID_USER_PRESS=? WHERE ID_ANALISA=?";
                SampelTebu st = getSampelByIdAnalisa(idAnalisa);
                Double beratBasah = st.getAmpasBasah();
                Double nira = beratBasah-beratAmpas;
                Double knpp = nira/beratBasah;
                try {
                    if (DbCoreSamplerConnectionManager.isConnect() == true){ 
                        ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                        ps.setInt(1, beratAmpas);
                        ps.setDouble(2, nira);
                        ps.setDouble(3, knpp);
                        ps.setDate(4, new java.sql.Date(new Date().getTime()));
                        ps.setTime(5, new java.sql.Time(new Date().getTime()));
                        ps.setString(6, idUser);
                        ps.setString(7, idAnalisa);
                        if (ps.executeUpdate() == 1){
                            return true;
                        }
                    } else {
                        JOptionPane.showMessageDialog(mw, "Database Coresampler tidak tersambung!",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(mw, "Error updateBeratAmpas! Error code: " +
                            ex.toString(),"", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        return false;
    }

    @Override
    public boolean updateDataXds(String idAnalisa, Double nilaiBrix, Double nilaiPol, String idUser) {
        String sql = "UPDATE TBL_CORELAB SET BRIX=?, POL=?, NNPP=?, HK=?, TGL_XDS=?, JAM_XDS=?, ID_USER_XDS=? WHERE ID_ANALISA=?";
        if (DbCoreSamplerConnectionManager.isConnect()){
            try {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setDouble(1, nilaiBrix);
                ps.setDouble(2, nilaiPol);
                ps.setDouble(3, nilaiPol-0.4*(nilaiBrix-nilaiPol));
                ps.setDouble(4, (nilaiPol/nilaiBrix)*100);
                ps.setDate(5, new java.sql.Date(new Date().getTime()));
                ps.setTime(6, new java.sql.Time(new Date().getTime()));
                ps.setString(7, idUser);
                ps.setString(8, idAnalisa);
                if (ps.executeUpdate() == 1){
                    return true;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mw, "Error updateDataXds! Error code : " +
                        ex.toString(), "", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(mw, "Database Coresampler tidak tersambung!", "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public boolean updateNetto(String numerator, int netto) {
        String sql = "UPDATE TBL_CORELAB SET NETTO=? WHERE NUMERATOR=?";
        if (DbCoreSamplerConnectionManager.isConnect()){
            try {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setInt(1, netto);
                ps.setString(2, numerator);
                if (ps.executeUpdate() == 1){
                    return true;
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(mw, "Error updateNetto! Error code :" +
                        ex.toString(), "", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }
    
}
