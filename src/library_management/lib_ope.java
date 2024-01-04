package library_management;
import java.sql.*;
import java.text.*;
import java.time.LocalDate;
import static java.util.Date.parse;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class lib_ope 
{
    static String url = "jdbc:mysql://localhost:3306/suriya?zeroDateTimeBehavior=convertToNull";
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
                    st.executeUpdate("insert into borrow values("+id+",'"+cus+"','"+date+"','N',0,"+ph+")");
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
    
    int return_b(String name,String author, String cus, int fine) throws SQLException
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
                st.executeUpdate("Update book SET Status='Y' where id="+id);
                break;
            }
        }
        
        String query2 = "select * from borrow";
        ResultSet rs2 = st.executeQuery(query2);
        while(rs2.next())
        {
            if(rs2.getString(2).equalsIgnoreCase(cus) && rs2.getInt(1)==id)
            {
                st.executeUpdate("Update borrow SET Return_status='Y' where id="+id);
                st.executeUpdate("Update borrow SET Fine="+fine+" where id="+id);
                return 1;
            }
        }
        c.close();
        return 0;      
    }
    
    void rec(JTable t, int n, int m)
    {
        try{
           Connection c = DriverManager.getConnection(url,"root","Laksh_29");
            Statement st = c.createStatement();
            
            //available book info
            if(n==1)
            {
                String query = "select * from book";
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                DefaultTableModel model = (DefaultTableModel)t.getModel();
                model.setRowCount(0);
                int cols = rsmd.getColumnCount();
                String[] colName = new String[cols-1];
                for(int i=0;i<cols-1;i++)
                    colName[i] = rsmd.getColumnName(i+1); 
                model.setColumnIdentifiers(colName);
                String id, title, author, genre;
                while(rs.next()){
                    if(rs.getString(5).equals("Y"))
                    {
                        id = rs.getString(1);
                        title = rs.getString(2);
                        author = rs.getString(3);
                        genre = rs.getString(4);
                        String[] row = {id, title, author, genre};
                        model.addRow(row);
                    }
                }
            }
            
            //unreturned books & book transfer history
            if(n==2)
            {
                String query = "select * from borrow";
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                DefaultTableModel model = (DefaultTableModel)t.getModel();
                model.setRowCount(0);
//                String[] colName = {"Book Id", "Customer", "Date", "Phone No."};
//                model.setColumnIdentifiers(colName);
                String id, name, date, ph, return_status;
                while(rs.next()){
                    id = rs.getString(1);
                    name = rs.getString(2);
                    date = rs.getString(3);
                    ph = rs.getString(6);
                    return_status = rs.getString(4);
                    if(m==1 && return_status.equals("N"))
                    {
                        String[] colName = {"Book Id", "Customer", "Date", "Phone No."};
                        model.setColumnIdentifiers(colName);
                        String[] row = {id, name, date, ph};
                        model.addRow(row);
                    }
                    else if(m==2 && return_status.equals("Y"))
                    {
                        String[] colName = {"Book Id", "Customer", "Borrowed Date", "Phone No.","Fine"};
                        model.setColumnIdentifiers(colName);
                        String fine = rs.getString(5);
                        String[] row = {id, name, date, ph, fine};
                        model.addRow(row);
                    }
                }
            }
            
            c.close();
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
