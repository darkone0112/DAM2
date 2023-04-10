import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class primos extends JFrame implements ActionListener {
  private static final long serialVersionUID = 1L;
  private static final int ANCHO = 300;
  private static final int ALTO = 100;

  private JTextField txtNumero;
  private JButton btnComprobar;

  private Random rnd;
  private int numeroAleatorio;

  public primos() {
    setTitle("Adivina el número");
    setSize(ANCHO, ALTO);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    txtNumero = new JTextField(10);
    btnComprobar = new JButton("Comprobar");
    btnComprobar.addActionListener(this);

    JPanel pnlNorte = new JPanel();
    pnlNorte.add(txtNumero);
    pnlNorte.add(btnComprobar);

    add(pnlNorte, BorderLayout.NORTH);

    rnd = new Random();
    numeroAleatorio = rnd.nextInt(10) + 1;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int numeroIngresado = 0;
    try {
      numeroIngresado = Integer.parseInt(txtNumero.getText());
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(this, "Debe ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (numeroAleatorio == numeroIngresado) {
      JOptionPane.showMessageDialog(this, "Victoria!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(this, "Derrota.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public static void main(String[] args) {
    primos ventana = new primos();
    ventana.setVisible(true);
  }
}