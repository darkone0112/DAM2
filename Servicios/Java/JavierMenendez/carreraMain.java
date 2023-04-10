public class carreraMain {
    public static void main(String[] args) {
        corredor corredores[] = new corredor [10];
        Thread thread[] = new Thread[10];
        for (int i = 0; i < corredores.length; i++) {
            corredores[i] = new corredor(Integer.toString(i),1000,0,0);
            thread[i] = new Thread(corredores[i]);
        }
        for (int i = 0; i < corredores.length; i++) {
            thread[i].start();
        }
        
    }   
}
