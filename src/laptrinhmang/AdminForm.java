/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OS
 */
public class AdminForm {

    public JFrame frmAdmin;
    private JPanel panel;
    private JTable table;

    private JTextField txt_ID_student;
    private JTextField txt_user_student;
    private JTextField txt_email_student;
    private JTextField txt_pass_student;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AdminForm window = new AdminForm();
                    window.frmAdmin.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AdminForm() {
        initialize();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        showStudent();
    }

    public void showStudent() {
        // Name Column table
        Vector cols = new Vector();
        cols.addElement("ID Student");
        cols.addElement("Username");
        cols.addElement("Email");
        cols.addElement("Password");

        // Data table
        Vector data = new Vector();
        Vector student = new Vector();
        student.addElement("1");
        student.addElement("Hồ Trí Viễn");
        student.addElement("abc@gmail.com");
        student.addElement("123456");
        data.add(student);

        table.setModel(new DefaultTableModel(data, cols));
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frmAdmin = new JFrame();
        frmAdmin.setResizable(false);
        frmAdmin.setIconImage(Toolkit.getDefaultToolkit()
//                C:\Users\Nho Xuan\Documents\NetBeansProjects
                .getImage("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\Apps-kdevelop-icon.png"));
        frmAdmin.setTitle("Admin Form");
        frmAdmin.getContentPane().setBackground(SystemColor.menu);
        frmAdmin.setBounds(300, 100, 774, 452);
        frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdmin.getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(230, 230, 250));
        panel.setBorder(new LineBorder(new Color(135, 206, 250), 1, true));
        panel.setBounds(10, 11, 185, 92);
        frmAdmin.getContentPane().add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblAdminIcon = new JLabel("");
        lblAdminIcon.setIcon(new ImageIcon("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\Cookies-icon (1).png"));
        panel.add(lblAdminIcon);

        JLabel lblGreeting = new JLabel("Welcome Admin!");
        lblGreeting.setIcon(null);
        lblGreeting.setForeground(new Color(255, 20, 147));
        lblGreeting.setFont(new Font("Times New Roman", Font.BOLD, 17));
        panel.add(lblGreeting);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(230, 230, 250));
        panel_1.setBorder(new LineBorder(new Color(135, 206, 235), 1, true));
        panel_1.setBounds(205, 11, 544, 92);
        frmAdmin.getContentPane().add(panel_1);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("C:\\Users\\Nho Xuan\\Documents\\NetBeansProjects\\Laptrinhmang\\icon\\admin_banner.gif"));
        panel_1.add(label);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 114, 739, 294);
        frmAdmin.getContentPane().add(tabbedPane);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(SystemColor.menu);
        tabbedPane.addTab("Student Account", (Icon) null, panel_3, null);
        panel_3.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 714, 120);
        panel_3.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
//                txt_ID_student.setText(table.getValueAt(row, 0).toString());
                txt_user_student.setText(table.getValueAt(row, 1).toString());
                txt_email_student.setText(table.getValueAt(row, 2).toString());
                txt_pass_student.setText(table.getValueAt(row, 3).toString());
            }
        });
        table.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportView(table);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(230, 230, 250));
        panel_2.setBorder(UIManager.getBorder("TitledBorder.border"));
        panel_2.setBounds(10, 142, 714, 113);
        panel_3.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblUsername.setBounds(22, 24, 75, 14);
        panel_2.add(lblUsername);

        txt_user_student = new JTextField();
        txt_user_student.setBounds(107, 22, 117, 20);
        panel_2.add(txt_user_student);
        txt_user_student.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEmail.setBounds(248, 26, 75, 14);
        panel_2.add(lblEmail);

        txt_email_student = new JTextField();
        txt_email_student.setBounds(341, 24, 117, 19);
        panel_2.add(txt_email_student);
        txt_email_student.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPassword.setBounds(475, 24, 75, 19);
        panel_2.add(lblPassword);

        txt_pass_student = new JTextField();
        txt_pass_student.setBounds(557, 24, 117, 19);
        panel_2.add(txt_pass_student);
        txt_pass_student.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnAdd.setBounds(80, 68, 89, 23);
        panel_2.add(btnAdd);

        JButton btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEdit.setBounds(223, 68, 89, 23);
        panel_2.add(btnEdit);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnDelete.setBounds(376, 68, 89, 23);
        panel_2.add(btnDelete);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txt_user_student.setText(null);
                txt_email_student.setText(null);
                txt_pass_student.setText(null);
            }
        });
        btnReset.setBounds(538, 68, 89, 23);
        panel_2.add(btnReset);
    }

    void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
