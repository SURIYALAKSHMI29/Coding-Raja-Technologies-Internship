package library_management;
import java.sql.*;
import java.text.*;
import java.time.LocalDate;
import static java.util.Date.parse;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class lib_ope 
{
    static String url = "jdbc:mysql://localhost:3306/library";
    static lib_ope obj = new lib_ope();
    public static void main(String args[]) throws ClassNotFoundException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    
    int check(String name, String author, String cus, double ph) throws SQLException
    {
        Connection c = DriverManager.getConnection(url,"root","Laksh_29");
        Statement st = c.createStatement();
        String query = "select * from book";
        ResultSet rs = st.executeQuery(query);
        LocalDate date = LocalDate.now();
        while(rs.next())
        {
            if(rs.getString(3).equalsIgnoreCase(author) && rs.getString(2).equalsIgnoreCase(name))
            {    
                if(rs.getString(5).equals("Y"))
                {
                    int id = rs.getInt(1);
                    st.executeUpdate("Update book SET Status='N' where id="+id);
                    st.executeUpdate("INSERT INTO borrow (book_id, customer, phone_number, borrow_date, return_date, return_status, fine) " +
                     "VALUES (" + id + ", '" + cus + "', " + ph + ", '" + date + "', NULL, 'N', 0)");
                    return 1;
                }
            }
        }
        c.close();
        return 0;
    }  
    
    int fine_cal(int d1, int m1, int d2, int m2)
    {
        int fine = 0;
        if(m1!=m2)
        {
            int m=m2-m1;
            int n1=m/2;
            int n2=m-n1;
            d2+=1*n1+30*n2;
        }
        d2-=15;
        if(d2>d1)
            fine = (d2-d1)*50;
        return fine;
    }
    
    int return_b(String name,String author, String cus, int fine, LocalDate return_date) throws SQLException
    {
        int id=0;
        float f1 = (float) (fine*1.0);
        Connection c = DriverManager.getConnection(url,"root","Laksh_29");
        Statement st = c.createStatement();
        
        String query1 = "select * from book";
        ResultSet rs1 = st.executeQuery(query1);
        while(rs1.next())
        {
            if(rs1.getString(3).equalsIgnoreCase(author) && rs1.getString(2).equalsIgnoreCase(name))
            {
                id = rs1.getInt(1);
                st.executeUpdate("Update book SET status='Y' where id="+id);
                break;
            }
        }
        
        String query2 = "select * from borrow";
        ResultSet rs2 = st.executeQuery(query2);
        while(rs2.next())
        {
            if(rs2.getString(3).equalsIgnoreCase(cus) && rs2.getInt(2)==id)
            {
                st.executeUpdate("Update borrow SET return_status='Y', Fine="+fine+", return_date='"+return_date+"' where book_id="+id);
                return 1;
            }
        }
        c.close();
        return 0;      
    }
    
    void rec(JTable t, int n, int m) {
        try {
            Connection c = DriverManager.getConnection(url, "root", "Laksh_29");
            Statement st = c.createStatement();
    
            DefaultTableModel model = (DefaultTableModel) t.getModel();
            model.setRowCount(0); // Clear table first
    
            if (n == 1) { // Show available book details
                String query = "SELECT id, title, author, genre, status FROM book WHERE status = 'Y'";
                ResultSet rs = st.executeQuery(query);
    
                String[] colNames = {"ID", "Title", "Author", "Genre"};
                model.setColumnIdentifiers(colNames);
    
                while (rs.next()) {
                    String[] row = {
                        rs.getString("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre")
                    };
                    model.addRow(row);
                }
    
            } else if (n == 2) {
                String query = "SELECT b.book_id, bk.title, b.customer, b.phone_number, b.borrow_date, b.return_date, b.fine, b.return_status " +
                               "FROM borrow b JOIN book bk ON b.book_id = bk.id";
                ResultSet rs = st.executeQuery(query);
    
                if (m == 1) { // Show unreturned books
                    String[] colNames = {"Book ID", "Title", "Customer", "Phone Number", "Borrow Date"};
                    model.setColumnIdentifiers(colNames);
    
                    while (rs.next()) {
                        if (rs.getString("return_status").equals("N")) {
                            String[] row = {
                                rs.getString("book_id"),
                                rs.getString("title"),
                                rs.getString("customer"),
                                rs.getString("phone_number"),
                                rs.getString("borrow_date")
                            };
                            model.addRow(row);
                        }
                    }
    
                } else if (m == 2) { // Borrowing history
                    String[] colNames = {"Book ID", "Title", "Customer", "Phone Number", "Borrow Date", "Return Date", "Return Status", "Fine"};
                    model.setColumnIdentifiers(colNames);
    
                    while (rs.next()) {
                        String status = rs.getString("return_status");
                        String displayStatus = "Y".equals(status) ? "Returned" : "Not Returned";
                            String[] row = {
                                rs.getString("book_id"),
                                rs.getString("title"),
                                rs.getString("customer"),
                                rs.getString("phone_number"),
                                rs.getString("borrow_date"),
                                rs.getString("return_date"),
                                displayStatus,
                                rs.getString("fine")   
                            };
                            model.addRow(row);
                    }
                }
            }
    
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean addBook(String title, String author, String genre) {
        try {
            Connection conn = DriverManager.getConnection(url, "root", "Laksh_29");
            String query = "INSERT INTO book (title, author, genre, status) VALUES (?, ?, ?, 'Y')";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, genre);

            int result = pst.executeUpdate();
            conn.close();

            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    LocalDate getBorrowDate(String book, String author, String customer) {
        LocalDate date = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Laksh_29");
            String book_query = "SELECT id FROM book WHERE title=? AND author=?";
            PreparedStatement book_pst = con.prepareStatement(book_query);
            book_pst.setString(1, book);
            book_pst.setString(2, author);
            ResultSet book_rs = book_pst.executeQuery();
            int book_id = 0;
            if (book_rs.next()) {
                book_id = book_rs.getInt("id");
            } else {
                JOptionPane.showMessageDialog(null, "No such book found.");
                return null;
            }

            String query = "SELECT borrow_date, return_status FROM borrow WHERE book_id=? AND customer=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, book_id);
            pst.setString(2, customer);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String status = rs.getString("return_status");
                if (status.equals("N")) { // 0 = Not Returned
                        java.sql.Date sqlDate = rs.getDate("borrow_date");
                        date = sqlDate.toLocalDate();
                    } else {
                        JOptionPane.showMessageDialog(null, "This book has already been returned.");
                        return null;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No such borrow record found.");
                    return null;
                }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

}

