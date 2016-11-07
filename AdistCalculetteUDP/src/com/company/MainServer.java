package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Plinio on 11.10.2016.
 */
public class MainServer {
    public static void main(String[] args) throws  Exception {

        double ans=0;
        double value=0;

        DatagramSocket serverSocket = new DatagramSocket(2000);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while(true) {
            //Lire la requête
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String str = new String( receivePacket.getData());
            System.out.println(str);
            if (str.equals("END")) //fin de la connexion
                break;

            //Récupèrer la requete de cacul
            //dont le fomrat est : val1;operateur;val2
            String[] pieces = str.split(";");
            ans = Double.valueOf(pieces[0]);
            value = Double.valueOf(pieces[2]);

            //traitement de l'opérateur
            switch (pieces[1]) {
                case "+":
                    ans += value;
                    break;
                case "-":
                    ans -= value;
                    break;
                case "*":
                    ans *= value;
                    break;
                case "/":
                    ans /= value;
                    break;
            }

            //renvoi de la réponse
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            str = String.valueOf(ans);
            sendData = str.getBytes();
            DatagramPacket sendPacket =
                 new DatagramPacket(sendData, str.length(), IPAddress, port);
            serverSocket.send(sendPacket);
        }

    }
}
