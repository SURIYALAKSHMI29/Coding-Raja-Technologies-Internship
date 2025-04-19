package library_management;

import java.awt.Font;
import java.awt.event.*;
import java.time.LocalDate;
import javax.swing.*;

public class return_book {
    JFrame frame = new JFrame();
    JLabel L1, L2, L3, L4, L5, L6, L7;
    JButton B1, B2, B3;
    JTextField jTextField1, jTextField2, jTextField3, jTextField4;

    public return_book() {
        frame.setVisible(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    void initComponents() {
        L1 = new JLabel("Suriya BookStore");
        L2 = new JLabel("Thanks for choosing our Library, keep Learning more & more....");
        L3 = new JLabel("Enter the Borrowed Book Details");
        L4 = new JLabel("Book Name:");
        L5 = new JLabel("Author Name:");
        L6 = new JLabel("Your Name:");
        L7 = new JLabel("Phone No:");

        B1 = new JButton("CANCEL");
        B2 = new JButton("RETURN");
        B3 = new JButton("EXIT");

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();

        Font f = new Font("Times New Roman", 0, 13);
        Font f1 = new Font("Times New Roman", 1, 12);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Return Page");
        frame.setFont(f);

        L1.setFont(new Font("Times New Roman", 3, 12));
        L2.setFont(new Font("Times New Roman", 3, 18));
        L3.setFont(new Font("Times New Roman", 1, 14));
        L4.setFont(f);
        L5.setFont(f);
        L6.setFont(f);
        L7.setFont(f);
        B1.setFont(f1);
        B2.setFont(f1);
        B3.setFont(f1);

        B1.addActionListener(evt -> {
            frame.setVisible(false);
            new Welcome_Page2();
        });

        B2.addActionListener(evt -> {
            lib_ope obj = new lib_ope();
            try {
                String name = jTextField1.getText().trim();
                String author = jTextField2.getText().trim();
                String cus = jTextField3.getText().trim();

                LocalDate borrowDate = obj.getBorrowDate(name, author, cus);
                if (borrowDate == null) {
                    JOptionPane.showMessageDialog(frame, "No borrow record found. Please check the details.");
                    return;
                }

                LocalDate returnDate = LocalDate.now();

                int fine = obj.fine_cal(
                    borrowDate.getDayOfMonth(), borrowDate.getMonthValue(),
                    returnDate.getDayOfMonth(), returnDate.getMonthValue()
                );

                int r = obj.return_b(name, author, cus, fine, returnDate);
                if (r == 1) {
                    if (fine != 0)
                        JOptionPane.showMessageDialog(frame, "Sorry due to late return, you've Fine amount of " + fine);
                    JOptionPane.showMessageDialog(frame, "Thanks for Visiting Us! Process is done Successfully");
                    frame.setVisible(false);
                    new Welcome_Page2();
                } else {
                    JOptionPane.showMessageDialog(frame, "Sorry, provided Information is inappropriate! Check again");
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Something went wrong!");
            }
        });

        B3.addActionListener(evt -> new exit(frame));

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
                            .addGap(140, 140, 140)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(L7, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addComponent(L6, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addComponent(L5, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addComponent(L4, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                            .addGap(51, 51, 51)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3)
                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(169, 169, 169)
                            .addComponent(B1)
                            .addGap(94, 94, 94)
                            .addComponent(B2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addComponent(L1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                    .addComponent(L1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(L2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addComponent(L3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(L4))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(L5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(L6)
                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(L7))
                    .addGap(30, 30, 30)
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
