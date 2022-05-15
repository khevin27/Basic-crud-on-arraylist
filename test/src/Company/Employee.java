package Company;

public class Employee {
	private String name;
	private String address;
	
	public Employee() {
		this.name = null;
		this.address = null;
	}
	
	public Employee(String name, String address) {
		this.name = name;
		this.address = address;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//format of the 
	@Override
	public String toString() {
		return "Name:\t" + this.name + "\nAddress:\t" + this.address;
	}
}
