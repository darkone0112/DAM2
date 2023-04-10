package com.example.livedata;

import java.util.ArrayList;

public class ModelPrimo {

    private static ArrayList<Integer> numerosPrimos;








    public static int calcularPrimo(int menor, int mayor){
        int contador =0;
        numerosPrimos= new ArrayList<Integer>();
        for (int x = menor; x <= mayor; x++) {
            if (esPrimo(x)) {
                numerosPrimos.add(x);
                contador++;
            }
        }
        return contador;
    }
    public static ArrayList<Integer>devolverPrimos(int menor, int mayor){

        numerosPrimos= new ArrayList<Integer>();
        for (int x = menor; x <= mayor; x++) {
            if (esPrimo(x)) {
                numerosPrimos.add(x);
                
            }
        }
        return numerosPrimos;
    }


    public static boolean esPrimo(int numero) {
        // El 0, 1 y 4 no son primos
        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            // Si es divisible por cualquiera de estos números, no
            // es primo
            if (numero % x == 0)
                return false;
        }
        // Si no se pudo dividir por ninguno de los de arriba, sí es primo
        return true;
    }
}


