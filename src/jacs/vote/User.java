package jacs.vote;

public class User {
	
	private String name;
	private String type;
	private int point;
	
	public User(String name, String type, int point){
		this.name = name;
		this.type = type;
		this.point = point;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPoint() {
		return point;
	}
	
	public String getType() {
		return type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
