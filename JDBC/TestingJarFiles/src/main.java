import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.table.DefaultTableModel;

public class main {
    public static void main(String[] args) {
        // Create a new instance of the Videogame class
        Videogame videogame = new Videogame();
        videogame.loadJDBC();
        videogame.conectar();

        // Create a JFrame to display the menu
        JFrame frame = new JFrame("Videogame Menu");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        
        frame.setVisible(true);
        // Create a JPanel to hold the menu options
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create the menu options
        JButton displayButton = new JButton("Display Videogames");
        JButton addButton = new JButton("Add Videogame");
        JButton updateButton = new JButton("Update Videogame");
        JButton deleteButton = new JButton("Delete Videogame");

        // Add the menu options to the panel
        panel.add(displayButton);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        // Add the panel to the frame
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(panel, gbc);

        // Create a table model for displaying the videogames
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Title");
        model.addColumn("Genre");
        model.addColumn("Studio");
        model.addColumn("Release Date");
        model.addColumn("Score");
        model.addColumn("Size");

        // Add action listeners for the menu options
        displayButton.addActionListener((ActionListener) new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame tableFrame = new JFrame("Videogames");
                tableFrame.setSize(800, 600);
                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                tableFrame.add(scrollPane);
                videogame.displayData(model);
                tableFrame.setVisible(true);
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                videogame.addVideogame();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                videogame.updateVideogame();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                videogame.deleteVideogame();
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}