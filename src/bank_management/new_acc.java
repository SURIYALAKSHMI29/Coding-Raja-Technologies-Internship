package bank_management;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Random;

public class new_acc {
    static JFrame frame = new JFrame("New Account");
    JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9;
    JTextField TF1, TF2, TF3, TF4, TF5;
    JButton B1, B2;
    JPasswordField PF1, PF2;
    
    public new_acc() {
        frame.setVisible(true);
        initComponents();
    } 
    @SuppressWarnings("unchecked")
    void initComponents() {
        L1 = new JLabel();
        L2 = new JLabel();
        L3 = new JLabel();
        L4 = new JLabel();
        L5 = new JLabel();
        L6 = new JLabel();
        L9 = new JLabel();
        TF1 = new JTextField();
        TF2 = new JTextField();
        TF3 = new JTextField();
        TF4 = new JTextField();
        TF5 = new JTextField();
        B1 = new JButton();
        L7 = new JLabel();
        L8 = new JLabel();
        B2 = new JButton();
        PF1 = new JPasswordField();
        PF2 = new JPasswordField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f1 = new Font("Times New Roman", 0, 14);
        Font f2 = new Font("Comic Sans MS", 1, 14);


        L1.setFont(new Font("Times New Roman", 1, 20)); 
        L1.setText("Enter the detatils below...");

        L2.setFont(f1);
        L2.setText("Customer Name:");

        L3.setFont(f1); 
        L3.setText("Aadhar Number:");

        L4.setFont(f1); 
        L4.setText("Phone Number:");

        L5.setFont(f1); 
        L5.setText("Address:");

        L6.setFont(f1); 
        L6.setText("Initial Deposit:");
        
        L7.setFont(f1); 
        L7.setText("Set Password:");

        L8.setFont(f1); 
        L8.setText("Confirm Password:");

        L9.setFont(new Font("Times New Roman", 2, 13)); 
        L9.setText("*Note: Initial Deposit must be atleast Rs.500/-");

        B1.setFont(f2); 
        B1.setText("Create Account");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                create();
            }
        });

        B2.setFont(f2); 
        B2.setText("Back");
        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new back1(frame);
            }
        });

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(B1)
                        .addGap(153, 153, 153))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(B2)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(L1, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(L8, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(L2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(TF1, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(TF2)
                            .addComponent(TF4)
                            .addComponent(TF5)
                            .addComponent(TF3)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(PF1, GroupLayout.Alignment.LEADING)
                                .addComponent(PF2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(L9, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(L2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(TF1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(L3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(L4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TF4, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(L5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(L6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF5, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PF1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L8, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PF2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(B1)
                .addGap(29, 29, 29)
                .addComponent(L9, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        frame.pack();
    }           
    
    String acc_no(){
        String acc = "SM";
        Random obj = new Random();
        int r1 = obj.nextInt(100);
        acc+= r1 + " ";
        
        int count=0;
        for(int i=0;i<8;i++)
        {
            if(count==4){
                acc+=" "+obj.nextInt(10);
                count=0;
            }
            else{
                acc+=obj.nextInt(10);
                count++;
            }
        }
        return acc;
    }
    
    void create()
    {
        String str1 = new String(PF1.getPassword());
        String str2 = new String(PF2.getPassword());
        if(str1.equals(str2))
        {   
            int bal = Integer.parseInt(TF5.getText());
            if(bal<500)
                JOptionPane.showMessageDialog(frame,"Sorry, Initial Balance must be atleast Rs.500!");
            else{
                String name = TF1.getText();
                String aadhar = TF2.getText();
                long ph = Long.parseLong(TF3.getText());
                String add = TF4.getText();
                String acc = acc_no();
                String url = "jdbc:mysql://localhost:3306/bank_management";
                try{   
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection c = DriverManager.getConnection(url,"root","Laksh_29");
                    Statement st = c.createStatement();
                    st.executeUpdate("insert into account_details values('"+acc+"','"+aadhar+"','"+name+"','"+str1+"',"+bal+",'"+add+"',"+ph+")");
                    JOptionPane.showMessageDialog(frame,"Account is created Successfully, Your account number is,"+acc);
                    JOptionPane.showMessageDialog(frame,"Thanks for chossing our Banking System!");
                    new back1(frame);
                }
                catch(ClassNotFoundException | SQLException e)
                {
                    e.getStackTrace();
                }
            }
        }
        else
            JOptionPane.showMessageDialog(frame,"Mismatch Password");
    }        
}