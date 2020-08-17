
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19030407, Aug 17, 2020 5:47:53 PM
 */

public class CourseManagementSystem {

	public static void main(String[] args) {
		
		
		int option = 0;
		
		while (option != 6) {
			CourseManagementSystem.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				//Manage Members task - call method in class
				
			} else if (option == 2) {
				//Manage Category task - call method in class
				
			} else if (option == 3) {
				//Manage Course task - call method in class
				
			} else if (option == 4) {
				//Manage Course Schedule task - call method in class
				
			} else if (option == 5) {
				//Manage Registration task - call method in class
				
			} else if (option == 6) {
				//Quit
				
			} else {
				//Invalid option entered
				System.out.println("Invalid Option");
			}
		}
	}
	
	public static void menu() {
		CourseManagementSystem.setHeader("Course Management System");
		System.out.println("1. Manage Members");
		System.out.println("2. Manage Category");
		System.out.println("3. Manage Course");
		System.out.println("4. Manage Course_Schedule");
		System.out.println("5. Manage Registration");
		System.out.println("6. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
}





