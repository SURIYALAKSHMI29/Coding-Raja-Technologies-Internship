package bank_management;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.awt.event.*;
import java.sql.*;

public class transaction {
    JFrame frame = new JFrame("Transaction");
    JLabel L1, L2, L3, L4, L5, L6;
    JTextField TF1, TF2, TF3, TF4;
    JButton B1, B2;
    JPasswordField PF;
    
    transaction() {
        frame.setVisible(true);
        L1 = new JLabel();
        L2 = new JLabel();
        L3 = new JLabel();
        L4 = new JLabel();
        L5 = new JLabel();
        L6 = new JLabel();
        B2 = new JButton();
        B1 = new JButton();
        PF = new JPasswordField();
        TF1 = new JTextField();
        TF2 = new JTextField();
        TF3 = new JTextField();
        TF4 = new JTextField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f = new Font("Comic Sans MS", 1, 13);
        Font f1 = new Font("Comic Sans MS", 1, 14);
        
        L1.setFont(new Font("Times New Roman", 3, 20)); 
        L1.setText("TRANSACTION");

        L2.setFont(f); 
        L2.setText("From Account:");

        L3.setFont(f); 
        L3.setText("To Account:");

        L4.setFont(f);
        L4.setText("Your Name:");

        L5.setFont(f); 
        L5.setText("Amount to be transfered:");

        L6.setFont(new java.awt.Font("Comic Sans MS", 3, 13)); 
        L6.setText("Password:");

        B2.setFont(f1); 
        B2.setText("Transfer");
        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String pass = new String(PF.getPassword());
                try{
                    bank_ope obj = new bank_ope();
                    Statement st = obj.ope();
                    
                    String query = "select * from account_details";
                    ResultSet rs = st.executeQuery(query);
                    int r1=0, r2=0, r3=0;
                    String acc1 = new String(TF1.getText());
                    String acc2 = new String(TF2.getText());
                    int bal, bal1=0, bal2=0;
                    bal = Integer.parseInt(TF4.getText());
                     
                    while(rs.next())
                    {   
                        if(rs.getString(1).equals(acc1))
                        {
                            r1=1;
                            bal1 = rs.getInt(5);
                            if(!(rs.getString(4).equals(pass)))
                            {
                                JOptionPane.showMessageDialog(frame,"Transaction Failed! Password Incorrect");
                                new back1(frame);
                                break;
                            }
                        }
                        if(rs.getString(1).equals(acc2))
                        {    
                            r2=1;
                            bal2 = rs.getInt(5);
                        }       
                        if(rs.getInt(5)>=bal)
                            r3=1;
                    }
                    if(r1!=r2)
                        JOptionPane.showMessageDialog(frame,"Transaction Failed! Check Account Numbers & try again.");
                    else if(r3!=1)
                        JOptionPane.showMessageDialog(frame,"Transaction Failed! Account Balance is Insufficient");
                    else
                    {
                        st.executeUpdate("Update account_details SET balance="+(bal1-bal)+" where acc_no="+acc1);
                        st.executeUpdate("Update account_details SET balance="+(bal+bal2)+" where acc_no="+acc2);
                        LocalDate date = LocalDate.now();
                        
                        st.executeUpdate("insert into transact values('"+date+"','"+acc1+"','"+acc2+"','"+new String(TF3.getText())+"',"+bal+")");
                        JOptionPane.showMessageDialog(frame,"Your Transaction is completed Successfully!");
                    }    
                }
               
                catch(ClassNotFoundException | SQLException e)
                {
                    e.getStackTrace();
                }
            }
        });

        B1.setFont(f1); 
        B1.setText("Back");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new back1(frame);
            }
        });

        TF4.setText("in numbers");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(L5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(B1)))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(B2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(TF4))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(L2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(L4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(TF3, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TF2)
                                    .addComponent(TF1)))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(L6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PF, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(L1)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(L1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(PF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(B2)
                    .addComponent(B1))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        frame.pack();
    }                           
}
