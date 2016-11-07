package com.company;

import java.io.*;
import java.net.Socket;

public class MainClient {

    public static void main(String[] args) throws Exception {
	// write your code here
        Socket socket = new Socket("localhost", 1235);
        BufferedReader plec = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pecr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

        String str = "hello";

        for(int i=0; i<10; i++){
            pecr.println(str + i);
            str = plec.readLine();
            System.out.println(str);
        }
        pecr.println("END");
        pecr.close();
        plec.close();
        socket.close();

    }
}
