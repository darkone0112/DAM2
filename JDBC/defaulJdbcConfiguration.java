package JDBC;
import java.sql.*;

public class defaulJdbcConfiguration {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // The MySQL Connector/J library must be on your classpath
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://host:port/database", "username", "password");

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Execute the SELECT statement and get the result set
            ResultSet rs = stmt.executeQuery("SELECT * FROM tablename");

            // Iterate through the result set and print the results
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the SELECT statement.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the MySQL Connector/J library.");
            e.printStackTrace();
        } finally {
            // Close the connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
