package ahorcado;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class AhorcadoClient {
    // initialize socket and input stream 
    private static DatagramSocket socket ;
    private DataInputStream in;

    public AhorcadoClient() { 
        // initialize the socket
        try{
            socket = new DatagramSocket(90);
            System.out.println("Socket is now initialized");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            // Create a packet with the message "iniciar"
            byte[] sendData = new byte[1024];
            sendData = "6 6 a".getBytes();
            // Get the address of the server
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 80);
            // Send the packet to the server
            socket.send(sendPacket);

            // Read the response
            byte[] receivingData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receivingData, receivingData.length);
            // Receive the new packet from the server
            socket.receive(receivePacket);
            String receivedString = new String(receivePacket.getData());
            System.out.println("Received string:" + receivedString);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        AhorcadoClient c = new AhorcadoClient();
        c.run();
    }
}
