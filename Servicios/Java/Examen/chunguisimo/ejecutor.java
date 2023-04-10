package Java.Examen.chunguisimo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * ejecutor
 */
public class ejecutor {
    public static void main(String[] args) throws IOException {
        
        if (args.length == 0) {
            Scanner input = new Scanner(System.in);
            String num = "";
            System.out.println("Intenta adivinar el numero(0-9): ");
            num = input.nextLine();
            File path = new File("C:/Users/D4Rk0n3/Desktop/DAM2/ServiciosProcesos/Java/Examen/chunguisimo");
            ProcessBuilder pb = new ProcessBuilder("java","interprete.java",num);
            pb.directory(path);
            Process p = pb.start();
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            input.close();
            is.close();
        }else{
            System.out.println(args[0].charAt(0));
            System.out.println(args[1].charAt(0));
            if (args[1].equalsIgnoreCase(args[0])) {
                System.out.println("Has adivinado el numero, felicidades");
            } else {
                System.out.println("Has fallado mas suerte la proxima!!");
            }
        }
    }
}
