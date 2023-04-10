public class corredor implements Runnable{
    private String dorsal;
    private int distancia = 1000;
    private int avance;
    private int intervalo;

    public corredor(String dorsal, int distancia,int avance, int intervalo) {
        this.dorsal = dorsal;
        this.distancia = distancia;
        this.avance = avance;
        this.intervalo = intervalo;
    }
    @Override
    public void run() {
        
        while (distancia >= 0) {
            
            int random = (int)(50+Math.random()*50);
            avance = random;
            System.out.println("Dorsal: " + dorsal + "avanzo: " + avance + "metros");
            distancia -= avance;
            intervalo = random;
            if (distancia < 0) {
                System.out.println("He cruzado la meta y soy el dorsal: " + dorsal);
            }
            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        // TODO Auto-generated method stub
    }
}
 