package Java.Examen.RelojContador;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reloj extends JFrame{

	public Reloj() {
		super("Reloj");
		
		//Crea el FlowLayout
		setLayout(new FlowLayout());
		
		//Crea el Label
		JLabel l = new JLabel();
		l.setText("0");

		//Le da el valor 0 y lo anade
		getContentPane().add(l);
		
		//Crea boton de inicio
		JButton b = new JButton("¡Comienza!");
		getContentPane().add(b);
		
		//Crea objeto generico
		Object sync = new Object();
		
		//Crea contador
		Contador c = new Contador(l, sync);

		//Anade al Thread el contador (tiene metodo run) y lo crea
		Thread t = new Thread(c);

		//Inicia el thread (se para esperando el notify())
		t.start();
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				synchronized(sync) {

					//Activa el temporizador
					sync.notify();
				}
			}
		});
		
		//Crea el boton parar
		JButton bPara = new JButton("¡Para!");

		//Lo anade al panel
		getContentPane().add(bPara);

		//Al hacer click
		bPara.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//Activa la exception que dentro, tiene el metodo parar()
				t.interrupt();
			}
		});
		
		//asigna tamanios
		setSize(500,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {

		//main inicia reloj
		new Reloj();
	}
}