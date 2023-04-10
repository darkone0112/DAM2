package Java.Examen.Repaso4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * repaso4.main
 */
public class repaso4main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int argsN = 0;
        System.out.println("Cuantos argumentos quieres pasar");
        argsN = input.nextInt();
        input.nextLine();
        String n = "";
        for (int i = 0; i < argsN; i++) {
            System.out.println("Introduzca argumento nº " + (i+1) + ": ");
            n = input.nextLine();
        }
        File path = new File("C:/Users/D4Rk0n3/Desktop/DAM2/ServiciosProcesos/Java/Examen/Repaso4");
        ProcessBuilder pb;
        if (argsN < 1) {
            pb = new ProcessBuilder("java","repaso4.java");
        } else {
            pb = new ProcessBuilder("java","repaso4.java",n);
        }
        
        pb.directory(path);
        Process p = pb.start();
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char)c);
        }
        is.close();
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de salida es: " + exitVal);
        } catch (Exception e) {
            // TODO: handle exception
        }
        input.close();
    }
}