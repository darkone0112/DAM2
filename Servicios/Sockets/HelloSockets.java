package Sockets;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

/**
 * HelloSockets
 */
public class HelloSockets {
    public static void main(String []args) {
        try {
            Socket con  = new Socket("192.168.115.14",1234);
            BufferedOutputStream out = new BufferedOutputStream(con.getOutputStream());
            out.write("Hello World".getBytes());
            out.close();
            con.close();
        }
        catch (ConnectException d){
            System.out.println("Conexion Rechazada");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}