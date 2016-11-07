package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.DoubleSummaryStatistics;
import java.util.StringJoiner;

public class MainClient {

    public static void main(String[] args) throws  Exception {
	// write your code here
        String operateur="";
        double ans=0;
        double value=0;

        //Préparation du datagramme
        DatagramSocket socket = new DatagramSocket();
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        DatagramPacket dp = new DatagramPacket(sendData, sendData.length);

        //mise en place d'un socket sur l'adresse local
        InetAddress IPAddress = InetAddress.getByName("localhost");


        //Gestion de la console pour la lecture des données de l'utilisateur
        BufferedReader consoleRead = new BufferedReader(new InputStreamReader(System.in));

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
            sendData = (ans + ";" + operateur + ";" + value).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 2000);
            socket.send(sendPacket);

            //Reception réponse
            socket.receive(dp);
            String ansStr = new String(dp.getData());
            ans = Double.valueOf(ansStr);
            ans = Double.valueOf(new String(dp.getData()));

            //Efface la console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            //System.out.println("OP = " + operateur + " et valeur = " + value);
        }
        socket.close();
    }
}
