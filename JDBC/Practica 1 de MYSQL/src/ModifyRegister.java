import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ModifyRegister {
    public static List<String> queries = new ArrayList<String>();
    public static void main(String[]args) {
        //QUERIES
        queries.add(query());
        queries.add("SELECT * FROM vendedores");
        Connection conn = null;
        try {
            // The MySQL Connector/J library must be on your classpath
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysqlclase", "VsCode", "2458");

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Loop Foor to iterate the diferents queries storage in the ArrayList
            for (String query : queries) {
                if (query.startsWith("UPDATE")) {
                    System.out.println("ojito");
                    stmt.executeUpdate(query);
                }else{
                    if (query.startsWith("SELECT")){
                        ResultSet rs = stmt.executeQuery(query);
                        // Iterate through the result set and print the results
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String nombre = rs.getString("nombre");
                            Date fecha = rs.getDate("fecha_ingreso");
                            float salario = rs.getFloat("salario");
                            System.out.println("id: " + id + "\n" + "nombre: " + nombre + "\n" + "fecha ingreso: " + fecha + "\n" + "salario: " + salario + "\n");
                        }
                    }
                }
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
    public static String query() {
        String query = "UPDATE vendedores SET salario = 18000 where id = 1;";
        System.out.println("");
        return query;
    }
}
