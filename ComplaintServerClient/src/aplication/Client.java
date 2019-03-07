package aplication;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import Entity.Complaint;

public class Client {
	
	public static void main(String[] args) throws RemoteException, 
	NotBoundException, MalformedURLException {
		System.out.println("Conectando...:");
		IComplaintManager stub = (IComplaintManager) Naming.lookup("rmi://192.168.43.28/ComplaintManager");
		System.out.println("depois:");
		
		// Variables
		String type;
		String local;
		String priority;
		String governmentAgency;
		String description;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Cadastro de Reclamação:");
		
		System.out.println("Tipo: ");
		type = input.next();
		
		System.out.println("Local: ");
		local = input.next();
		
		System.out.println("Prioridade: ");
		priority = input.next();
		
		System.out.println("Departamento: ");
		governmentAgency = input.next();
		
		System.out.println("Descrição: ");
		description = input.next();
		
		stub.register(new Complaint (type, priority, local, governmentAgency, description));
		
		ArrayList<Complaint> complaits = stub.complaints();
		
		// tests
		System.out.println(complaits.get(0).getType());
		System.out.println(complaits.get(0).getLocal());
		System.out.println(complaits.get(0).getPriority());
		System.out.println(complaits.get(0).getGovernmentAgency());
		System.out.println(complaits.get(0).getDescription());
		
		input.close();
						
	}
}