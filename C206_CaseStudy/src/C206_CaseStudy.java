
public class C206_CaseStudy {

	private static final int Option_ManageMember = 1;
	private static final int Option_ManageCategory = 2;
	private static final int Option_ManageCourse = 3;
	private static final int Option_ManageCourse_Schedule = 4;
	private static final int Option_ManageRegistration = 5;
	private static final int Option_Quit = 6;
	
	public static void main(String[] args) {
		
		
		int option = 0;
		
		while (option != Option_Quit) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == Option_ManageMember) {
				//Manage Members task - call method in class
				ManageMember.main(args);
			} else if (option == Option_ManageCategory) {
				//Manage Category task - call method in class
				ManageCategory.main(args);
			} else if (option == Option_ManageCourse) {
				//Manage Course task - call method in class
				ManageCourse.main(args);
			} else if (option == Option_ManageCourse_Schedule) {
				//Manage Course Schedule task - call method in class
				ManageCourse_Schedule.main(args);
			} else if (option == Option_ManageRegistration ) {
				//Manage Registration task - call method in class
				ManageRegistration.main(args);
			} else if (option == Option_Quit) {
				//Quit
				System.out.println("Thank you for using Course Management System!!");
				
			} else {
				//Invalid option entered
				System.out.println("Invalid Option");
			}
		}
	}
	
	public static void menu() {
		C206_CaseStudy.setHeader("Course Management System");
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
