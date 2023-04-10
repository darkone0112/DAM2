package ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
    /* Para probar el programa */

        try( DatagramSocket ds = new DatagramSocket();) {
            ds.setBroadcast(true);

            byte [] buffer = "fin".getBytes();
            String ip ="255.255.255.255";
            DatagramPacket p = new DatagramPacket(buffer
                                                    ,buffer.length
                                                    ,InetAddress.getByName(ip)
                                                    ,80
                                                 );
                ds.send(p);
        } catch (SocketException e) {
            e.printStackTrace();
        }  catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
