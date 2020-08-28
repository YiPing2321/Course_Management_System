import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19030407, Aug 22, 2020 7:32:15 AM
 */
//Done by Guang Hao.
public class ManageCourse_Schedule {

	//Refractor of the option
	private static final int Option_View = 1;
	private static final int Option_Add = 2;
	private static final int Option_Delete = 3;
	private static final int Option_Quit = 4;
	
	private static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
	
	public static void main(String[] args) {
		
		ArrayList<Course_Schedule> Course_ScheduleList = new ArrayList<Course_Schedule>();
		
		Course_ScheduleList.add(new Course_Schedule("CS001-R13", 25.0, LocalDateTime.parse("11/08/2020, 08:30", formatter1), 
				LocalDateTime.parse("12/08/2020, 16:00", formatter1), "W66L"));
		
		Course_ScheduleList.add(new Course_Schedule("CS002-R13", 14.0, LocalDateTime.parse("12/08/2020, 09:15", formatter1), 
				LocalDateTime.parse("13/08/2020, 15:30", formatter1), "W64J"));
		
		int option = 0;
		
		while (option != Option_Quit) {
			
			ManageCourse_Schedule.Schedule_Menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == Option_View) {
				ManageCourse_Schedule.viewAllCSchedule(Course_ScheduleList);
			} else if (option == Option_Add) {
				ManageCourse_Schedule.addCSchedule(Course_ScheduleList, inputCScheduleDetails(Course_ScheduleList));
			} else if (option == Option_Delete) {
				ManageCourse_Schedule.viewAllCSchedule(Course_ScheduleList);
				String id = Helper.readString("Enter a Course Schedule ID you wish to delete > ");
				ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, id);
			} else if (option == Option_Quit) {
				System.out.println("Thank you for Manage Course Schedule service");
			} else {
				System.out.println("Invalid Option");
			}
		}
	}

	//Done by Guang Hao (Case Study Member 4)
	public static void Schedule_Menu() {
		C206_CaseStudy.setHeader("Manage Course Schedule");
		System.out.println("1. View Course Schedule");
		System.out.println("2. Add Course Schedule");
		System.out.println("3. Delete Course Schedule");
		System.out.println("4. Back");
		Helper.line(100, "-");
	}
	
	
	//------------------Option 1--------------------------------------------------------------------
	//Done by Guang Hao (Case Study Member 4)
	//Refractor method by setting view all course schedule header and the data in different method
	public static String retrieveAllCSchedule(ArrayList<Course_Schedule> Course_ScheduleList) {
		String output = "";
			
		for (int i = 0; i < Course_ScheduleList.size(); i++) {
				
			Course_Schedule getCSchedule = Course_ScheduleList.get(i);
			output += String.format("%-20s %-10.1f %-20s %-20s %-30s\n", getCSchedule.getSchedule_id(), getCSchedule.getPrice(), 
					getCSchedule.getStart_date(), getCSchedule.getEnd_date(), getCSchedule.getLocation());
		}
		return output;
	}
		
	//Done by Guang Hao (Case Study Member 4)
	public static void viewAllCSchedule(ArrayList<Course_Schedule> Course_ScheduleList) {
		String output = String.format("%-20s %-10s %-20s %-20s %-30s\n", "Course Schedule Id", "Price", "Start Date/Time",
				"End Date/Time", "Location");
		output += retrieveAllCSchedule(Course_ScheduleList);
		System.out.println(output);
	}
	
	//------------------------------------Option 2---------------------------------------
	//Done by Guang Hao (Case Study Member 4)
	public static String Check_InputID(ArrayList<Course_Schedule> Course_ScheduleList) {
		//Refractor - Created a separated method from inputCScheduleDetails to validate the input id to be unique
		// in the arraylist and return the id
		
		String id = "";
		boolean isSame = true;
		//Validating that the user input for the ID is unique (not used in arraylist as an Course Schedule ID
		while (isSame != false) {
			String output = "";
			if (isSame == true) {
				id = Helper.readString("Enter Course Schedule ID (With CS at the front) with course code (Separate by -) > ");
				id = id.substring(0, 2).toUpperCase() + id.substring(2);
				for (int i = 0; i < Course_ScheduleList.size(); i++) {
					Course_Schedule cs = Course_ScheduleList.get(i);
					
					if (cs.getSchedule_id().equalsIgnoreCase(id)) {
						System.out.println("Course Schedule Have been used!!");
						isSame = true;
						output += cs.getSchedule_id();
					} 
				}
			}
			
			if (output == "") {
				isSame = false;
			}
		}
		return id;
	}
	
	//Done by Guang Hao
	public static double Check_InputPrice(ArrayList<Course_Schedule> Course_ScheduleList) {
		//Refractor - Created a separated method from inputCScheduleDetails to validate the input price to be a positive
		//number in the arraylist and return the price
		//Validate the price to ensure that it is a positive number
		double price = 0.0;
				
		while (price <= 0) {
		price = Helper.readDouble("Enter price > ");
					
			if (price < 0.0) {
				System.out.println("Price cannot be a negative number");
						
			}
		}
				
		return price;	
	}
	
	//Done by Guang Hao
	public static Course_Schedule inputCScheduleDetails(ArrayList<Course_Schedule> Course_ScheduleList) {
		//All the course schedule details to be gathered and ask in this method
		//If all the criteria are met for the user input, it will be add to the Course_ScheduleList arryalist
		
		String id = Check_InputID(Course_ScheduleList);
		
		double price = Check_InputPrice(Course_ScheduleList);
		
		//Ensure that the start date is before the end date
		String start_dateTime = "01/01/2020, 00:00";
		String end_dateTime = "01/01/2020, 00:00";
		
		LocalDateTime start = LocalDateTime.parse(start_dateTime, formatter1);
		LocalDateTime end = LocalDateTime.parse(end_dateTime, formatter1);

		boolean isBeforeStart = true;
		while (isBeforeStart != false) {
			start_dateTime = Helper.readString("Enter Start Date and Timing (dd/MM/yyyy, HH:mm) > ");
			end_dateTime = Helper.readString("Enter End Date and Timing (dd/MM/yyyy, HH:mm) > ");
			
			start = LocalDateTime.parse(start_dateTime, formatter1);
			end = LocalDateTime.parse(end_dateTime, formatter1);
			
			if ((start.isAfter(end))) {
				System.out.println("**Start date should be before end date");
				
				isBeforeStart = true;
			} else {
				isBeforeStart = false;
			}
			
		}
		
		String location = Helper.readString("Enter location > ");
		
		Course_Schedule cc = new Course_Schedule(id, price, start, 
				end, location);
		return cc;
	}
	
	//Done by Guang Hao (Case Study Member 4)
	public static void addCSchedule(ArrayList<Course_Schedule> Course_ScheduleList, Course_Schedule cs) {
		
		Course_ScheduleList.add(cs);
		System.out.println("**Course Schedule added!!");
	}
	
	//-----------------------------------------------Option 3-------------------------------------------
	//Done by Guang Hao (Case Study Member 4)
	public static void deleteCSchedule(ArrayList<Course_Schedule> Course_ScheduleList, String id) {
		
		boolean isDeleted = false;
		String result = "Not found";
		for (int i = 0; i < Course_ScheduleList.size(); i++) {
			Course_Schedule cs = Course_ScheduleList.get(i);
				
			if (id.equals(cs.getSchedule_id())) {
				char confirmDeleted = Helper.readChar("Do you want to delete this? (Y/N) > ");
					
				if (confirmDeleted == 'Y' || confirmDeleted == 'y') {
					Course_ScheduleList.remove(i);
					isDeleted = true;
					result = "true";
				} else if (confirmDeleted == 'N' || confirmDeleted == 'n') {
					result = "fail";
				}
			}
		}
			
		if (isDeleted == false && result == "Not found") {
			System.out.println("**Course Schedule ID not found");
		} else if (isDeleted == true && result == "true"){
			System.out.println("**Course Schedule Successfully deleted!!");
		} else {
			System.out.println("**Delete failed");
		}
		
		
		
		
	}

}
