package person;

abstract class person {
	private String firstname;
	private String lastname;

	public person() {
		this.firstname = "";
		this.lastname = "";
		
	}
	public person(String firstname,String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "\n\t" + this.firstname + "\n\t" + this.lastname;
		
	}
	
}
