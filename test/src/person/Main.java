package person;

import java.util.ArrayList;

public class Main {
	
	static person[] people = new person[3];

	public static void main(String[] args) {
		people[0] = new student("Sam1", "Mesosa1", "BS Computer Science1", 2021, 3.8);
		people[1] = new student("Sam2", "Mesosa2", "BS Computer Science2", 2021, 3.8);
		people[2] = new professor("Sam3", "Mesosa3", "Proffesor3", "Programming");
		System.out.println(people[1].toString());
	}

}
