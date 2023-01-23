package studios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * studiosBean
 */
public class studiosBean {
    private String name;
    private String headQuarters;
    private int numberWorkers;
    private Date dateCreation;
    private Connection conn;
    private Statement statement;
    public void loadJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e);
        }
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/videogames", "VsCode", "2458");
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
        }
    }
    //method that connect to the database
    //contructors
    //default constructor
    public studiosBean() {
    }
    //constructor with
    //
    public studiosBean(String name, String headQuarters, int numberWorkers, Date dateCreation,Connection conn) {
        this.name = name;
        this.headQuarters = headQuarters;
        this.numberWorkers = numberWorkers;
        this.dateCreation = dateCreation;
        this.conn = conn;
    }
    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHeadQuarters() {
        return headQuarters;
    }
    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }
    public int getNumberWorkers() {
        return numberWorkers;
    }
    public void setNumberWorkers(int numberWorkers) {
        this.numberWorkers = numberWorkers;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    //getters and setters for the connection
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    //getters and setters for the statement
    public Statement getStatement() {
        return statement;
    }
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    /* Some Methods to work with the Database*/

    //method that execute a query
    public ResultSet executeQuery(Connection conn, String query) {
        statement = null;
        ResultSet rs = null;
        try {
            // Execute a query
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }/*  finally {
            try {
                if (statement != null)
                    statement.close();
                    rs.close();
            } catch (SQLException se2) {
            } // nothing we can do
            return rs;
        } */
        return rs;
    }

    //method that display all the data from studios table
    public void displayAllStudios(Connection conn, DefaultTableModel model) {
        String query = "SELECT * FROM studios";
        //execute the query using the method executeQuery
        ResultSet rs = executeQuery(conn, query);
        try {
            // Extract data from result set
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[] {
                    rs.getString("name"),
                    rs.getString("headquarters"),
                    rs.getString("numberWorkers"),
                    rs.getString("dateCreation"),
                });
            }
            // Clean-up environment
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error displaying data: " + e);
        }
    }
    //method that insert a new studio via GUI
    public void addStudio(Connection conn) {
        JTextField nameField = new JTextField();
        JTextField headquartersField = new JTextField();
        JTextField numberWorkersField = new JTextField();
        JTextField dateCreationField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("nombre:"));
        panel.add(nameField);
        panel.add(new JLabel("headquarters:"));
        panel.add(headquartersField);
        panel.add(new JLabel("numberWorkers:"));
        panel.add(numberWorkersField);
        panel.add(new JLabel("dateCreation:"));
        panel.add(dateCreationField);
        int result = JOptionPane.showConfirmDialog(null, panel, "Add New Videogame", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                statement = conn.createStatement();
                setName(nameField.getText());
                setHeadQuarters(headquartersField.getText());
                setNumberWorkers(Integer.parseInt(numberWorkersField.getText()));
                /* String dateString = getDateCreation().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null; */
                    /* date = sdf.parse(dateString); */
                /* } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Error parsing date: " + e);
                    e.printStackTrace();
                } */
                setDateCreation(null);
                String query = "INSERT INTO studios (name, headquarters, numberWorkers, dateCreation) VALUES ('" + getName() + "', '" + getHeadQuarters() + "', '" + getNumberWorkers() + ", " + getDateCreation() + ")";
                statement.executeUpdate(query);
                System.out.println("Videogame added successfully.");
            } catch (SQLException e) {
                System.out.println("Error adding videogame: " + e);
            }
        
        }
        }
    }


