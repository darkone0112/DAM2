package recuperacion1;
import java.util.*;
import java.util.concurrent.*;

public class MainClass {

    public static void main(String[] args) throws Exception {
        // Array con enteros al azar
        int[] randomInts = getRandomPrimeIntegers(256, 0, 1000);

        // Array de booleans para verificar (128 elementos)
        boolean[] checkBools = new boolean[128];
        
        // Crea tareas en threads que trabajan sólo con los índices asignados
        PrimeVerifierTask[] tasks = new PrimeVerifierTask[randomInts.length / 2];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new PrimeVerifierTask(randomInts, checkBools, i * 2);
        }

        // Crea un pool de threads y ejecuta las tareas
        ExecutorService executor = Executors.newFixedThreadPool(tasks.length);
        for (PrimeVerifierTask task : tasks) {
            executor.execute(task);
        }

        // Espera a que termine cada thread
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        // Contar el número de true en el array de booleans
        int countTrue = 0;
        for (boolean b : checkBools) {
            if (b) {
                ++countTrue;
            }
        }
        for (int i = 0; i < randomInts.length; i++) {
            System.out.println( randomInts[i]);
        }
        System.out.println("comprobacion");
        for (int i = 0; i < checkBools.length; i++) {
            System.out.println( checkBools[i]);
        }
        // Mostrar el % de los números primos sumados
        System.out.println();
        System.out.println("Números primos sumados detectados: " + countTrue + 
                           "/" + checkBools.length + " (" + ((float) countTrue / checkBools.length) * 100 + "%)");
    }

    /**
     * Genera un array aleatorio de enteros primos.
     */
    public static int[] getRandomPrimeIntegers(int size, int minValue, int maxValue){
        int[] primeInts = new int[size];
        Random randomGenerator = new Random();

        for (int i = 0; i < size; i++){
            int randomInt = randomGenerator.nextInt(maxValue-minValue) + minValue;
            while (!isPrime(randomInt)) {
                randomInt = randomGenerator.nextInt(maxValue-minValue) + minValue;
            }
            primeInts[i] = randomInt;
        }
        return primeInts;
    }

    /**
     * Verifica si un entero es primo.
     */
    public static boolean isPrime(int number){
        if (number<2){
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++){
                if (number%i==0){
                    return false;
                }
            }
            return true;
        }
    }
}

class PrimeVerifierTask implements Runnable {
    private int[] primeInts;
    private boolean[] checkBools;
    private int offsetIndex;

    public PrimeVerifierTask(int[] primeInts, boolean[] checkBools, int offsetIndex) {
        this.primeInts = primeInts;
        this.checkBools = checkBools;
        this.offsetIndex = offsetIndex;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < checkBools.length; i++) {
            int position = Math.min(i * 2 + offsetIndex, checkBools.length - 1);
            System.out.println("position: " + position);
            int firstNumber = primeInts[position];
            int secondNumber = primeInts[position + 1];
            int t = firstNumber + secondNumber;
            checkBools[i] = MainClass.isPrime(t);
        }
    }
}
