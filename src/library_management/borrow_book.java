package library_management;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class borrow_book extends JFrame {
    JButton b1, b2; 
    JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8;
    JTextField jTextField1, jTextField2, jTextField3, jTextField4;
    lib_ope obj = new lib_ope();
    public borrow_book() {
        setVisible(true);
        setTitle("Borrow Books");
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel4 = new JLabel();
        jTextField2 = new JTextField();
        b1 = new JButton();
        b2 = new JButton();
        jLabel5 = new JLabel();
        jTextField3 = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jTextField4 = new JTextField();
        jLabel8 = new JLabel();

        Font f = new Font("Times New Roman", 0, 14);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Times New Roman", 1, 20)); 
        jLabel1.setText("Enter Details of the Book...");

        jLabel2.setFont(new Font("Times New Roman", 3, 14)); 
        jLabel2.setText("Suriya BookStore");

        jLabel3.setFont(f); 
        jLabel3.setText("Book Name:");

        jLabel4.setFont(f); 
        jLabel4.setText("Author Name:");

        jTextField1.setText("");
        jTextField2.setText("");

        b1.setFont(f);  
        b1.setText("Cancel");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                new Welcome_Page2();
            }
        });

        b2.setFont(f); 
        b2.setText("Next");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String name = jTextField1.getText();
                String author = jTextField2.getText();
                String client = jTextField3.getText();
                double ph = Double.parseDouble(jTextField4.getText());
                try
                {
                    int res = obj.check(name,author,client,ph);
                    if(res==1)
                        JOptionPane.showMessageDialog(null,"Yeah,"+name+" book is available & book is borrowed successfully!");
                    else
                        JOptionPane.showMessageDialog(null,"Sorry,"+name+" book is not available at the moment! try again later");
                }
                catch(Exception e){}
                setVisible(false);
                new Welcome_Page2();
            }
        });

        jLabel5.setFont(f); 
        jLabel5.setText("Your Name:");

        jLabel6.setFont(new Font("Times New Roman", 1, 20)); 
        jLabel6.setText("Enter your details...");

        jLabel7.setFont(f); 
        jLabel7.setText("Phone Number:");
        
        jTextField3.setText("");
        jTextField4.setText("");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 2, 14)); 
        jLabel8.setText(" *Attention: Kindly Return the borrowed books within 15 Days, Otherwise Rupees 50 is fined per day!");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2,GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(b1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(b2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8,GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2,GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 26,GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 26,GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 26,GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }                                                                                             
}