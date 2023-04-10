import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ej5 {
    public File file = new File("texto.txt");
    public static void main(String[]args) {
        ejecutor(ej5a.PasarCadena());
        }
    public static void ejecutor(String cadena) {
        try {
            FileWriter writer = new FileWriter("texto.txt");
            /* cadena = input.nextLine(); */
            if (cadena.isEmpty()) {
                System.out.println("No hay cadena........");
                System.exit(1);
            } else {
                for (int i = 0; i < 5; i++) {
                    writer.write(cadena + "\n");
                }
                writer.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
