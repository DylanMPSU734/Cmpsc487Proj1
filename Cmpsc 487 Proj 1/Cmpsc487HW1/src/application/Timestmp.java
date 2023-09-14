package application;

import java.time.LocalDateTime;
import java.sql.Timestamp;

public class Timestmp {
	private int id;
	private String name;
	private Timestamp stamp;
	
	public Timestmp(int id, String name, Timestamp stamp) {
		this.id = id;
		this.name = name;
		this.stamp = stamp;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Timestamp getStamp() {
		return stamp;
	}
}

