/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author OS
 */
public class LoginForm {

    private JFrame frmLogin;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LoginForm window = new LoginForm();
                    window.frmLogin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginForm() {
        initialize();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String ten = "", email = "";

    public void initialize() {
        frmLogin = new JFrame();
        frmLogin.setTitle("Login Form");
        frmLogin.setIconImage(Toolkit.getDefaultToolkit()
                .getImage("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\Apps-preferences-system-login-icon.png"));
        frmLogin.setBounds(460, 210, 420, 240);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLogin.getContentPane().setLayout(null);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\Apps-preferences-system-login-icon (1).png"));
        label.setBounds(10, 22, 142, 128);
        frmLogin.getContentPane().add(label);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUsername.setBounds(162, 42, 72, 14);
        frmLogin.getContentPane().add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(244, 39, 129, 20);
        frmLogin.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPassword.setBounds(162, 89, 72, 14);
        frmLogin.getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(244, 86, 129, 20);
        frmLogin.getContentPane().add(txtPassword);

        JButton btnLogin = new JButton("Sign in");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strUsername = txtUsername.getText().trim();
                String strPassword = String.valueOf(txtPassword.getPassword()).trim();
                String cautruyvan = "select * from Users where Username= '" + strUsername + "' and Password= '" + strPassword + "'";
                ResultSet rs = Laptrinhmang.connection.ExcuteQueryGetTable(cautruyvan);

                if (KiemTra(strUsername, strPassword)) {
//                    Laptrinhmang.frmAdmin.show();
                    new QuizForm(strUsername).setVisible(true);
//ThongBao("Đăng nhập thành công", "Đăng nhập", 2);
                } else {
                    ThongBao("Bạn nhập sai tài khoản hoặc mật khẩu", "Lỗi đăng nhập", 2);
                }

            }

            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        btnLogin.setIcon(
                new ImageIcon("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\User-Interface-Login-icon (1).png"));
        btnLogin.setBounds(162, 141, 96, 30);
        frmLogin.getContentPane().add(btnLogin);

        JButton btnRegister = new JButton("Sign up");
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterForm frmDK = new RegisterForm();
                frmDK.show();

                this.dispose();
            }

            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        btnRegister.setIcon(new ImageIcon("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\Register-icon (1).png"));
        btnRegister.setBounds(277, 141, 96, 30);
        frmLogin.getContentPane().add(btnRegister);

    }

    private void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), noiDungThongBao,
                tieuDeThongBao, icon);
    }

    private boolean KiemTra(String tdn, String mk) {
        boolean kq = false;

        String cautruyvan = "select * from Users where Username= '" + tdn + "' and Password= '" + mk + "'";
        System.out.println(cautruyvan);
        ResultSet rs = Laptrinhmang.connection.ExcuteQueryGetTable(cautruyvan);

        try {
            if (rs.next()) {
                kq = true;
                ten = rs.getString("Username");
                email = rs.getString("email");
                System.out.println(" " + ten);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đăng nhập");
        }

        return kq;
    }

    void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
