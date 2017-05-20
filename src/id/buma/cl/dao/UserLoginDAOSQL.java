/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.dao;

import id.buma.cl.database.DbCoreSamplerConnectionManager;
import id.buma.cl.model.UserLogin;
import id.buma.cl.view.MainWindow;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public class UserLoginDAOSQL implements UserLoginDAO{
    
    private MainWindow mw;

    @Override
    public UserLogin getByUsername(String username) {
        UserLogin ul = null;
        String sql = "SELECT * FROM TBL_USER WHERE ID_USER=?";
        try {
            if (DbCoreSamplerConnectionManager.isConnect()){
                PreparedStatement ps = DbCoreSamplerConnectionManager.getConnection().prepareStatement(sql);
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    ul = new UserLogin(
                            rs.getString("ID_USER"), 
                            rs.getString("NAMA_USER"),
                            rs.getString("KATAKUNCI"),
                            rs.getString("KEWENANGAN")
                    );
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mw, "Error getUserByUsername! Error code : " + 
                    e.toString(), "", JOptionPane.ERROR_MESSAGE);
        }
        return ul;
    }
    
    
    
}
