package Entity;

import java.io.Serializable;

public class Complaint implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String type;
	private String priority;
	private String local;
	private String governmentAgency;
	private String description;
	
	public Complaint (String type, String priority, String local, String governmentAgency, String description) {
		this.type 			  = type;
		this.priority 		  = priority;
		this.local 			  = local;
		this.governmentAgency = governmentAgency;
		this.description 	  = description;
	}
	
	public String getType() {
		return type;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public String getLocal() {
		return local;
	}
	
	public String getGovernmentAgency() {
		return governmentAgency;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPriority(String priority) {
		this.priority = priority;
	}
}