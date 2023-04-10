//create a client udp that sends a message to the server
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        Scanner input = new Scanner(System.in);

        String sentence;
        boolean done = false;
        while (!done) {
            sentence = input.nextLine();
            if (sentence.equals("exit()")) {
                done = true;
            } else {
                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                System.out.println("FROM SERVER:" + modifiedSentence);
            }
        }
        clientSocket.close();
    }
}
