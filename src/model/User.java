package model;

public class User 
{
	String netid;
	String password;
	String firstname;
	String lastname;
	String role;
	String yearjoined;
	String program;	
	public User(){
		super();
	}
	
	public User(String NetId,String Password, String Role, String FirstName,String LastName, String YearJoined, String Program) {
		super();
		netid = NetId;
		this.firstname = FirstName;
		this.lastname = LastName;
		this.program = Program;
		this.yearjoined = YearJoined;
		this.role = Role;
	}

	public String getNetId() {
		return netid;
	}

	public void setNetId(String NetId) {
		netid = NetId;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}
	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String FirstName) {
		this.firstname = FirstName;
	}

	public String getLastName(String LastName) {
		return lastname;
	}

	public void setLastName(String LastName) {
		this.lastname = LastName;
	}
	public String getProgram(String Program) {
		return program;
	}

	public void setProgram(String Program) {
		this.program = Program;
	}
	public String getYearJoined(String YearJoined) {
		return yearjoined;
	}

	public void setYearJoined(String YearJoined) {
		this.yearjoined = YearJoined;
	}
	public String getRole(String Role) {
		return role;
	}

	public void setRole(String Role) {
		this.role = Role;
	}
	
}
