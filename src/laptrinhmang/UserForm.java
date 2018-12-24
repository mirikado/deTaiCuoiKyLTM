/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhmang;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author OS
 */
public class UserForm {

    public JFrame frmUser;

    // Dieu khien tab - xoa tab
    public JTabbedPane tabbedPane;

    public JPanel panel_1;
    private JInternalFrame internalFrame;

    // Dong ho va lich ngay
    private JLabel timeSystem;
    private JLabel timeSystemBD;
    private JLabel timeSystemTK;
    private JLabel calendarBD;
    private JLabel calendarTK;

    // Web trinh duyet
    private JPanel panel_36;
    private JFXPanel javafxPanel;

    //Questions
    private JDialog dialog;
    private JPanel p1, p2, p3;
    private JLabel[] arrayLabels;
    private JRadioButton[] arrayRButtons;
    private ButtonGroup[] arrayGroups;
    private JPanel[] arrayPanels;
    private CardLayout cl;
    private JLabel lb1, lb2;
    private JButton btn1, btn2;
    private Timer tim;
    private int t, s;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserForm window = new UserForm();
                    window.frmUser.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public UserForm() {
        initialize();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        clock();
        // Web trinh duyet
        initSwingComponents();
        loadJavaFXScene();
    }

    public final void clock() {
        Thread clock = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Calendar cal = new GregorianCalendar();
                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR_OF_DAY);
                        String thu;
                        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                        if (dayOfWeek == 1) {
                            thu = "Chủ nhật ";
                        } else {
                            thu = "Thứ " + Integer.toString(dayOfWeek);
                        }
                        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);

                        timeSystem.setText(hour + ":" + minute + ":" + second);
                        timeSystemBD.setText(hour + ":" + minute + ":" + second);
                        timeSystemTK.setText(hour + ":" + minute + ":" + second);
                        calendarBD.setText(thu + " ngày " + dayOfMonth + " tháng " + (month + 1) + " năm " + year);
                        calendarTK.setText(thu + dayOfWeek + " ngày " + dayOfMonth + " tháng " + (month + 1) + " năm " + year);
                        sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmUser = new JFrame();
        frmUser.setResizable(false);
        frmUser.setTitle("User Form");
        frmUser.setIconImage(Toolkit.getDefaultToolkit()
                .getImage("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\Apps-Aegisub-icon (1).png"));
        frmUser.setBounds(80, -1, 1191, 715);
        frmUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUser.getContentPane().setLayout(null);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(new Color(0, 0, 128));
        tabbedPane.setBounds(0, 0, 1189, 694);
        frmUser.getContentPane().add(tabbedPane);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JPanel home = new JPanel();
        tabbedPane.addTab("Home", new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\Home-icon.png"),
                home, null);
        home.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1184, 656);
        home.add(panel);
        panel.setLayout(null);

        JLabel label_3 = new JLabel("");
        label_3.setBounds(690, 39, 484, 140);
        panel.add(label_3);
        label_3.setIcon(new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\slogan.png"));

        JLabel label_4 = new JLabel("");
        label_4.setIcon(new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\title.png"));
        label_4.setBounds(550, 175, 700, 140);
        panel.add(label_4);

        JLabel label_1 = new JLabel("");
        label_1.setBounds(0, 0, 1183, 656);
        panel.add(label_1);
        label_1.setIcon(new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\background-trong.png"));

        JLabel label_5 = new JLabel("");
        label_5.setIcon(new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\cloud-2.gif"));
        label_5.setBounds(0, 0, 1183, 464);
        panel.add(label_5);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        timeSystem = new JLabel();
        timeSystem.setForeground(new Color(128, 0, 0));
        timeSystem.setFont(new Font("Tahoma", Font.BOLD, 20));

        JPanel test = new JPanel();
        tabbedPane.addTab("Test",
                new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\Control-Panel-icon (1).png"), test,
                null);
        test.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(204, 204, 255));
        panel_1.setBounds(0, 0, 1184, 122);
        test.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Bài kiểm tra");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 29));
        lblNewLabel_1.setBounds(510, 11, 200, 33);
        panel_1.add(lblNewLabel_1);

        JButton start = new JButton("Bắt đầu");
        start.setBounds(550, 60, 100, 100);
        start.setSize(110, 40);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frmUser, "Questions", true);
                dialog.setSize(400, 400);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setLocationRelativeTo(null);
                dialog.setLayout(new BorderLayout());

                p1 = new JPanel();
                p1.setLayout(new FlowLayout());
                lb1 = new JLabel("Wellcome to quiz");
                p1.add(lb1);

                cl = new CardLayout();
                p2 = new JPanel();
                p2.setLayout(cl);
                arrayPanels = new JPanel[10];
                //A series of panels on which will rotate and show questions and answers
                for (int i = 0; i < arrayPanels.length; i++) {
                    arrayPanels[i] = new JPanel();
                    p2.add(arrayPanels[i], String.valueOf(i));
                    arrayPanels[i].setLayout(new GridLayout(0, 1));
                }
                //Array RadioButtons with text
                arrayRButtons = new JRadioButton[40];
                for (int i = 0; i < arrayRButtons.length; i++) {
                    arrayRButtons[i] = new JRadioButton();
                    switch (i) {
                        case 0:
                            arrayRButtons[i].setText("Mesopotamia");
                            break;
                        case 1:
                            arrayRButtons[i].setText("Greece");
                            break;
                        case 2:
                            arrayRButtons[i].setText("China");
                            break;
                        case 3:
                            arrayRButtons[i].setText("Egypt");
                            break;
                        case 4:
                            arrayRButtons[i].setText("Kinshasa");
                            break;
                        case 5:
                            arrayRButtons[i].setText("Lagos");
                            break;
                        case 6:
                            arrayRButtons[i].setText("Ulan Bator");
                            break;
                        case 7:
                            arrayRButtons[i].setText("Abu Dhabi");
                            break;
                        case 8:
                            arrayRButtons[i].setText("United Kingdom");
                            break;
                        case 9:
                            arrayRButtons[i].setText("Norway");
                            break;
                        case 10:
                            arrayRButtons[i].setText("USA");
                            break;
                        case 11:
                            arrayRButtons[i].setText("Denmark");
                            break;
                        case 12:
                            arrayRButtons[i].setText("Step mom");
                            break;
                        case 13:
                            arrayRButtons[i].setText("Runaway Bride");
                            break;
                        case 14:
                            arrayRButtons[i].setText("Grease");
                            break;
                        case 15:
                            arrayRButtons[i].setText("Nothing Hill");
                            break;
                        case 16:
                            arrayRButtons[i].setText("Neil Armstrong");
                            break;
                        case 17:
                            arrayRButtons[i].setText("John Lenon");
                            break;
                        case 18:
                            arrayRButtons[i].setText("Martin Luter King");
                            break;
                        case 19:
                            arrayRButtons[i].setText("Winston Churchill");
                            break;
                        case 20:
                            arrayRButtons[i].setText("Mecca");
                            break;
                        case 21:
                            arrayRButtons[i].setText("Medina");
                            break;
                        case 22:
                            arrayRButtons[i].setText("Dubai");
                            break;
                        case 23:
                            arrayRButtons[i].setText("Riyadh");
                            break;
                        case 24:
                            arrayRButtons[i].setText("Spain");
                            break;
                        case 25:
                            arrayRButtons[i].setText("Venice");
                            break;
                        case 26:
                            arrayRButtons[i].setText("Portugal");
                            break;
                        case 27:
                            arrayRButtons[i].setText("Genoa");
                            break;
                        case 28:
                            arrayRButtons[i].setText("Holocaust");
                            break;
                        case 29:
                            arrayRButtons[i].setText("Perl Harbour");
                            break;
                        case 30:
                            arrayRButtons[i].setText("The attack on France");
                            break;
                        case 31:
                            arrayRButtons[i].setText("Blitzkrieg on Poland");
                            break;
                        case 32:
                            arrayRButtons[i].setText("Bon");
                            break;
                        case 33:
                            arrayRButtons[i].setText("Munich");
                            break;
                        case 34:
                            arrayRButtons[i].setText("Leipzig");
                            break;
                        case 35:
                            arrayRButtons[i].setText("Hamburg");
                            break;
                        case 36:
                            arrayRButtons[i].setText("Chile");
                            break;
                        case 37:
                            arrayRButtons[i].setText("East Timor");
                            break;
                        case 38:
                            arrayRButtons[i].setText("Portugal");
                            break;
                        case 39:
                            arrayRButtons[i].setText("Brazil");
                            break;
                    }
                }
                //Array button's groups 
                arrayGroups = new ButtonGroup[10];
                int j = 0;
                for (int i = 0; i < arrayGroups.length; i++) {

                    arrayGroups[i] = new ButtonGroup();

                    arrayGroups[i].add(arrayRButtons[j]);
                    arrayGroups[i].add(arrayRButtons[j + 1]);
                    arrayGroups[i].add(arrayRButtons[j + 2]);
                    arrayGroups[i].add(arrayRButtons[j + 3]);

                    j += 4;
                }
                //Labels array with questions
                arrayLabels = new JLabel[10];
                for (int i = 0; i < arrayLabels.length; i++) {
                    arrayLabels[i] = new JLabel();
                    switch (i) {
                        case 0:
                            arrayLabels[i].setText("The homeland of Olympics is");
                            break;
                        case 1:
                            arrayLabels[i].setText("What is the capital of Nigeria");
                            break;
                        case 2:
                            arrayLabels[i].setText("Which country have Greenland");
                            break;
                        case 3:
                            arrayLabels[i].setText("In which the film except \"Pretty Women\" acters are Julia Roberts and Richard Gere");
                            break;
                        case 4:
                            arrayLabels[i].setText("What is the first man on the moon?");
                            break;
                        case 5:
                            arrayLabels[i].setText("The capital city of Saudi Arabia");
                            break;
                        case 6:
                            arrayLabels[i].setText("Christopher Columbus come from ");
                            break;
                        case 7:
                            arrayLabels[i].setText("Which the event stated the United States to engage in war");
                            break;
                        case 8:
                            arrayLabels[i].setText("Which city was the capital in the unification of Germany");
                            break;
                        case 9:
                            arrayLabels[i].setText("In which country dictator Salazar was in power ");
                            break;
                    }
                }

                p3 = new JPanel();
                p3.setLayout(new FlowLayout());
                btn1 = new JButton("Next question");
                btn1.setEnabled(false);
                btn1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cl.next(p2);
                        btn1.setEnabled(false);
                        btn2.setEnabled(true);
                        t = 10;
                        lb2.setText(String.valueOf(t));
                        tim.start();
                        btn1.setText("Next question");
                    }
                });
                btn2 = new JButton("Answer on question");
                btn2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tim.stop();
                        btn1.setEnabled(true);

                        if (arrayRButtons[1].isSelected()
                                || arrayRButtons[5].isSelected()
                                || arrayRButtons[11].isSelected()
                                || arrayRButtons[13].isSelected()
                                || arrayRButtons[16].isSelected()
                                || arrayRButtons[23].isSelected()
                                || arrayRButtons[27].isSelected()
                                || arrayRButtons[29].isSelected()
                                || arrayRButtons[32].isSelected()) {
                            s += 10;
                            JOptionPane.showMessageDialog(null, "Correct");
                        } else if (arrayRButtons[36].isSelected()) {
                            s += 10;
                            JOptionPane.showMessageDialog(null, "Correct, you won: " + s + " points");
                            btn1.setText("Start again quiz");
                        } else if (arrayRButtons[33].isSelected()
                                || arrayRButtons[34].isSelected()
                                || arrayRButtons[35].isSelected()) {
                            JOptionPane.showMessageDialog(null, "Wrong, you won: " + s + " points");
                            btn1.setText("Start again quiz");
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong");
                        }
                        for (int i = 0; i < 10; i++) {
                            arrayGroups[i].clearSelection();
                        }
                        btn2.setEnabled(false);
                    }

                });
                t = 10;
                //Timer
                lb2 = new JLabel("10");
                tim = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (t > 0) {
                            t--;
                            lb2.setText(String.valueOf(t));
                        } else {
                            tim.stop();
                            JOptionPane.showMessageDialog(null, "Time's up");
                            btn2.setEnabled(false);
                            btn1.setEnabled(true);
                        }
                    }
                });
                p3.add(btn1);
                p3.add(btn2);
                p3.add(lb2);

                int q = 0;
                for (int w = 0; w < 10; w++) {

                    arrayPanels[w].add(arrayLabels[w]);
                    arrayPanels[w].add(arrayRButtons[q]);
                    arrayPanels[w].add(arrayRButtons[q + 1]);
                    arrayPanels[w].add(arrayRButtons[q + 2]);
                    arrayPanels[w].add(arrayRButtons[q + 3]);

                    q += 4;
                }

                dialog.add(p1, BorderLayout.NORTH);
                dialog.add(p2, BorderLayout.CENTER);
                dialog.add(p3, BorderLayout.SOUTH);

                cl.show(p2, "0");
                tim.start();
                dialog.setVisible(true);
            }
        });
        panel_1.add(start);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(10, 133, 1164, 510);
        test.add(panel_5);
        panel_5.setLayout(null);

        JLabel lblQuiz = new JLabel("");
        lblQuiz.setIcon(new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\2016-06-30_162846.jpg"));
        lblQuiz.setBounds(0, 0, 1300, 832);
        panel_5.add(lblQuiz);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        timeSystemTK = new JLabel("");
        timeSystemTK.setForeground(new Color(128, 0, 0));
        timeSystemTK.setFont(new Font("Tahoma", Font.BOLD, 20));
        timeSystemTK.setBounds(1011, 11, 150, 33);

        calendarTK = new JLabel();
        calendarTK.setForeground(new Color(128, 0, 0));
        calendarTK.setFont(new Font("Tahoma", Font.BOLD, 13));
        calendarTK.setBounds(940, 35, 650, 33);

        timeSystemBD = new JLabel("");
        timeSystemBD.setForeground(new Color(128, 0, 0));
        timeSystemBD.setFont(new Font("Tahoma", Font.BOLD, 20));
        timeSystemBD.setBounds(1011, 11, 150, 33);
        panel_1.add(timeSystemBD);

        calendarBD = new JLabel();
        calendarBD.setForeground(new Color(128, 0, 0));
        calendarBD.setFont(new Font("Tahoma", Font.BOLD, 13));
        calendarBD.setBounds(940, 35, 650, 33);
        panel_1.add(calendarBD);
    }

    // Tab trinh duyet internet + tab huong dan
    private void initSwingComponents() {
        javafxPanel = new JFXPanel();
        javafxPanel.setBounds(0, 0, 1184, 656);
        panel_36 = new JPanel();
        panel_36.setLayout(null);
        panel_36.add(javafxPanel);
        tabbedPane.addTab("Google",
                new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\Google-Chrome-icon.png"), panel_36);

        JPanel huong_dan = new JPanel();
        tabbedPane.addTab("Hướng dẫn",
                new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\tv-guide-2-icon.png"), huong_dan, null);
        huong_dan.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\OS\\Documents\\NetBeansProjects\\BCCK\\icon\\2016-06-30_162845.jpg"));
        lblNewLabel.setBounds(0, 0, 1174, 656);
        huong_dan.add(lblNewLabel);
    }

    private void loadJavaFXScene() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                BorderPane borderPane = new BorderPane();
                WebView webComponent = new WebView();
                webComponent.getEngine().load("http://google.com");
                borderPane.setCenter(webComponent);
                Scene scene = new Scene(borderPane);
                javafxPanel.setScene(scene);
                webComponent.autosize();
            }
        });
    }

    void show() {
        UserForm window = new UserForm();
        window.frmUser.setVisible(true);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
