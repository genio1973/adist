import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 * Created by Plinio on 07.11.2016.
 */
public class Calculatrice implements ICalculatrice {
    @Override
    public double Add(double nb1, double nb2) throws RemoteException {
        return nb1 + nb2;
    }

    @Override
    public double Sub(double nb1, double nb2) throws RemoteException {
        return nb1 - nb2;
    }

    @Override
    public double Mul(double nb1, double nb2) throws RemoteException {
        return nb1 * nb2;
    }

    @Override
    public double Div(double nb1, double nb2) throws RemoteException {
        return (nb1 / nb2);
    }
}
