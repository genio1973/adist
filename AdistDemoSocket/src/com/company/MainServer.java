package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Plinio on 10.10.2016.
 */
public class MainServer {
    public static void main(String[] args) throws Exception {
        // write your code here
        ServerSocket s = new ServerSocket(1235);

        while (true)
        {
            Socket soc = s.accept();
            BufferedReader plec = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter pecr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);

            while (true){
                String str = plec.readLine();
                System.out.println(str);
                if(str.equals("END"))
                    break;
                pecr.println(str);

            }
            plec.close();
            pecr.close();
            soc.close();
        }
    }

}
