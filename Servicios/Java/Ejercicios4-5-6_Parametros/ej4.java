import java.util.Scanner;

/**
 * ej4
 */
public class ej4 {
    public static int display() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Introduzca un Valor");
            String n = input.nextLine();
            /* boolean flag = false; */
            char valor = n.charAt(0);
            if (Character.isDigit(valor)) {
                if (valor < 0) {
/*                 System.exit(3);
 */                return 3;
                } else {
                    if (valor < 1) {
/*                     System.exit(1);
 */                    return 1;
                    } else {
/*                     System.exit(0);
 */                    return 0;
                    }
                }
            } else {
/*             System.exit(2);
 */            return 2;
            }
        }
    }
}