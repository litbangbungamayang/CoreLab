/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.buma.cl.database;

import id.buma.cl.controller.CommonController;
import id.buma.cl.view.MainWindow;
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
public class DbCoreSamplerConnectionManager {
    
    private static Connection connection = null;
    private static MainWindow mw;
    
    public static Connection getConnection() throws Exception {
        if (connection == null){
            try {
                //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//NOT NEEDED as in the JDBC API 4.0, the DriverManager.getConnection method is enhanced to load JDBC drivers automatically. (https://docs.microsoft.com/en-us/sql/connect/jdbc/using-the-jdbc-driver)

                String conStringLokal = "jdbc:sqlserver://LOCALHOST\\X230_SRV:1433;"+
                                        "databaseName=BUMA;user=prod;password=prod;";
                
                String conStringLive = "jdbc:sqlserver://192.168.39.135:1433;"+
                                   "databaseName=BUMA;user=prod;password=prod;";
                
                connection = DriverManager.getConnection(conStringLive);
            } catch (SQLException e) {
                return null;
            }
        }
        return connection;
    }
    
    public static boolean isConnect(){
        try {
            if (getConnection() == null){
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(DbCoreSamplerConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
