package Java.Examen.chunguisimo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class interprete {
    public static void main(String[] args) {
        String num = args[0];
        try{
            int randomN = ((int)(1+Math.random()*4));
            System.out.println("el numero aleatorio es: " + randomN);
            File path = new File("C:/Users/D4Rk0n3/Desktop/DAM2/ServiciosProcesos/Java/Examen/chunguisimo");
            ProcessBuilder pb = new ProcessBuilder("java", "ejecutor.java", num, Integer.toString(randomN));
            pb.directory(path);
            Process p = pb.start();
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1){
                System.out.print((char)c);
            }
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
