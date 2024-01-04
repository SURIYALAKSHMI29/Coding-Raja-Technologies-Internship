package library_management;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class report_book {
    JFrame frame = new JFrame("Report Page");
    JLabel L1, L2, L3;
    JButton B1, B2, B3, B4;
    JScrollPane jScrollPane2;
    JTable jTable1;
    public report_book() {
        frame.setVisible(true);
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        L1 = new JLabel();
        L2 = new JLabel();
        B1 = new JButton();
        B2 = new JButton();
        B3 = new JButton();
        L3 = new JLabel();
        jScrollPane2 = new JScrollPane();
        jTable1 = new JTable();
        B4 = new JButton();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Font f = new Font("Comic Sans MS", 1, 13);
        lib_ope obj = new lib_ope(); 
        
        L1.setFont(new java.awt.Font("Times New Roman", 3, 12));
        L1.setText("Suriya BookStore");

        L2.setFont(new Font("Times New Roman", 1, 20)); 
        L2.setText("REPORTS");

        B1.setFont(f); 
        B1.setText("Show Book Details");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                obj.rec(jTable1,1,0);
                L3.setText("Displaying the available book Details...");
                L3.setFont(f);
            }
        });

        B2.setFont(f); 
        B2.setText("Show Unreturned Books");
        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                obj.rec(jTable1,2,1);
                L3.setText("Displaying unreturned books Details...");
                L3.setFont(f);
            }
        });

        B3.setFont(f); 
        B3.setText("Borrowing History");
        B3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                obj.rec(jTable1,2,2);
                L3.setText("Displaying Books returned History");
                L3.setFont(f);
            }
        });

        L3.setFont(new java.awt.Font("Comic Sans MS", 3, 14));
        jScrollPane2.setViewportView(jTable1);

        B4.setFont(f); 
        B4.setText("EXIT");
        B4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new exit(frame);
            }
        });

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(L1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(L2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(L3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(B1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(B2)
                .addGap(46, 46, 46)
                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(B4)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(L1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(L2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(B1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addComponent(B2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                    .addComponent(B3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(L3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B4)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frame.pack();
    } 

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
    }                                  

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                                          
}
