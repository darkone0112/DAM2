package Java.Examen.Repaso4;
public class repaso4 {
    public static void main(String[] args) {
        //System.out.println("ok");
        if (args.length < 1) {
            System.out.println("numero de argumentos menor a 1");
            System.exit(1);
        } else {
            try {
                if (Integer.parseInt(args[0])<0){
                    System.out.println("Entero menor que 0");
                    System.exit(3);
                }
            } catch (Exception e) {
                System.out.println("cadena");
                System.exit(2);
                // TODO: handle exception
            }
            System.out.println("otra situacion");
            System.exit(0);
            }
        }
    }
