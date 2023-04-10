package Sockets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerSockets {
    public static void main(String[] args) throws IOException {
        AtomicBoolean isRunning = new AtomicBoolean(true);
        while (true) {
            isRunning.set(true);;
            try (ServerSocket serverSocket = new ServerSocket(3000)) {
                System.out.println("Server started and listening on port 3000...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
    
                BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);
    
                BufferedReader serverIn = new BufferedReader(new InputStreamReader(System.in));
                Thread inpuThread = new Thread(()-> {
                    while (isRunning.get()==true) {
                        String message = "";
                        try {
                            try {
                                message = clientIn.readLine();
                            } catch (Exception e) {
                                // TODO: handle exception

                            }
                            if(message.equals("Cliente: Exit from chat")){
                                System.out.println(message);
                                clientSocket.close();
                                isRunning.set(false);
                                serverSocket.close();
                                break;
                            }else{
                                System.out.println(message);
                                //clientOut.println("Server: " + message);
                                //clientOut.flush();
                            }
                        } catch (IOException e) {
                            isRunning.set(false);
                            e.printStackTrace();
                        }
                    }
                });
                inpuThread.start();
                while (isRunning.get()==true) {
                    String message = serverIn.readLine();
                    if(message.equals("exit")){
                        System.out.println("+++Server Shutdown+++");
                        clientOut.println("Server Disconnected");
                        clientOut.flush();
                        clientSocket.close();
                        isRunning.set(false);
                        break;
                    }else{
                        clientOut.println("Server: " + message);
                        clientOut.flush();
                    }
                }
            }   
        }
    }
}
