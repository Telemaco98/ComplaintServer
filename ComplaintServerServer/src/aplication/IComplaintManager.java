package aplication;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Entity.Complaint;

public interface IComplaintManager extends Remote{
	public void register (Complaint complaint) throws RemoteException;
	
	public ArrayList<Complaint> complaints () throws RemoteException;
}