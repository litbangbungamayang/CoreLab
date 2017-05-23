/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.dao;

import id.buma.cl.database.DbCoreSamplerConnectionManager;
import id.buma.cl.view.MainWindow;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public class IdAnalisaDAOSQL implements IdAnalisaDAO{

    private MainWindow mw;
    
    @Override
    public String getLastId() {
        DateFormat formatTglId = new SimpleDateFormat("ddMMYYYY");
        java.util.Date tglSekarang = (Date) new java.util.Date();
        String idAnalisa = null;
        String sql = "SELECT ID_ANALISA FROM TBL_NUMERATOR";
        try {
            PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                idAnalisa = rs.getString("ID_ANALISA");
            }
        } catch (Exception ex){
            System.out.println(ex.toString());
        }
        //return formatTglId.format(tglSekarang)+idAnalisa;
        return idAnalisa;
    }

    @Override
    public Boolean updateId() {
        int idAnalisa = 0;
        String sql = "SELECT ID_ANALISA FROM TBL_NUMERATOR";
        try {
            PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                idAnalisa = rs.getInt("ID_ANALISA");
            }
            idAnalisa = idAnalisa + 1;
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw, "Error Update ID Analisa!"+'\n'+
                    "Error code : "+ex.toString(), "Error Input Data", JOptionPane.ERROR_MESSAGE);
        }
        sql = "UPDATE TBL_NUMERATOR SET ID_ANALISA=?";
        try {
            PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
            ps.setInt(1, idAnalisa);
            ps.executeUpdate();
            return true;
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw, "Error Update ID Analisa!"+'\n'+
                    "Error code : "+ex.toString(),"Error Input Data",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public int cekDuplikatSampel(String numerator) {
        ArrayList<String> arJml = new ArrayList<>();
        String sql = "SELECT * FROM TBL_CORELAB WHERE NUMERATOR=?";
        try {
            PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
            ps.setString(1, numerator);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                arJml.add(rs.getString("NUMERATOR"));
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw, "Error cek duplikat sampel!"+'\n'+
                    "Error code:"+ex.toString(), "System Error", JOptionPane.ERROR_MESSAGE);
        }
        return arJml.size();
    }

    @Override
    public java.sql.Date getPeriodeAnalisa() {
        java.sql.Date tglPeriode = null;
        String sql = "SELECT PERIODE_ANALISA FROM TBL_NUMERATOR";
        try{
            if (DbCoreSamplerConnectionManager.isConnect() == true){
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    tglPeriode = rs.getDate("PERIODE_ANALISA");
                }
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(mw,"Error getPeriodeAnalisa!"+
                    '\n'+"Error code : "+ex.toString(),"Error Get Data",JOptionPane.ERROR_MESSAGE);
        }
        return tglPeriode;
    }

    @Override
    public boolean setPeriodeAnalisa(java.sql.Date tglPeriodeBaru) {
        String sql = "UPDATE TBL_NUMERATOR SET PERIODE_ANALISA=?";
        if (DbCoreSamplerConnectionManager.isConnect()){
            try {
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setDate(1, tglPeriodeBaru);
                if (ps.executeUpdate() == 1){
                    return true;
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(mw, "Error setPeriodeAnalisa! Error code : " +
                        ex.toString(), "", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    @Override
    public boolean resetNumeratorAnalisa() {
        String sql="UPDATE TBL_NUMERATOR SET ID_ANALISA=?";
        try {
            if (DbCoreSamplerConnectionManager.isConnect()){
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setInt(1, 1);
                if (ps.executeUpdate() == 1){
                    return true;
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(mw, "Error resetNumeratoranalisa! Error code : " +
                    e.toString(), "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public int getBypassStatus() {
        String sql = "SELECT BYPASS_STATUS FROM TBL_NUMERATOR";
        try {
            if (DbCoreSamplerConnectionManager.isConnect()){
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    return rs.getInt("BYPASS_STATUS");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(mw, "Error getBypassStatus! Error code : " + 
                    e.toString(), "", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    @Override
    public boolean cekDuplikatIdSampel(String idAnalisa) {
        String sql = "SELECT * FROM TBL_CORELAB WHERE ID_ANALISA=?";
        int jmlSampel = 0;
        try {
            if (DbCoreSamplerConnectionManager.isConnect()){
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, idAnalisa);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    jmlSampel ++;
                }
                if (jmlSampel == 0){
                    return true;
                }
           }
        } catch (Exception e){
            JOptionPane.showMessageDialog(mw, "Error cekDuplikatIdAnalisa!\nError code = " +
                    e.toString(), "", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    
}
