import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.valueOf(args[1]);
        try {
            Socket sock = new Socket(host, port);
            InputStream in = sock.getInputStream();
            int readChar = 0;
            if (args.length == 2) {
                while ((readChar = in.read()) != -1) {
                    System.out.write(readChar);
                }
                
            } else if (args.length >= 3) {
                for (int i = 2; i < args.length; i++) {
                    String echo = args[i];
                    System.out.print(echo + " ");
                }
            }
            sock.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
