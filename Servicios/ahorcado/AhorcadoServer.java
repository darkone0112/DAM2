package ahorcado;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;

public class AhorcadoServer {

    // lista de palabras disponibles para jugar
    private static ArrayList<String> palabras = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {  
        // agregar palabras a la lista
        palabras.add("casa");
        palabras.add("conejo");
        palabras.add("perro");
        palabras.add("gato");

        // iniciar el servidor
        DatagramSocket socket = new DatagramSocket(80);
            System.out.println("Servidor iniciado");
            while(true) 
            {
                // esperar un paquete
                byte[] buffer = new byte[500];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                // obtener el mensaje del cliente
                String mensaje = new String(buffer).trim();

                // si el cliente envia el mensaje "iniciar"
                if(mensaje.equalsIgnoreCase("iniciar"))
                {
                    System.out.println("Jugador conectado");
                    // seleccionar una palabra aleatoria de la lista
                    Random random = new Random();
                    int indicePalabra = random.nextInt(palabras.size());
                    String palabraElegida = palabras.get(indicePalabra);

                    // mostrar la palabra
                    InetAddress direccionCliente = packet.getAddress();
                    int puertoCliente = packet.getPort();

                    byte[] data = palabraElegida.getBytes();
                    packet = new DatagramPacket(data, data.length, direccionCliente, puertoCliente);
                    // enviar paquete con la palabra al cliente
                    socket.send(packet);
                }
            }
        }    
    }

