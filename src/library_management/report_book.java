package library_management;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class report_book {
    JFrame frame = new JFrame("Report Page");
    JLabel L1, L2, L3;
    JButton B1, B2, B3, B4, addBookBtn;
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
        addBookBtn = new JButton("Add Book");

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
                obj.rec(jTable1, 1, 0); // Show Book Details
                L3.setText("Displaying the available book details...");
                L3.setFont(f);
            }
        });

        B2.setFont(f); 
        B2.setText("Show Unreturned Books");
        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                obj.rec(jTable1, 2, 1); // Show Unreturned Books
                L3.setText("Displaying unreturned books details...");
                L3.setFont(f);
            }
        });

        B3.setFont(f); 
        B3.setText("Borrowing History");
        B3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                obj.rec(jTable1, 2, 2); // Show Borrowing History
                L3.setText("Displaying books borrowing history...");
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

        addBookBtn.setFont(f);
        addBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Open AddBookDialog when clicked
                new AddBookDialog(frame);
            }
        });

        frame.setLayout(new BorderLayout());  // Use BorderLayout to position the button
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));  // To align the button to the right
        buttonPanel.add(addBookBtn);  // Add the Add Book button to the panel

        frame.add(buttonPanel, BorderLayout.NORTH);  // Add button panel to the top (NORTH)
        
        JPanel contentPanel = new JPanel();
        GroupLayout layout = new GroupLayout(contentPanel);
        contentPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(L1)
                    .addComponent(L2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(B1)
                        .addComponent(B2)
                        .addComponent(B3))
                    .addComponent(L3)
                    .addComponent(jScrollPane2)
                    .addComponent(B4))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(L1)
                .addComponent(L2)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(B1)
                    .addComponent(B2)
                    .addComponent(B3))
                .addComponent(L3)
                .addComponent(jScrollPane2)
                .addComponent(B4)
        );

        frame.add(contentPanel, BorderLayout.CENTER);  // Add the content panel to the center

        frame.pack();
    } 
}

class AddBookDialog extends JDialog {
    private JTextField titleField, authorField, genreField;
    private JButton saveButton;

    public AddBookDialog(JFrame parent) {
        super(parent, "Add New Book", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Book Title:");
        titleField = new JTextField(20);
        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField(20);
        JLabel genreLabel = new JLabel("Genre:");
        genreField = new JTextField(20);
        saveButton = new JButton("Save");

        gbc.gridx = 0; gbc.gridy = 0; add(titleLabel, gbc);
        gbc.gridx = 1; add(titleField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(authorLabel, gbc);
        gbc.gridx = 1; add(authorField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(genreLabel, gbc);
        gbc.gridx = 1; add(genreField, gbc);

        gbc.gridx = 1; gbc.gridy = 4; add(saveButton, gbc);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText().trim();
                String author = authorField.getText().trim();
                String genre = genreField.getText().trim();
        
                if (title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
                    JOptionPane.showMessageDialog(AddBookDialog.this, "Please fill in all fields.", "Input Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                lib_ope obj = new lib_ope(); 
                boolean success = obj.addBook(title, author, genre);

                if (success) {
                    JOptionPane.showMessageDialog(AddBookDialog.this, "Book added successfully!");
                    dispose(); // or clear fields instead
                } else {
                    JOptionPane.showMessageDialog(AddBookDialog.this, "Failed to add book.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });        

        setVisible(true);
    }
}
