package Java.Examen.RelojContador;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.JLabel;

public class Contador implements Runnable {
	private static final long INTERVALO = 1;
	JLabel _salida;
	Object _sync;
	

	//Constructor recibe label y objeto
	public Contador(JLabel salida, Object sync) {
		_salida = salida;
		_sync = sync;
	}
	
	//Detiene el contador
	private void parar() {
		try {

			//Clave para que funcione, los siguientes parar() no acceden porque hay otro objecto en curso
			synchronized(_sync) {
				//Detiene el run() del objecto a la espera del notify()
				_sync.wait();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	//Devuelve el tiempo actual
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss.SSS");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
	
	//Contador y posee el metodo run
	@Override
	public void run() {
		
		//Detiene el temporizador para esperar el notify()
		parar();
		
		//Crea el objeto de la fecha
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.S");

		//
		while(true) {
			//cont++; lo hizo el profe con contador
			//_salida.setText(Integer.toString(cont));

			//Muestra salida del tiempo
			_salida.setText(getCurrentTimeStamp());
			
			try {

				//Controla la velocidad del contador (lo detiene milisegundos)
				Thread.sleep(INTERVALO);
				
				//Interrumpir el proceso provoca InterruptedException, activa metodo parar
			} catch (InterruptedException e) {
				
				//e.printStackTrace();
				parar();
			}
			
		}
	}
}
