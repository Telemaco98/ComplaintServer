package aplication;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Entity.Complaint;

public class ComplaintManager implements IComplaintManager, Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Complaint> complaints;	
	
	public ComplaintManager () { }
	
	@Override
	public void register(Complaint complaint) throws RemoteException {
		complaints.add(complaint);
	}

	@Override
	public ArrayList<Complaint> complaints() throws RemoteException {
		return complaints;
	}
}