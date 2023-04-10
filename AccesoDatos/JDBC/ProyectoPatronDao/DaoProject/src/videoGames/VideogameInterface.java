package videoGames;
//import DefaultTableModel from javax.swing.table
import javax.swing.table.DefaultTableModel;
//an interface class from the VideogameBean class
public interface VideogameInterface {
    public void loadJDBC();
    public void conectar();
    public void displayData(DefaultTableModel model);
    public void addVideogame();
    public void updateVideogame();
    public void deleteVideogame();
}
