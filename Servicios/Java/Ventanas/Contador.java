package Java.Ventanas;

import javax.swing.JLabel;

public class Contador implements Runnable{
    JLabel _salida;
    private static final long intervalo = 100;
    int cont = 0;
    public Contador (JLabel salida){
        _salida = salida;
    }

    @Override
    public void run(){
        while (true) {
            cont++;
            _salida.setText(Integer.toString(cont));
            try {
                Thread.sleep((intervalo));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
