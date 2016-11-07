import com.sun.org.apache.regexp.internal.RE;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Plinio on 07.11.2016.
 */
public interface ICalculatrice extends Remote{
    public double Add (double nb1, double nb2) throws RemoteException;
    public double Sub (double nb1, double nb2) throws RemoteException;
    public double Mul (double nb1, double nb2) throws RemoteException;
    public double Div (double nb1, double nb2) throws RemoteException;
}
