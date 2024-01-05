/* https://SURIYALAKSHMI29@github.com/SURIYALAKSHMI29/Coding-Raja-Technologies-Internship.git
 **Bank Management
 * create accounts
 * perform transaction between accounts
 * check balance & deposit 
 */
package bank_management;
/**
 * @author_suriya
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Bank_management {
    public static void main(String[] args){
        new bank();
    }
}
class bank 
{
    JFrame frame = new JFrame("Banking System");
    JButton B1, B2, B3, B4, B5, B6, B7;
    JLabel L1, L2;
    bank(){
        frame.setVisible(true);
        
        L1 = new JLabel();
        L2 = new JLabel();
        B1 = new JButton();
        B2 = new JButton();
        B3 = new JButton();
        B4 = new JButton();
        B5 = new JButton();
        B6 = new JButton();
        B7 = new JButton();
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font f1 = new Font("Comic Sans MS", 3, 20);
        Font f2 = new Font("Comic Sans MS", 1, 15);
        
        L1.setFont(f1); 
        L1.setText("WELCOME TO LAKSH BANK ");

        L2.setFont(f1); 
        L2.setText("- Online Banking System");

        B1.setFont(f2); 
        B1.setText("Create New Account");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new new_acc();
                frame.setVisible(false);
            }
        });

        B2.setFont(f2); 
        B2.setText("Transaction");
        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new transaction();
                frame.setVisible(false);
            }
        });

        B3.setFont(f2); 
        B3.setText("Withdrawal");
        B3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new withdrawal();
                frame.setVisible(false);
            }
        });

        B4.setFont(f2); 
        B4.setText("Deposit");
        B4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new deposit();
                frame.setVisible(false);
            }
        });

        B5.setFont(f2);
        B5.setText("Check Balance");
        B5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new balance();
                frame.setVisible(false);
            }
        });

        B6.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); 
        B6.setText("Apply Loan");
        B6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new loan_app();
                frame.setVisible(false);
            }
        });

        B7.setFont(f2); 
        B7.setText("Exit");
        B7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new exit(frame);
            }
        });

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(L2, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(L1)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(B6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(B5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(B4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(B3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(B2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(B1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(B7)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(L1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L2)
                .addGap(42, 42, 42)
                .addComponent(B1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(B7)
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
        JButton b1 = new JButton("Yes");
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                d.setVisible(false);
                frame.setVisible(false);
                System.exit(0);
            }
       });
        JButton b2 = new JButton("No");
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                d.setVisible(false);
            }
        });
        d.add(new JLabel("Thanks for Visiting Us!"));
        d.add(new JLabel("                  Do you want to Exit??                  "));
        d.add(b1);
        d.add(b2);
        d.setSize(300,150);
        d.setVisible(true);
    }
}

class back1{
    back1(JFrame frame)
    {
        frame.dispose();
        new bank();
    }
}