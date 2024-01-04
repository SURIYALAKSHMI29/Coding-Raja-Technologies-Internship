/**
 *Library Management mini-project 
 * databases are linked- using MySQL
 * Features -> Borrow, return, reports
 * Welcome page, admin page
*/
package library_management;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
/*
@author_suriya
*/
public class Library_Management {
    public static void main(String[] args) 
    {
        new lib_book();
    }  
}
class lib_book implements ActionListener
{
    JFrame frame = new JFrame("Library Management");
    JLabel title, t2;
    JButton b,admin, exit;
    lib_book()
    {
        frame.setSize(700,500);
        frame.setVisible(true);
        frame.setLayout(null);
        Font f = new Font("TimesNewRoman",Font.BOLD+Font.ITALIC,28);
        Font f2 = new Font("Comic Sans MS",Font.BOLD,14);
        
        String str = "WELCOME TO SURIYA BOOKSTORE";
        title = new JLabel(str);
        title.setBounds(100,100,500,100);
        title.setFont(f);
        frame.add(title);
        
        t2 = new JLabel("Online Library Platform");
        t2.setBounds(170,180,375,80);
        t2.setFont(f);
        frame.add(t2);
        
        b = new JButton("Let's Go!");
        b.setBounds(250,300,180,30);
        b.setFont(f2);
        frame.add(b);
        b.addActionListener(this);
        
        exit = new JButton("Exit");
        exit.setBounds(550,400,80,30);
        exit.setFont(f2);
        frame.add(exit);
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
               new exit(frame);
            }
        });
        
        admin = new JButton("Admin");
        admin.setBounds(100,400,80,30);
        admin.setFont(f2);
        frame.add(admin);
        admin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
               frame.setVisible(false);
               new admin_page();
            }
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        frame.setVisible(false);
        new Welcome_Page2();
    }
}

class Welcome_Page2 extends JFrame{
    JButton jButton1, jButton2, exit_b;  
    JLabel L1;
    public Welcome_Page2() {
        setVisible(true);
        setTitle("Welcome Page");
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    void initComponents() {

        jButton1 = new JButton();
        jButton2 = new JButton();
        exit_b = new JButton();
        L1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(204, 255, 255));
        Font f = new Font("Times New Roman", 0, 12);

        jButton1.setFont(f); 
        jButton1.setText(" Borrow Book");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                new borrow_book();
            }
        });

        jButton2.setFont(f); 
        jButton2.setText("Return Book");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                new return_book();
            }
        });

        L1.setFont(new Font("Times New Roman", 1, 18)); 
        L1.setText("Welcome, what do you want to do?");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(L1)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(L1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        pack();
    }                                                                                       
}

class admin_page 
{
    JFrame frame = new JFrame();
    JLabel L1, L2,L3, L4,L5, L6, L7;
    JButton B1, B2;
    JTextField TF1;
    JPasswordField TF2;
    
    public admin_page() {
        frame.setVisible(true);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        L4 = new JLabel();
        L7 = new JLabel();
        L1 = new JLabel();
        L2 = new JLabel();
        L3 = new JLabel();
        L5 = new JLabel();
        L6 = new JLabel();
        B1 = new JButton();
        TF1 = new JTextField();
        TF2 = new JPasswordField();
        B2 = new JButton();

        L4.setText("jLabel4");

        L7.setFont(new Font("Times New Roman", 1, 14)); 
        L7.setText("Back");
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Admin page");
        Font f = new Font("Times New Roman", 0, 13);
        
        L1.setFont(new Font("Times New Roman", 3, 12)); 
        L1.setText("Suriya BookStore");

        L2.setFont(new Font("Times New Roman", 1, 20)); 
        L2.setText("Welcome to Admin Page");

        L3.setFont(new Font("Times New Roman", 0, 16)); 
        L3.setText("Enter Admin Credentials");

        L5.setFont(f);  
        L5.setText("Admin:");

        L6.setFont((f)); 
        L6.setText("Password:");

        B1.setFont(new Font("Times New Roman", 1, 16)); 
        B1.setText("Login");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String admin_name = "suriya";
                String password = "Laksh_29";
                String pass = new String(TF2.getPassword());
                if(TF1.getText().equalsIgnoreCase(admin_name) && pass.equals(password))
                {
                    frame.setVisible(false);
                    new report_book();
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Incorrect Login credentials!");
                }
            }
        });

        B2.setFont(new Font("Times New Roman", 1, 13)); 
        B2.setText("Back");
        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(false);
                new lib_book();
            }
        });

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(L1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(L3, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(L5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L6, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(TF1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(TF2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(L2, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(B1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(B2)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(L1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(L6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(B1,GroupLayout.PREFERRED_SIZE, 39,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(B2)
                .addGap(24, 24, 24))
        );

        frame.pack();
    }                                                                                                       
}

class exit
{
    public exit(JFrame frame)
    {
        JDialog d = new JDialog(frame,"Message",true);
                d.setLayout(new FlowLayout());
                JButton b = new JButton("Sure");
                b.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        d.setVisible(false);
                        frame.setVisible(false);
                        System.exit(0);
                    }
                });
                d.add(new JLabel("Thanks for Visiting Us!"));
                d.add(new JLabel("          Want to exit Suriya BookStore??           "));
                d.add(b);
                d.setSize(300,150);
                d.setVisible(true);
    }
}