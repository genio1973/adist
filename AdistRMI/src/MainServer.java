import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/**
 * Created by Plinio on 07.11.2016.
 */
public class MainServer{
    public static void main(String[] args) throws Exception {
        try{
            ICalculatrice skeleton = (ICalculatrice) UnicastRemoteObject.exportObject(new Calculatrice(), 6000);
            Registry registry = LocateRegistry.createRegistry(6000);
            registry.rebind("Calculatrice", skeleton);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}