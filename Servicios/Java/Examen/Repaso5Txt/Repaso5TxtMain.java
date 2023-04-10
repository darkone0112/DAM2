package Java.Examen.Repaso5Txt;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Repaso5TxtMain {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String cadena = "";
        System.out.println("Introduzca una cadena: ");
        cadena = input.nextLine();
        if (cadena.isEmpty()) {
            System.out.println("cadena vacia");
            System.exit(1);
        }
        File salida = new File("C:/Users/D4Rk0n3/Desktop/DAM2/ServiciosProcesos/Java/Examen/Repaso5Txt/salida.txt");
        File path = new File("C:/Users/D4Rk0n3/Desktop/DAM2/ServiciosProcesos/Java/Examen/Repaso5Txt");
        ProcessBuilder pb = new ProcessBuilder("java", "Repaso5Txt.java",cadena);
        pb.directory(path);
        pb.redirectOutput(salida);
        pb.start();
    input.close();
    }
}
