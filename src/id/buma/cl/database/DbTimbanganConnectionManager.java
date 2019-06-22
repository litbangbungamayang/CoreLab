/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Anandavi Muhardika
 */
public class DbTimbanganConnectionManager {
    
    private static Connection connection = null;
    
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String cLive = "jdbc:sqlserver://192.168.137.240\\SQL2012:1433;"+
                               "databaseName=SugarCaneDb2017;user=sa;password=123456;";
            String cLokal = "jdbc:sqlserver://LOCALHOST\\X230_SRV:1433;"+
                               "databaseName=SugarCaneDb;user=prod;password=prod;";
            String cSimpgLive = "jdbc:mysql://192.168.39.150:3306/simpg?user=root&password=tiptpn7&useSSL=false";
            String cSimpgLokal = "jdbc:mysql://localhost:3306/simpg?user=root&password=&useSSL=false";
            connection = DriverManager.getConnection(cSimpgLive);
        } catch (ClassNotFoundException | SQLException e) {
            //return null;
            JOptionPane.showMessageDialog(null,"<html><body><p style='width: 200px;'>"+
                    e.toString()+"</p></body></html>");
        }
        return connection;
    }
    
    public static boolean isConnect(){
        try {
            if (getConnection() == null){
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(DbTimbanganConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
