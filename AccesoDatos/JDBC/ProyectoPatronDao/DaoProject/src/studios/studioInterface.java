package studios;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface studioInterface {
    public void loadJDBC();
    public void connect();
    public ResultSet executeQuery(Connection conn, String query);
    public void displayAllStudios(Connection conn, DefaultTableModel model);
    public String getName();
    public void setName(String name);
    public String getHeadQuarters();
    public void setHeadQuarters(String headQuarters);
    public int getNumberWorkers();
    public void setNumberWorkers(int numberWorkers);
    public String getDateCreation();
    public void setDateCreation(String dateCreation);
    public Connection getConn();
    public void setConn(Connection conn);
    public Statement getStatement();
    public void setStatement(Statement statement);
    public void addStudio(Connection conn);
    public void updateStudio(Connection connection);
    public void deleteStudio(Connection conn);
}
