/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 10 Version 2
 */
public class clsConnectDB {

    String connectionString = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=laptrinhmang;user=sa;password=123;";
    String driverMysql = "com.mysql.jdbc.Driver";
    String driverSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String connectionMysql = "jdbc:mysql://localhost:3306/quiz?autoReconnect=true&useSSL=false";
    Connection conn;

    public clsConnectDB() {

        try {
            Class.forName(driverMysql);
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionMysql, "root", "123456");

            if (conn != null) {
                System.out.println("Kết nối CSDL SQL Server thành công!");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static Connection getConnnection() {
        Connection conn = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
//                Class.forName(driverSQL);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error " + ex);
            }
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz?autoReconnect=true&useSSL=false", "root", "123456");
            return conn;
        } catch (SQLException ex) {
            return null;
        }
    }

    //Thực thi câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return null;
    }

    //Thực thi INSERT, DELETE, UPDATE
    public void ExcuteQueryUpdateDB(String cauTruyVanSQL) {

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

}
