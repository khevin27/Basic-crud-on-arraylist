package person;

import java.util.ArrayList;

public class student extends person {
	private String major;
	private int graduationYear;
	private double gpa;
	
	
	public student() {
		super();
		this.major = "";
		this.graduationYear = 0;
		this.gpa = 0;
	}
	
	
	public student(String firstname, String lastname, String major, int graduationYear, double gpa) {
		super(firstname, lastname);
		this.major = major;
		this.graduationYear = graduationYear;
		this.gpa = gpa;
	}
	
	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public int getGraduationYear() {
		return graduationYear;
	}


	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		String text = super.toString();
		text = "Student details : "+ text + "\n\t" + this.major + "\n\t" + this.graduationYear + "\n\t" + this.gpa;
		return text;
	}

}
