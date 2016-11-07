import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Plinio on 07.11.2016.
 */
public class MainServer{
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(8080);
        while (true) {
            Socket soc = s.accept();
            BufferedReader plec = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter pred = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
            while (true) {
                String str = plec.readLine();
                if (str.equals("END"))
                    break;
                pred.println(str);
            }
            plec.close();
            pred.close();
            soc.close();
        }
    }
}