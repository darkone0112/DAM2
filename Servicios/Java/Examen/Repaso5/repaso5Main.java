package Java.Examen.Repaso5;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class repaso5Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String cadena = "";
        System.out.println("Introduzca una cadena: ");
        cadena = input.nextLine();
        if (cadena.isEmpty()) {
            System.out.println("cadena vacia");
            System.exit(1);
        }
        File file = new File("C:/Users/D4Rk0n3/Desktop/DAM2/ServiciosProcesos/Java/Examen/Repaso5");
        ProcessBuilder pb = new ProcessBuilder("java","repaso5secundaria.java", cadena);
        pb.directory(file);
        Process p = pb.start();
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1){
            System.out.print((char)c);
        }
        is.close();
        input.close();
    }
}
