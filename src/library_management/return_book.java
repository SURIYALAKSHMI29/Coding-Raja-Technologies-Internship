package library_management;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
public class return_book {
    JFrame frame = new JFrame();
    JLabel L1,L2, L3, L4, L5, L6, L7 ,L8, L9;
    JButton B1,B2,B3;
    JTextField jTextField1,jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8, jTextField9, jTextField10; 
    public return_book() {
        frame.setVisible(true);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    void initComponents(){
        L1 = new JLabel();
        L2 = new JLabel();
        L3 = new JLabel();
        L4 = new JLabel();
        L5 = new JLabel();
        L6 = new JLabel();
        L7 = new JLabel();
        L8 = new JLabel();
        L9 = new JLabel();
        B1 = new JButton();
        B2 = new JButton();
        B3 = new JButton();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jTextField8 = new JTextField();
        jTextField9 = new JTextField();
        jTextField10 = new JTextField();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Return Page");
        Font f = new Font("Times New Roman", 0, 13);
        Font f1=new Font("Times New Roman", 1, 12);
        frame.setFont(f); 

        L1.setFont(new Font("Times New Roman", 3, 12)); 
        L1.setText("Suriya BookStore");

        L2.setFont(new Font("Times New Roman", 3, 18)); 
        L2.setText("Thanks for choosing our Library, keep Learning more & more....");

        L3.setFont(new Font("Times New Roman", 1, 14));
        L3.setText("Enter the Borrowed Book Details");

        L4.setFont(f); 
        L4.setText("Book Name:");

        L5.setFont(f); 
        L5.setText("Author Name:");

        L6.setFont(f); 
        L6.setText("Your Name:");

        L7.setFont(f);
        L7.setText("Phone No:");

        L8.setFont(f); 
        L8.setText("Borrowed Date:");

        L9.setFont(f); 
        L9.setText("Returning Date:");

        B1.setFont(f1); 
        B1.setText("CANCEL");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.setVisible(false);
                new Welcome_Page2();
            }
        });

        B2.setFont(f1); 
        B2.setText("RETURN");
        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                lib_ope obj = new lib_ope();
                try
                {
                    int d1 = Integer.parseInt(jTextField5.getText());
                    int m1 = Integer.parseInt(jTextField6.getText());
                    //int y1 = Integer.parseInt(jTextField7.getText());
                    int d2 = Integer.parseInt(jTextField8.getText());
                    int m2 = Integer.parseInt(jTextField9.getText());
                    //int y2 = Integer.parseInt(jTextField10.getText());
                    int fine = obj.fine_cal(d1,m1,d2,m2);
                    String name = jTextField1.getText();
                    String author = jTextField2.getText();
                    String cus = jTextField3.getText();
                    int r = obj.return_b(name, author, cus, fine);
                    if(r==1)
                    {
                        if(fine!=0)
                            JOptionPane.showMessageDialog(frame,"Sorry due to late return, you've Fine amount of "+fine);
                        JOptionPane.showMessageDialog(frame,"Thanks for Visiting Us! Process is done Successfully");
                        frame.setVisible(false);
                        new Welcome_Page2();
                    }
                    else
                        JOptionPane.showMessageDialog(frame,"Sorry, provided Information is inappropriate! Check again");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(frame,"Inappropriate Dates");
                }
                
            }
        });

        B3.setFont(f1); 
        B3.setText("EXIT");
        B3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new exit(frame);
            }
        });

        jTextField1.setText("\t\t\t\t");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("  ");
        jTextField6.setText("  ");
        jTextField7.setText(" year ");
        jTextField8.setText("  ");
        jTextField9.setText("  ");
        jTextField10.setText(" year ");
        
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(B3)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(L7, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(L6, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(L5, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(L4, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(L8, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(L9, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField8, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                    .addComponent(jTextField5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField6, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jTextField7)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(B1)
                        .addGap(94, 94, 94)
                        .addComponent(B2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(L1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(L3, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(L1,GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(L2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(L3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(L4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 25,GroupLayout.PREFERRED_SIZE)
                    .addComponent(L5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(L6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(L7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(L8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addComponent(L9, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(B1)
                    .addComponent(B2))
                .addGap(45, 45, 45)
                .addComponent(B3)
                .addContainerGap())
        );

        frame.pack();
    }                                                                               
}