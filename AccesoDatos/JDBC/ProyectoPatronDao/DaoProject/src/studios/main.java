package studios;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class main{
    public static void main(String[] args) {
        studioInterface DaoObject = studioGallery.getStudioDao();
        DaoObject.loadJDBC();
        DaoObject.connect();
        System.out.println(DaoObject.getConn());

        // Create a JFrame to display the menu
        JFrame frame = new JFrame("Studios Menu");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        // Create a JPanel to hold the menu options
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create the menu options
        JButton displayButton = new JButton("Display Studios");
        JButton addButton = new JButton("Add Studio");
        JButton updateButton = new JButton("Update Studio");
        JButton deleteButton = new JButton("Delete Studio");

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
        frame.setVisible(true);

        // Create a table model for displaying the videogames
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("name");
        model.addColumn("dateCreation");
        model.addColumn("headQuarters");
        model.addColumn("NumberWorkerss");    // Add action listeners for the menu options
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame tableFrame = new JFrame("Studios");
                tableFrame.setSize(800, 600);
                JTable table = new JTable(model);
                JScrollPane scrollPane = new JScrollPane(table);
                tableFrame.add(scrollPane);
                DaoObject.displayAllStudios(DaoObject.getConn(), model);
                tableFrame.setVisible(true);
            }
        });
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaoObject.addStudio(DaoObject.getConn());
                DaoObject.displayAllStudios(DaoObject.getConn(), model);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaoObject.deleteStudio(DaoObject.getConn());
                DaoObject.displayAllStudios(DaoObject.getConn(), model);
            }
        });
        //add update button action listener
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DaoObject.updateStudio(DaoObject.getConn());
                DaoObject.displayAllStudios(DaoObject.getConn(), model);
            }
        });
    }
}
