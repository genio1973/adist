package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.DoubleSummaryStatistics;

/**
 * Created by Plinio on 11.10.2016.
 */
public class MainServer {
    public static void main(String[] args)throws Exception {
        // write your code here
        double ans=0;
        double value=0;

        ServerSocket socServ = new ServerSocket(2000);

        while (true) {
            Socket soc = socServ.accept();
            BufferedReader pRead = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter pWrite = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);

            while (true)
            {
                String str = pRead.readLine();
                System.out.println(str);
                if(str.equals("END")) //fin de la connexion
                    break;

                //Récupèrer la requete de cacul
                //dont le fomrat est : val1;operateur;val2
                String[] pieces = str.split(";");
                ans = Double.valueOf(pieces[0]);
                value = Double.valueOf(pieces[2]);

                //traitement de l'opérateur
                switch (pieces[1])
                {
                    case "+": ans += value; break;
                    case "-": ans -= value; break;
                    case "*": ans *= value; break;
                    case "/": ans /= value; break;
                }

                //renvoi de la réponse
                pWrite.println(ans);

            }
            pRead.close();
            pWrite.close();
            soc.close();
        }

    }
}
