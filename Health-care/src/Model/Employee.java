package Model;

public class Employee {
	private String email;
	private String password;
	private String EmpId;
	private String name;
	private long phoneNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String EmpId) {
		this.EmpId = EmpId;
	}

}
