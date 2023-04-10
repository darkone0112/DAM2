package Sockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSockets {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket("localhost", 3000)) {
            System.out.println("Connected to server.");

            BufferedReader serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter serverOut = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader clientIn = new BufferedReader(new InputStreamReader(System.in));

            Thread inpuThread = new Thread(()-> {
                while (true) {
                    String message = "";
                    try {
                        try {
                            message = clientIn.readLine();
                        } catch (Exception e) {
                            // TODO: handle exception

                        }
                        if(message.equals("Server Disconnected")){
                            System.out.println(message);
                            clientSocket.close();
                            break;
                        }else{
                            System.out.println(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            inpuThread.start();
            while (true) {
                String message = clientIn.readLine();
                if(message.equals("exit")){
                    serverOut.println("Cliente: Exit from chat");
                    serverOut.flush();
                    clientSocket.close();
                    break;
                }else{
                    serverOut.println("Cliente: " + message);
                    serverOut.flush();
                }
            }
        }
    }
}