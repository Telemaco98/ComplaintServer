package aplication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Entity.Complaint;

@SuppressWarnings("serial")
public class ComplaintManager extends UnicastRemoteObject implements IComplaintManager {
	private ArrayList<Complaint> complaints;	
	
	protected ComplaintManager () throws RemoteException {
		super();
		complaints = new ArrayList<Complaint>();
	}
	
	@Override
	public void register(Complaint complaint) throws RemoteException {
		complaints.add(complaint);
	}

	@Override
	public ArrayList<Complaint> complaints() throws RemoteException {
		return complaints;
	}
}