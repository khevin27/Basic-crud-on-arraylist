package person;

import java.util.ArrayList;

public class professor extends person {
	
	private String title;
	private String subject;
	
	
	public professor() {
		super();
		this.title = "";
		this.subject = "";
	}
	
	
	public professor(String firstname, String lastname,String title, String subject) {
		super(firstname, lastname);
		this.title = title;
		this.subject = subject;
	}


	public String getTitle() {
		return this.title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubject() {
		return this.subject;
	}


	public  void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		String text = super.toString();
		text = text + "\n\t" + this.title + "\n\t" + this.subject;
		return null;
		
	}
	
}
