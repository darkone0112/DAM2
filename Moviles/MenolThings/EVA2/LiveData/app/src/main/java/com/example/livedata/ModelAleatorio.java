package com.example.livedata;

public class ModelAleatorio {

    public static final int MAX_TIME=1000;

    private int n;

    public ModelAleatorio () {
        n = 0;

    }

    public void generarAleatorio() {

        //Tarda en recibir la informacion
        esperarAleatorio();


        n = (int)(Math.random()*MAX_TIME);

    }

    public void esperarAleatorio() {

        try {

            Thread.sleep((long) (Math.random() * MAX_TIME));

        } catch (InterruptedException x) {
            x.printStackTrace();
        }
    }

    public int getAleatorio () {
        return n;
    }

}
