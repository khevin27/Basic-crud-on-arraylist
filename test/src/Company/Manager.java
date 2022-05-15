package Company;

import java.util.ArrayList;

public class Manager extends Employee{

	private  ArrayList<DesignEngr> managerEmp;
	
	public Manager() {
		super();
		this.managerEmp = new ArrayList<DesignEngr>();
	}
	
	public Manager(String name, String address) {
		super(name, address);
		this.managerEmp = new ArrayList<DesignEngr>();
	}
	//method that will get the info copy of the DE
	public void addDesignEngr(DesignEngr employee) {
		this.managerEmp.add(employee); //it will add the DE info to managerEmp arraylist
	}

	//getter of the managerEmp arraylist
	public ArrayList<DesignEngr> getAllEmployee(){
		return (ArrayList<DesignEngr>) this.managerEmp.clone(); //create a clone of managerEmp arraylist
	}
	

	public void deleteDesignEngr(DesignEngr employee) {
		//String test = null;
		for(int i = 0; i <= managerEmp.size(); i++) {
			//for(DesignEngr deList : managerEmp) {
			//if(employee.equals(deList)) {
			if(employee.equals(managerEmp.get(i))) {
					managerEmp.remove(employee);
					break;
				}
		//	}
		}
		
	}
	
	//Overriding the format from employee class
	@Override
	public String toString() {
		String text = super.toString();
		for(DesignEngr employee : this.managerEmp) {
			text = text + "\n" + employee.toString();
		}
		return text;
	}









}
