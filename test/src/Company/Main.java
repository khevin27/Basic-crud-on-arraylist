package Company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	//Created a variable 
	private static ArrayList<DesignEngr> designEngrList; //Created a variable for aaraylist of designEngrList
	private static ArrayList<Manager>managerList; //Created a variable for aaraylist of managerList
	private static Scanner scan = new Scanner(System.in); //Created a variable for scanner
	private static boolean flag = true; //Created a variable for while loop
	private static int resultTemp = 0;
	private static int mainSelection = 0; 
	public static void main(String[] args) {
		designEngrList = new ArrayList<DesignEngr>(); //Create a instance of designEngrList ArrayList
		managerList = new ArrayList<Manager>(); //Create a instance of managerList ArrayList
		//Created a variable
		while(flag) {//Infinite while loop
			try {
				mainSelection = mainMethod();
					switch(mainSelection) {
					case 1: 
						addMethod();
						break;	
					case 2:
						deleteMethod();
						break;
					case 3:
						editMethod();
						break;
					default:
						flag = false;
						break;
					}
			} catch (InputMismatchException e) {
		        System.out.println("Invalid value!");
		    }
			flag = true;
		}
	}

	//Selection Of Main
	public static int mainMethod() {
		int mainSelection = 0; 
		System.out.println("Select your action : [1] Add Employee [2]Delete Employee [3]Design Engr Employee [0] Exit");
		mainSelection = scan.nextInt();
		scan.nextLine();
		return mainSelection;
	}
	
	//Selection of De/Manager
	public static int selectionMethod() {
		int selectEmployee = 0;
		System.out.println("Select your choice to Add : [1] Design Engr [2] Manager");
		selectEmployee = scan.nextInt();
		scan.nextLine();
		return selectEmployee;
	}
		
	//list of Employee DE
	public static void listOfEmployee() {
		int index = 0;
		if(designEngrList.size() != 0 || managerList.size() != 0) {
			for(DesignEngr employee4 : designEngrList) { //loop the arraylist of designEngrList
				System.out.println("["+(index+1)+"]"+employee4.getName()); //get the name that store in the arraylist
				index++;
			}
		}else {
			System.out.println("No employee to be edited!");
		}

	}
	
	//Add function
	public static void addMethod() {
		resultTemp = selectionMethod();
		if(resultTemp == 1) { // add Design engr.
			int number = addMultipleEmployee(); // ask how many will be added
			for(int i=0; i < number; i++) {
				DesignEngr newdesignEngrList = new DesignEngr(); //Create a instance of class object and new object every time that will run
				addInfo(newdesignEngrList); //call a method and send newdesignEngrList object
				designEngrList.add(newdesignEngrList); //add newdesignEngrList object to the arraylist of DesignEngr
				System.out.println("Employee was added");
			}
		}else if(resultTemp == 2) { // add Manager.
			Manager newManager = new Manager(); //Create a instance of class object and new object every time that will run
			addManagerInfo(newManager); //call a method and send newManager object
			managerList.add(newManager); //add newManager object to the arraylist of Manager
			System.out.println(newManager.toString()); //In the manager class it will print the info from toString method
		}else { //default for wrong selection
			System.out.println("Wrong input");
		}
	}
	
	//Delete function
	public static void deleteMethod() {
		if(designEngrList.size() != 0 || managerList.size() != 0) {
			resultTemp = selectionMethod();
			deleteEmployee(resultTemp);
		}else {
			System.out.println("No data of Employee");
		}
	}
	
	//Edit function
	public static void editMethod() {
		if(designEngrList.size() != 0 || managerList.size() != 0) {
			resultTemp = selectionMethod();
			if(resultTemp == 1 ) {
				editEmployee();
			}
			if(resultTemp == 2 ) {
				System.out.println("Manager");
			}
		}else {
			System.out.println("No data of Employee");
		}
	}

	//Loop for additional Employee
	public static int addMultipleEmployee() {
		int cntEmployee = 0;
		System.out.println("How many employee will be entered : ");
		cntEmployee = scan.nextInt();
		scan.nextLine();
		return cntEmployee;
	}

	//Template form for Employee
	public static void addInfo(Employee employee) { 
		//enter the information
		System.out.println("Enter Employee name : ");
		employee.setName(scan.nextLine());
		System.out.println("Enter Employee address : ");
		employee.setAddress(scan.nextLine());
		//The setter will automatically send the info to Employee class and hold the value
	}
	
	//Template form for manager
	public static void addManagerInfo(Manager manager){
		addInfo(manager); //it will call the method of addInfo and send the manager object
		int managerSelection;
		int addMore;
		System.out.println("Choose your Option [1] Add Employee [2] Skip");
		managerSelection = scan.nextInt();
		scan.nextLine();
		switch(managerSelection) {
			case 1:
				addEmployeeToManager(manager); //call the method and send manager object
				boolean flag1= true;
				while(flag1 == true) { //infinite loop
					System.out.println("Do you want to add more [1] yes [2] no");
					addMore = scan.nextInt();
					scan.nextLine();
					if(addMore ==  1) { //Addmore employee 
						addEmployeeToManager(manager); //call the method and send manager object
					}
					else {
						System.out.println("Thankyou");
						flag1 = false; // terminator the infinite loop
					}
				}
				break;
			default  :
				
				break;
		}

	}
	
	//Adding Employee to manager Function
	public static void addEmployeeToManager(Manager manager) {
		int selectNum = 0;
		listOfEmployee();
		System.out.println("Enter your employee number");
		selectNum = scan.nextInt();
		scan.nextLine();
		if( manager.getAllEmployee().contains(designEngrList.get(selectNum-1))) { //check the selected designEngrList if already exist in manager employee
			System.out.println("Already your employee");
		}
		else {
			manager.addDesignEngr(designEngrList.get(selectNum-1)); //call the method from manager class and send the select designEngrList info
		}
		
	}
	
	//Delete the Employee Function
	public static void deleteEmployee(int optionSelect) {
		int index = 0;
		int selectNum = 0;
		if(optionSelect == 1 ) {
			listOfEmployee();
			System.out.println("Select you Employee to delete");
			selectNum = scan.nextInt();
			for(Manager manager : managerList) {
				manager.deleteDesignEngr(designEngrList.get(selectNum-1));
			}
			designEngrList.remove(selectNum-1);
		}else if(optionSelect == 2 ) {
			for(Manager manager : managerList) {
				System.out.println("[" + (index+1) + "] " + manager.getName());
				index++;
			}
			System.out.println("Select you Employee to delete");
			selectNum = scan.nextInt();
			managerList.remove(selectNum - 1);
		}else {
			System.out.println("Wrong input");
		}
	}

	public static void editEmployee() {
		listOfEmployee();
		int selectNum = 0;
		System.out.println("Select you Employee to edited");
		selectNum = scan.nextInt();
		scan.nextLine();
		selectNum = selectNum - 1;
		addInfo(designEngrList.get(selectNum));
		//System.out.println(selectNum);
		//designEngrList.set(selectNum,designEngrList.get(selectNum));
	}

}
