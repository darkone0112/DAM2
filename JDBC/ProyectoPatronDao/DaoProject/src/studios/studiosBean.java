package studios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

/**
 * studiosBean
 */
public class studiosBean {
    private String name;
    private String headQuarters;
    private int numberWorkers;
    private Date dateCreation;

    //JDBC Driver and MySql declaration
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://hostname:port/dbname?useSSL=false&serverTimezone=UTC";

    //  Database credentials
    static final String USER = "VsCode";
    static final String PASS = "2458";
    
    public void connect() {
        
        Connection conn = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Do something with the connection here, such as executing a query

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        

    }
}
