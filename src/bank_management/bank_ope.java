
package bank_management;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;

public class bank_ope {
    Font f = new Font("Comic Sans MS", 0, 13);
    Font f2 = new Font("Comic Sans MS", 1, 14);
    String query = "select * from account_details";
    Statement ope() throws SQLException, ClassNotFoundException 
    {
        
            String url = "jdbc:mysql://localhost:3306/bank_management";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(url,"root","Laksh_29");
            Statement st = c.createStatement();
            return st;
    }
}

class deposit extends bank_ope{
    JFrame frame = new JFrame("Deposit");
    JLabel L1, L2, L3;
    JButton B1, B2;
    JTextField TF1, TF2, TF3;
    deposit() {
        frame.setVisible(true);
        initComponents();
    }
                     
    void initComponents() {
        L1 = new JLabel();
        L2 = new JLabel();
        B1 = new JButton();
        B2 = new JButton();
        L3 = new JLabel();
        TF1 = new JTextField();
        TF2 = new JTextField();
        TF3 = new JTextField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        L1.setFont(f); 
        L1.setText("Account Number:");

        L2.setFont(f); 
        L2.setText("Amount:");
        
        L3.setFont(f); 
        L3.setText("Your Name:");
     
        B1.setFont(f2); 
        B1.setText("Deposit");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String acc = new String(TF1.getText());
                int bal, bal1, r=1;
                bal = Integer.parseInt(TF2.getText());
                bank_ope obj = new bank_ope();
                try{
                    Statement st = obj.ope();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next())
                    {
                        if(rs.getString(1).equals(acc))
                        {
                            r=2;
                            bal1 = rs.getInt(5);
                            st.executeUpdate("Update account_details SET balance="+(bal+bal1)+" where acc_no="+acc);
                            LocalDate date = LocalDate.now();
                            st.executeUpdate("insert into transact values('"+date+"','deposit','"+acc+"','"+new String(TF3.getText())+"',"+bal+")");
                            JOptionPane.showMessageDialog(frame,"Deposit is Successful");
                            break;
                        }
                    }
                    if(r==1)
                        JOptionPane.showMessageDialog(frame,"Deposit failed!");
                }
                catch(Exception e)
                {   e.printStackTrace();}
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
            layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(B2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(L1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(L2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(L3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(TF1)
                            .addComponent(TF2)
                            .addComponent(TF3))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(B1)
                        .addContainerGap(62, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF1, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(L1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TF2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(L3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(B1)
                    .addComponent(B2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        frame.pack();
    }                                                                          
}

class withdrawal extends bank_ope {
    JFrame frame = new JFrame("Withdrawal");
    JLabel L1, L2, L3, L4;
    JButton B1, B2;
    JTextField TF1, TF2, TF3;
    JPasswordField PF;
    public withdrawal() {
        super();
        frame.setVisible(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    void initComponents() {
        L1 = new JLabel();
        L2 = new JLabel();
        L3 = new JLabel();
        L4 = new JLabel();
        B1 = new JButton();
        B2 = new JButton();
        TF1 = new JTextField();
        TF2 = new JTextField();
        PF = new JPasswordField();
        TF3 = new JTextField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        L1.setFont(f); 
        L1.setText("Account Number:");

        L2.setFont(f); 
        L2.setText("Name:");

        L3.setFont(f); 
        L3.setText("Password:");

        L4.setFont(f); 
        L4.setText("Amount:");

        B1.setFont(f2); 
        B1.setText("Withdraw");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String acc = new String(TF1.getText());
                String pass = new String(PF.getPassword());
                int amt, bal1, r=1;
                amt = Integer.parseInt(TF3.getText());
                bank_ope obj = new bank_ope();
                try{
                    Statement st = obj.ope();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next())
                    {
                        if(rs.getString(1).equals(acc))
                        {
                            if(rs.getString(4).equals(pass))
                            {
                            r=2;
                            bal1 = rs.getInt(5);
                            st.executeUpdate("Update account_details SET balance="+(bal1-amt)+" where acc_no="+acc);
                            LocalDate date = LocalDate.now();
                            st.executeUpdate("insert into transact values('"+date+"','"+acc+"','Withdrawal','"+new String(TF2.getText())+"',"+amt+")");
                            JOptionPane.showMessageDialog(frame,"You withdrawed "+amt+" from the account "+acc);
                            }
                            else 
                                JOptionPane.showMessageDialog(frame,"Incorrect Password!");
                            break;
                        }
                    }
                }
                catch(Exception e)
                {   e.printStackTrace();}
                if(r==1)
                    JOptionPane.showMessageDialog(frame,"Withdrawal failed!");
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(L1)
                                        .addComponent(L3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(L2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
                            .addComponent(L4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(TF2, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                            .addComponent(PF, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF3, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(B2)
                        .addGap(54, 54, 54)
                        .addComponent(B1)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(L1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(L3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PF)
                        .addGap(1, 1, 1)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TF3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(L4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(B2)
                    .addComponent(B1))
                .addGap(29, 29, 29))
        );
        frame.pack();
    }                                                                           
}

class balance extends bank_ope {
    JFrame frame = new JFrame("Balance");
    JLabel L1, L2;
    JTextField TF;
    JPasswordField PF;
    JButton B1, B2;
    public balance() {
        super();
        frame.setVisible(true);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")    
    private void initComponents() {

        L1 = new JLabel();
        L2 = new JLabel();
        B1 = new JButton();
        B2 = new JButton();
        PF = new JPasswordField();
        TF = new JTextField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        L1.setFont(f); 
        L1.setText("Account No:");

        L2.setFont(f); 
        L2.setText("Password:");

        B1.setFont(f2); 
        B1.setText("Check Balance");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String acc = new String(TF.getText());
                String pass = new String(PF.getPassword());
                int r =1;
                bank_ope obj = new bank_ope();
                try{
                    Statement st = obj.ope();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next())
                    {
                        if(rs.getString(1).equals(acc) && rs.getString(4).equals(pass))
                        {
                            JOptionPane.showMessageDialog(frame,"Your current account balance is, "+rs.getInt(5));
                            r=2;
                            break;
                        }
                    }
                }
                catch(Exception e)
                {   e.printStackTrace();}
                if(r==1)
                    JOptionPane.showMessageDialog(frame,"Incorret account details!"); 
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(L2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(L1)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PF, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(TF)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(B1)))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(B2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(B2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(L1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(TF)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(L2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PF, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(B1)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        frame.pack();
    }                                         
}

class loan_app extends bank_ope{
    JFrame frame = new JFrame("Loan");
    JButton B1, B2;
    JLabel L1, L2, L3, L4, L5, L6;
    JTextField TF1, TF2;
    JPasswordField PF;
    public loan_app() {
        super();
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
        B2 = new JButton();
        B1 = new JButton();
        L6 = new JLabel();
        TF1 = new JTextField();
        PF = new JPasswordField();
        TF2 = new JTextField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        L1.setFont(f2); 
        L1.setText("Loan Application");

        L2.setFont(f); 
        L2.setText("Account No:");

        L3.setFont(f); 
        L3.setText("Password:");

        L4.setFont(f); 
        L4.setText("Annual Salary:");

        L5.setFont(new Font("Comic Sans MS", 2, 11)); 
        L5.setText("*Note: Interest is 5% of your Loan per Month");

        B2.setFont(new Font("Comic Sans MS", 1, 13)); 
        B2.setText("Back");
        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new back1(frame);
            }
        });

        B1.setFont(f2); 
        B1.setText("Apply");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String acc = new String(TF1.getText());
                String pass = new String(PF.getPassword());
                int amt, bal, r=1;
                amt = Integer.parseInt(TF2.getText());
                bank_ope obj = new bank_ope();
                try{
                    Statement st = obj.ope();
                    ResultSet rs = st.executeQuery(query);
                    while(rs.next())
                    {
                        if(rs.getString(1).equals(acc) && rs.getString(4).equals(pass))
                        {
                            r=2;
                            bal = rs.getInt(5);
                            String str2 = rs.getString(3);
                            if(bal<=amt/2){
                                int loan = bal/3;
                                st.executeUpdate("Update account_details SET balance="+(bal+loan)+" where acc_no="+acc);
                                LocalDate date = LocalDate.now();
                                st.executeUpdate("insert into transact values('"+date+"','loan','"+acc+"','"+str2+"',"+loan+")");
                                JOptionPane.showMessageDialog(frame,"Your loan amount "+loan+" has been sanctioned to the account "+acc);
                            }
                            else
                                JOptionPane.showMessageDialog(frame,"Sorry, your account doesn't meets our loan criteria!");
                            break;
                        }
                    }
                }
                catch(Exception e)
                {   e.printStackTrace();}
                if(r==1)
                    JOptionPane.showMessageDialog(frame,"Incorrect account Details"); 
            }
        });

        L6.setFont(new Font("Comic Sans MS", 2, 11)); 
        L6.setText(" Your Bank balance must have 50% of your Annual Income");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(L5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(L1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(B2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(B1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(L2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TF1)
                                    .addComponent(PF)
                                    .addComponent(TF2, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L6, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(L1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(B2)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(B1)
                .addGap(26, 26, 26)
                .addComponent(L5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(L6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        frame.pack();
    }                              
}
