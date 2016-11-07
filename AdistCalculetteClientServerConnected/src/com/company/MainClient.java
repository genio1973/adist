package com.company;

import java.io.*;
import java.net.Socket;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class MainClient  {

    public static void main(String[] args)throws Exception {
        //Préparation de la connexion et des pointeurs pour la lecture et l'écriture
        Socket soc = new Socket("localhost", 2000);
        BufferedReader pRead = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        PrintWriter pWrite = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);

        String operateur="";
        double ans=0;
        double value=0;

        //Scanner in = new Scanner(System.in);
        BufferedReader consoleRead=new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            System.out.println("ANS : " + ans);
            System.out.println("Op +, *, -, / (q to quit) : ");
            operateur = consoleRead.readLine();

            //Quitter sur l'opérateur conetant la lettre q
            if(operateur.contains("q") || operateur.contains("Q"))
                break;

            System.out.println("Valeur : ");
            value=Double.valueOf(consoleRead.readLine());

            //Envoi requete
            pWrite.println(ans + ";" + operateur + ";" + value) ;

            //Reception réponse
            ans = Double.valueOf(pRead.readLine());

            //Efface la console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("OP = " + operateur + " et valeur = " + value);

        }


        pWrite.println("END");
        pRead.close();
        pWrite.close();
        soc.close();

    }
}
