package Java.Examen.ProcessMac.src;

import java.io.InputStream;

/**
 * ProcessMac
 */
public class ProcessMac {
    public static void main(String[]args) {
        try {
            Process p = new ProcessBuilder("CMD","/C","getmac").start();
            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1)
                System.out.print((char) c);
                is.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}