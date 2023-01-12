import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Videogame {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void loadJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e);
        }
    }

    public void conectar() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/videogames", "VsCode", "2458");
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e);
        }
    }

    public void displayData(DefaultTableModel model) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM videogames");
            model.setRowCount(0);
            while (resultSet.next()) {
                model.addRow(new Object[] {
                    resultSet.getString("id"),
                    resultSet.getString("titulo"),
                    resultSet.getString("genero"),
                    resultSet.getString("estudio"),
                    resultSet.getString("fechaSalida"),
                    resultSet.getString("nota"),
                    resultSet.getString("peso")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error displaying data: " + e);
        }
    }
    public void addVideogame() {
        JTextField titleField = new JTextField();
        JTextField genreField = new JTextField();
        JTextField studioField = new JTextField();
        JTextField releaseDateField = new JTextField();
        JTextField scoreField = new JTextField();
        JTextField sizeField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Genre:"));
        panel.add(genreField);
        panel.add(new JLabel("Studio:"));
        panel.add(studioField);
        panel.add(new JLabel("Release Date:"));
        panel.add(releaseDateField);
        panel.add(new JLabel("Score:"));
        panel.add(scoreField);
        panel.add(new JLabel("Size:"));
        panel.add(sizeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add New Videogame", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                statement = connection.createStatement();
                String title = titleField.getText();
                String genre = genreField.getText();
                String studio = studioField.getText();
                String releaseDate = releaseDateField.getText();
                int score = Integer.parseInt(scoreField.getText());
                double size = Double.parseDouble(sizeField.getText());

                String query = "INSERT INTO videogames (titulo, genero, estudio, fechaSalida, nota, peso) VALUES ('" + title + "', '" + genre + "', '" + studio + "', '" + releaseDate + "', " + score + ", " + size + ")";
                statement.executeUpdate(query);
                System.out.println("Videogame added successfully.");
            } catch (SQLException e) {
                System.out.println("Error adding videogame: " + e);
            }
        }
    }
    public void updateVideogame() {
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField genreField = new JTextField();
        JTextField studioField = new JTextField();
        JTextField releaseDateField = new JTextField();
        JTextField scoreField = new JTextField();
        JTextField sizeField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Genre:"));
        panel.add(genreField);
        panel.add(new JLabel("Studio:"));
        panel.add(studioField);
        panel.add(new JLabel("Release Date:"));
        panel.add(releaseDateField);
        panel.add(new JLabel("Score:"));
        panel.add(scoreField);
        panel.add(new JLabel("Size:"));
        panel.add(sizeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Update Videogame", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                statement = connection.createStatement();
                int id = Integer.parseInt(idField.getText());
                String title = titleField.getText();
                String genre = genreField.getText();
                String studio = studioField.getText();
                String releaseDate = releaseDateField.getText();
                int score = Integer.parseInt(scoreField.getText());
                double size = Double.parseDouble(sizeField.getText());

                String query = "UPDATE videogames SET titulo='" + title + "', genero='" + genre + "', estudio='" + studio + "', fechaSalida='" + releaseDate + "', nota=" + score + ", peso=" + size + " WHERE id=" + id;
                statement.executeUpdate(query);
                System.out.println("Videogame updated successfully.");
            } catch (SQLException e) {
                System.out.println("Error updating videogame: " + e);
            }
        }
    }
    public void deleteVideogame() {
        JTextField idField = new JTextField();
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
    
        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Videogame", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                statement = connection.createStatement();
                int id = Integer.parseInt(idField.getText());
    
                String query = "DELETE FROM videogames WHERE id=" + id;
                statement.executeUpdate(query);
                System.out.println("Videogame deleted successfully.");
            } catch (SQLException e) {
                System.out.println("Error deleting videogame: " + e);
            }
        }
    }
}