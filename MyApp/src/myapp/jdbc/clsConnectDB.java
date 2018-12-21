/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Windows 10 Version 2
 */
public class clsConnectDB {
//    String dbURL = "jdbc:sqlserver://localhost;databaseName=TestPrograming;integratedSecurity=true;";
//    String connectionString = "jdbc:sqlserver://localhost:1433;" 
//            + "databaseName=laptrinhmang;user=sa;password=123;";
    String connectionString = "jdbc:sqlserver://localhost;databaseName=TestPrograming;integratedSecurity=true;";
    Connection conn;
    public clsConnectDB(){
       
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionString);
            
            if(conn != null){
                System.out.println("Kết nối CSDL SQL Server thành công!");
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    //Thực thi câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL){
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
    public void ExcuteQueryUpdateDB(String cauTruyVanSQL){
       
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    // check user
    public boolean checkUser(String username, String password) {
        System.out.println("ok");
        String sql = "select * from [user] where username='" + username + "' and password='" + password + "'";
//String sql = "select * from user";
        ResultSet rs = ExcuteQueryGetTable(sql); 
        try {
            if (rs.next()) {
                System.out.println("Đăng nhập thành công.");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Sai tên tài khoản hoặc mật khẩu." + ex);
        }
        return false;
    }
}
