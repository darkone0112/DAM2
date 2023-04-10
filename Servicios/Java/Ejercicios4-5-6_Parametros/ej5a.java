import java.util.Scanner;

public class ej5a {
    public static String PasarCadena() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Introduzca una cadena de texto: ");
            String cadena = input.nextLine();
            return cadena;
        }
    }
}
