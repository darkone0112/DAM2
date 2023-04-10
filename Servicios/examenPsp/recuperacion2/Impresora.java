
class Impresora {
    private static Impresora instance = null;
    private boolean estáImprimiendo = false;
    
    private Impresora() {}
    
    public static Impresora instancia() {
        if (instance == null) {
            instance = new Impresora();
        }
        return instance;
    }
    
    public synchronized void imprimir(Documento doc) throws InterruptedException {
        estáImprimiendo = true;
        System.out.print("IMPRIMIENDO: ");
        for (char c : doc.toString().toCharArray()) {
            /* System.out.print(c); */
            Thread.sleep(100); //esperar 100ms tras imprimir cada letra
        }
        System.out.println();
        estáImprimiendo = false;
    }
    
    public boolean estáImprimiendo() {
        return estáImprimiendo;
    }
 
    public void liberarImpresora() {
        estáImprimiendo = false;
    }
}
