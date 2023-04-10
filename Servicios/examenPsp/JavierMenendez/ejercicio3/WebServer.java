package ejercicio3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class WebServer {

   public static void main(String[] args) throws IOException {
    /* Hay un puerto de prueba para poder probar en VsCode sin compilar en consola */
      int port = Integer.parseInt(args[0]); 
        /* int port = 8080; */
      ServerSocket server = new ServerSocket(port);
      while(true) {
         Socket connection = server.accept(); 
         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
         String line = reader.readLine(); 
         String[] splitLine = line.split(" ");
         if (splitLine.length < 2 || !splitLine[0].equals("GET")) {
           continue; 
        }
         String path = splitLine[1];
         String[] params = path.split("/");

         int n;
         int m;

         if (params.length >= 3 && tryParseInt(params[1]) && tryParseInt(params[2])) {
            n = Integer.parseInt(params[1]);
            m = Integer.parseInt(params[2]);
         }
         else {
            continue;
         }
         sendHtmlResponse(connection, countPrimes(n,m));
         connection.close();
      }
   }
   private static boolean tryParseInt(String s) {
      try {
          int i = Integer.parseInt(s);
          return true;
      } catch (NumberFormatException e) {
          return false;
      }
   }
   private static List<Integer> countPrimes(int n, int m) {
      List<Integer> primes = new ArrayList<>();

      while (primes.size() != m) {
          if (isPrime(n)) {
              primes.add(n);
          }
          n++;
      }
      return primes;
   }
   private static boolean isPrime(int n) {
      if (n <= 1) {
          return false;
      }
      for (int i = 2; i < n; i++) {
          if (n % i == 0) {
              return false;
          }
      }
      return true;
   }
   private static void sendHtmlResponse(Socket connection, List<Integer> primes) throws IOException {
      StringBuilder body = new StringBuilder();

      body.append("<ul>\n");
      
      for (int prime : primes) {
        body.append("<li>")
            .append(prime)
            .append("</li>\n");
      }
      body.append("</ul>\n");
      String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + body;
      OutputStream output = connection.getOutputStream();
      output.write(httpResponse.getBytes("UTF-8"));
   }
}
