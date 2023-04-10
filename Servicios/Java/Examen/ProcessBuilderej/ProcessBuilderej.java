package Java.Examen.ProcessBuilderej;

import java.io.IOException;
import java.io.InputStream;

/**
 * ProcessBuilder
 */
public class ProcessBuilderej {
    public static void main(String[]args) {
        /*Try Exception handler needed to handle the possible exceptions*/
        try {
            /*Declare the Process as a new Process Builder and start it with .start()*/
            Process pb = new ProcessBuilder("CMD", "/C","DIR").start();
            /*Declare de InputStream to get the flow of characters that return the command executed by the process*/
            InputStream is = pb.getInputStream();
            /*Declare c as int number used in the iteration of the Stream and converted to character so it can be printed has letters*/
            int c;
            /*Iterate the Stream while c is possible to read, when is not, it return an -1 and the loop is stopped*/
            while ((c = is.read())!= -1) 
                System.out.print((char) c);
                is.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
