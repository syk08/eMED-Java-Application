import java.sql.*;

public class remConn {
    public void insert_remval(int u_id, String m_name, int dos, String timee) {
        try {
            // 1) Register the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql:///firsttime", "root", "admin");

            Statement stmt = ((java.sql.Connection) conn).createStatement();

            String query = "Insert into reminder values('"+u_id+"','"+m_name+"','"+dos+"','"+timee+"')";
            int a = stmt.executeUpdate(query);
            if (a > 0) {
                    System.out.println("Data is inserted");
            } else {
                    System.out.println("Insertion failed");
            }
                stmt.close();
                ((java.sql.Connection) conn).close();
            

        } catch (SQLException e) {
            System.out.println(" Error while connecting to database. Exception code : " + e);
        } catch (ClassNotFoundException e) {
            System.out.println(" Failed to register driver. Exception code : " + e);
        } 
    }

    
}