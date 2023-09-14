package application;

public class ID {
	private int ID;
	private String name;
	private String type;
	private String status;
	
	public ID (int ID, String name, String type, String status) {
		this.ID = ID;
		this.name = name;
		this.type = type;
		this.status = status;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public String getStatus() {
		return status;
	}
}
