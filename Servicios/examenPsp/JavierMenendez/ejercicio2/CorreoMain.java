import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CorreoMain {
    public static final int NOMBRE_AUTH=0;
    public static final int NOMBREP_AUTH=1;
    public static final int CORREO_AUTH=2;
    private static final char[] alphabet = 
            "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static String readMessage(String fName) throws IOException {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fName));
            String line;
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
            return sb.toString();
        } finally {}
    }
    public static String[] readAddresses(String fName) throws IOException {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fName));
            String line;
            String[] addresses = new String[999];
            int count = 0;
            while((line = reader.readLine()) != null){
                addresses[count] = line;
                count++;
            }
            return addresses;
        } finally {}
    }
        public static void main(String[] args) {
            String messagesPath = args[0];
            String dirsPath = args[1];
            int initialCipherValue = Integer.parseInt(args[2]);
            String smtpUsername = args[3];
            String smptPassword = args[4];
            
            String messages = readMessage(messagesPath);

            List<String> messagesList = Arrays.asList(messages.split("\\r?\\n"));

            String addresses = readMessage(dirsPath);
            List<String> addressesList = Arrays.asList(addresses.split("\\r?\\n"));
            for (int i = 0; i < messagesList.size(); i++) {

                int newCipherValue = initialCipherValue + i;
                
                String message = messagesList.get(i);
                
                String encryptedMessage = encryptUsingCipher(message, newCipherValue);
                
                String address = addressesList.get(i);
                
                sendMessageWithSMTP(encryptedMessage, address, smtpUsername, smptPassword);
            }
        }
        private static String encryptUsingCipher(String s, int inc) {
            StringBuilder shiftedS = new StringBuilder();
            for (int i=0; i<s.length(); i++) { 
                char ch = s.charAt(i);
                int index = 0;
                for (int j=0;j<alphabet.length;j++) {
                    if (ch==alphabet[j]) {
                        index = j;
                    }
                }
                if (index+inc > 25) {
                    index = (index + inc) - 26; 
                } else {
                    index = index + inc;
                }
                shiftedS.append(alphabet[index]);
               }
            return shiftedS.toString(); 
        }
        private static void sendMessageWithSMTP(String message, String address, String smtpUsername, String smptPassword) {
            try {
                Email email = new SimpleEmail();
                //Eliges el sitio, puerto 
                email.setHostName("smtp.educa.madrid.org");
                email.setSmtpPort(587);
                email.setAuthentication(smtpUsername, smptPassword);
                email.setStartTLSEnabled(true);
                //Correo emisor
                email.setFrom(smtpUsername);
                //Subtitulo y mensaje
                email.setSubject("Cifrado");
                email.setMsg(message);
                //receptor y método de envío
                email.addTo(address);
                email.send();
                System.out.println("Email sent!");
            } catch (EmailException e) {
                e.printStackTrace();
            }
        }
    }
    
