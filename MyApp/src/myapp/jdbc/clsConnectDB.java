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
import java.util.ArrayList;
import java.util.List;
import myapp.bean.Questions;

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

    public clsConnectDB() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionString);

            if (conn != null) {
                System.out.println("Kết nối CSDL SQL Server thành công!");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
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
    public void ExcuteQueryUpdateDB(String query) {

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    // check user
    public boolean checkUser(String username, String password) {
        String query = "select * from [user] where username='" + username + "' and password='" + password + "'";
//String sql = "select * from user";
        ResultSet rs = ExcuteQueryGetTable(query);
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

    // get question
    public List<Questions> getQuestionsRandom(int num) {
        int i = 0;
        String id, QuestionContent, A, B, C, result;
        List<Questions> questions = new ArrayList<>();
        String query = "SELECT TOP " + num + " * FROM [QUESTION] ORDER BY NEWID()";
        ResultSet rs = ExcuteQueryGetTable(query);
        try {
            while (rs.next()) {
                id = rs.getString("id");
                QuestionContent = rs.getString("QuestionContent");
                A = rs.getString("A");
                B = rs.getString("B");
                C = rs.getString("C");
                result = rs.getString("result");
                questions.add(new Questions(id, QuestionContent, A, B, C, result));
                System.out.println("Question["+ i +"]: " + questions.get(i).toString());
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Không lấy được questions." + ex);
        }
        return questions;
    }

    public static void main(String[] args) {
        clsConnectDB con = new clsConnectDB();
        List<Questions> questionses = con.getQuestionsRandom(10);
        
    }
}
