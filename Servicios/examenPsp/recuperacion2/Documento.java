public class Documento {
    private String contenido;
    private String origen;

    public Documento(String origen, int numDocumento) {
        this.contenido = "Contenido del documento " + numDocumento;
        this.origen = origen;
    }

    public String getContenido() {
        return contenido;
    }

    public String getOrigen() {
        return origen;
    }
}
