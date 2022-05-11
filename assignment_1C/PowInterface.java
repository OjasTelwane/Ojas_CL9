// Creating a PowInterface interface
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PowInterface extends Remote {
	// Declaring the method prototype
	public double pow(double x, double y) throws RemoteException;
}

