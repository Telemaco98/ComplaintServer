package aplication;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import Entity.Complaint;
import Entity.PriorityEnum;

public class Client {
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		try {
			
			IComplaintManager stub = (IComplaintManager) Naming.lookup("rmi://192.168.43.28/ComplaintManager");
			
			// Variables
			String type;
			String local;
			PriorityEnum priority = null;
			String governmentAgency;
			String description;
			
			System.out.println("Cadastro de Reclamacao:");
			
			System.out.println("Tipo: ");
			type = input.next();
			
			System.out.println("Local: ");
			local = input.next();
			
			for (;;) {
				System.out.println("Escolha a prioridade: ");
				System.out.println("1 - URGENTE");
				System.out.println("2 - ALTA");
				System.out.println("3 - MEDIA");
				System.out.println("4 - BAIXA");
				int priorityInt = input.nextInt();
				
				if (priorityInt >= 1 && priorityInt <= 4) {
					switch(priorityInt) {
						case 1:
							priority = PriorityEnum.URGENTE;
							break;
						case 2:
							priority = PriorityEnum.ALTA;
							break;
						case 3:
							priority = PriorityEnum.MEDIA;
							break;
						case 4:
							priority = PriorityEnum.BAIXA;
							break;
					}
					break;
				} else {
					System.out.println("Opção Invalida, digite novamente \n");
				}
			}
			
			System.out.println("Departamento: ");
			governmentAgency = input.next();
			
			System.out.println("Descricao: ");
			description = input.next();
			
			stub.register(new Complaint (type, priority, local, governmentAgency, description));
			
			ArrayList<Complaint> complaints = stub.complaints();
			
			for (Complaint c : complaints) {
				System.out.println(c.toString());
			}
			
		} catch (RemoteException | NotBoundException | MalformedURLException  e) {
			System.out.println("Conexao nao estabelicida. Encerrando o programa!");
		} finally {
			input.close();
		}					
	}
}