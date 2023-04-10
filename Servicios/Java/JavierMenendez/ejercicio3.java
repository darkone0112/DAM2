import java.io.IOException;
import java.io.InputStream;

/**
 * ejercicio3
 */
public class ejercicio3 {
    public static void main(String[] args) throws IOException {
    	String argumentos = "aux --header --sort -rss";
    	String filtros = "| grep -e USER -e javier";
        Process p = new ProcessBuilder("/bin/bash","-c","ps " + argumentos + filtros).start();
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char)c);
        }
        is.close();
    }   
}