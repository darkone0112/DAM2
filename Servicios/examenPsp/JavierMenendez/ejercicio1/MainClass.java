package ejercicio1;
import java.net.*;
import java.util.Scanner;

public class MainClass {
    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]) {
        int portReceive = Integer.parseInt(args[0]);
        int portSend = Integer.parseInt(args[1]);
        //Scanner para probar desde Visual sin tener que compilar todo el rato
/*         int portReceive = input.nextInt();
        int portSend = input.nextInt(); */
        try {
            DatagramSocket receive = new DatagramSocket(portReceive);       
            byte[] buffer = new byte[512];
            while (true) {
                System.out.println("Escuchando...");
                DatagramPacket request = new DatagramPacket(buffer, buffer.length); 
                receive.receive(request); 
                String dataReceived = new String(request.getData());
                System.out.println("Mensaje recibido: " + dataReceived);
                if(dataReceived.equalsIgnoreCase("fin")){
                    System.out.println("Fin del programa");
                    System.exit(0);
                }
                String[] dataReceivedArray = dataReceived.split(" ");
                int height = Integer.parseInt(dataReceivedArray[0]);
                int width = Integer.parseInt(dataReceivedArray[1]);
                char sign = dataReceivedArray[2].charAt(0);
                
                int area = height * width;
                String output = "[" + Integer.toString(area) + "]\n";

                for (int i = 0; i < height; i++) {
                    output += "\t\t";
                    for (int j = 0; j < width; j++) {
                        if(i == 0 || i == height - 1){
                            output += sign + " ";
                        }else{
                            if(j == 0 || j == width - 1){
                                output += sign + " ";
                            }else{
                                output += "  ";
                            }
                        }
                    }
                    output += "\n";
                }
                System.out.println(output);
                DatagramSocket send = new DatagramSocket(portSend);
                InetAddress host = InetAddress.getByName("255.255.255.255");
                byte [] dataSent = output.getBytes();
                DatagramPacket response = new DatagramPacket(dataSent, dataSent.length, host, portSend);
                send.send(response);
                System.out.println("Respuesta enviada a " + host + " en el puerto " + portSend);
            }
        } catch (Exception e) {
            System.out.println("Exception in thread \"main\" "+e);
        }
    }
}

