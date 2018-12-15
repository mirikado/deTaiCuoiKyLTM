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
public class RegisterForm {
    private JFrame frmRegister;
    private JTextField txtUsername;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JPasswordField txtRetypePasswword;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    RegisterForm window = new RegisterForm();
                    window.frmRegister.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public RegisterForm() {
        initialize();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void initialize() {
        frmRegister = new JFrame();
        frmRegister.setTitle("Register Form");
        frmRegister.setIconImage(Toolkit.getDefaultToolkit()
                .getImage("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\Cookies-icon (4).png"));
        frmRegister.setBounds(460, 210, 420, 240);
        frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmRegister.getContentPane().setLayout(null);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\Cookies-icon (5).png"));
        label.setBounds(10, 22, 142, 128);
        frmRegister.getContentPane().add(label);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUsername.setBounds(162, 42, 72, 14);
        frmRegister.getContentPane().add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(244, 39, 129, 20);
        frmRegister.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEmail.setBounds(162, 72, 72, 14);
        frmRegister.getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(244, 69, 129, 20);
        frmRegister.getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPassword.setBounds(162, 102, 72, 14);
        frmRegister.getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(244, 99, 129, 20);
        frmRegister.getContentPane().add(txtPassword);
        txtPassword.setColumns(10);
        
       

        JButton btnRegister = new JButton("Sign up");
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String Username, Email, Password;
                Username = txtUsername.getText().trim();
                Email = txtEmail.getText();
                Password = String.valueOf(txtPassword.getPassword()).trim();
              
                System.out.println(Username);
                boolean kt = true;

            if (Username.equals("")) {
                ThongBao("Username phải từ 6-10 ký tự", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                 if (Password.length() < 6 || Password.length() > 50) {
                    ThongBao("Mật khẩu phải nhập nhiều hơn 6 ký tự và ít hơn 50 ký tự", "Lỗi đăng ký", 2);
                }  else {
                 String cautruyvan2 = "select * from Users where Username= '" + Username + "'";
                ResultSet rs2 = Laptrinhmang.connection.ExcuteQueryGetTable(cautruyvan2);
                try {
                    rs2.next();
                    if (rs2.getString("Username").equals(Username)) {
                        kt = false;
                        ThongBao("Username: " + Username + " đã tồn tại!", "Thông báo", 2);
                    }

                } catch (SQLException ex) {
                    System.out.println("không có trong sql !có thể tạo thêm");
                    kt = true;
                }
                    if (kt == true) {
                     String ctv = "insert into Users values('" + Username
                    + "' ,'" + Email + "' , '" + Password + "')";
                System.out.println(ctv);
                Laptrinhmang.connection.ExcuteQueryUpdateDB(ctv);
                ThongBao("Them thanh cong", "Thong bao",2);
                System.out.println("Đã Thêm Thành Công");
            } else {
                ThongBao("Không thể Thêm tài Khoản", "lỗi", 2);
                    }
                }
            }
            }
        });
        btnRegister.setIcon(
                new ImageIcon("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\Register-icon (1).png"));
        btnRegister.setBounds(162, 141, 96, 30);
        frmRegister.getContentPane().add(btnRegister);

        JButton btnLogin = new JButton("Sign in");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm frmDN=new LoginForm();
                frmDN.show();
                this.dispose();
                
            }

            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        btnLogin.setIcon(
                new ImageIcon("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\User-Interface-Login-icon (1).png"));
        btnLogin.setBounds(277, 141, 96, 30);
        frmRegister.getContentPane().add(btnLogin);
        
        
        
        
    }
    private void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), noiDungThongBao,
                tieuDeThongBao, icon);
    }

    void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
                
}
