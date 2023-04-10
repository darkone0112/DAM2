public class MainClass {
    public static void main(String[] args) throws Exception {
        // Creamos una única instancia de impresora
        Impresora impresora = Impresora.instancia();
        
        Oficinista oficinista1 = new Oficinista("Oficinista 1", 3);
        Oficinista oficinista2 = new Oficinista("Oficinista 2", 4);
        Oficinista oficinista3 = new Oficinista("Oficinista 3", 5);
        Oficinista oficinista4 = new Oficinista("Oficinista 4", 6);
        
        Thread hilo1 = new Thread(oficinista1);
        Thread hilo2 = new Thread(oficinista2);
        Thread hilo3 = new Thread(oficinista3);
        Thread hilo4 = new Thread(oficinista4);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
        System.out.println("Todos los oficinistas han terminado de imprimir");
    }
 }

