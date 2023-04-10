import java.sql.*;
public class Oracle {
    public static void main(String args[]) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ROOT", "2458");
        Statement sm = conn.createStatement();
        ResultSet rs
                = sm.executeQuery("SELECT * FROM EMP WHERE DEPTNO = 30");
        while (rs.next()) {
            int EMPNO = rs.getInt("EMPNO");
            String ENAME= rs.getString("ENAME");
            String JOB= rs.getString("JOB");
            int MGR= rs.getInt("MGR");
            Date FECHA= rs.getDate("HIREDATE");
            int SAL= rs.getInt("sAL");
            int COMM= rs.getInt("COMM");
            int DEPTNO= rs.getInt("DEPTNO");
            
            System.out.println("NUMERO DE EMPLEADO: "  + EMPNO + " NOMBRE: " + ENAME + " FUNCION:" + JOB+ " JEFE: "+
                    MGR+" FECHA DE INCORPORACION: "+ FECHA + " SALARIO: "+SAL+" COMISION: "+COMM+" DEPARTAMENTO: "+DEPTNO);
        }
        sm.close();
    }
}
