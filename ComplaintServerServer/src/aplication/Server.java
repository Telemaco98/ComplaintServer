package aplication;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		//Execute the module of remote reference (RMI Registry) 
		LocateRegistry.createRegistry(1099);
		
		//Instance 
		ComplaintManager complaintManager = new ComplaintManager();
		
		Naming.rebind("rmi://localhost/ComplaintManager", complaintManager);
		System.out.println("Servidor pronto e registrado no RMI Registry.");	
	}
}