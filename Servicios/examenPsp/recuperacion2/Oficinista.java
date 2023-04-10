
public class Oficinista implements Runnable {
    private String nombre;
    private int numDocumentos;

    public Oficinista(String nombre, int numDocumentos) {
        this.nombre = nombre;
        this.numDocumentos = numDocumentos;
    }

    public void run() {
        Impresora impresora = Impresora.instancia();
        synchronized (impresora) {
        for (int i = 0; i < numDocumentos; i++) {
                Documento doc = new Documento(nombre, i);
                try {
                    System.out.println("Oficinista " + nombre + " ha creado el documento " + i);
                    impresora.imprimir(doc);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

