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
	//If encounter null pointer exception
	//Do this as follow below
	//1.Run the MainMenu class
	//2.Select Option 1 and quit
	//3.Select Option 5 and quit
	//4.Select Option 4 (Manage Course Schedule), and try the option again and error will be resolved

	//Refractor of the option
	private static final int Option_View = 1;
	private static final int Option_Add = 2;
	private static final int Option_Delete = 3;
	private static final int Option_Update = 4;
	private static final int Option_SearchByPrice = 5;
	private static final int Option_SearchByID = 6;
	private static final int Option_Quit = 7;
	
	private static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
	
	private static ArrayList<Course_Schedule> Course_ScheduleList;
	private static ArrayList<Registration> registration;
	private static ArrayList<Member> member;
	
	public static void main(String[] args) {
		registration = ManageRegistration.getRegistrationList();
		member = ManageMember.getMemberList();
		Course_ScheduleList = new ArrayList<Course_Schedule>();
		
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
				ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, id, ManageCourse_Schedule.checkMember(id));
			
			} else if (option == Option_Update) {
				String id = Helper.readString("Enter a Course Schedule ID you wish to update > ");
				ManageCourse_Schedule.updateCSchedule(Course_ScheduleList, id);
				
			} else if (option == Option_SearchByPrice) {
				double price = Helper.readDouble("Enter a price > ");
				ManageCourse_Schedule.SearchByPrice(Course_ScheduleList, price);
				
			} else if (option == Option_SearchByID) {
				String id = Helper.readString("Enter Course Schedule ID to view> ");
				ManageCourse_Schedule.viewMemberDetails(Course_ScheduleList, id);
				
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
		System.out.println("4. Update Course Schedule");
		System.out.println("5. Search Course Schedule by Price");
		System.out.println("6. Search Member by Schedule Id");
		System.out.println("7. Back");
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
	public static void deleteCSchedule(ArrayList<Course_Schedule> Course_ScheduleList, String id, int number) {
		if (number == 0) {
			
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
				
			if (result == "Not found") {
				System.out.println("**Course Schedule ID not found");
			} else if (isDeleted == true && result == "true"){
				System.out.println("**Course Schedule Successfully deleted!!");
			} else if (isDeleted == false && result == "fail"){
				System.out.println("**Delete failed");
			}
		} else {
			System.out.println("**There are " + number + " member(s) registered for the id (" + id + ")");
		}
	}
	
	public static void updateCSchedule(ArrayList<Course_Schedule> Course_ScheduleList, String id) {
		
		boolean isUpdate = false;
		boolean isFound = false;
		
		String output = String.format("%-20s %-10s %-20s %-20s %-30s\n", "Course Schedule Id", "Price", "Start Date/Time",
				"End Date/Time", "Location");
		
		double price = 0.0;
		String start_dateTime = "01/01/2020, 00:00";
		String end_dateTime = "01/01/2020, 00:00";
		String location = "";
		for (int i = 0; i < Course_ScheduleList.size(); i++) {
			Course_Schedule cs = Course_ScheduleList.get(i);
			String schedule_id = id.substring(0, 2).toUpperCase() + id.substring(2);
			if (cs.getSchedule_id().equals(schedule_id)) {
				//Retrieve the current details of the schedule id
				
				isFound = true;
				output += cs.display();
				System.out.println(output);
				
				//Ask user to enter new details for price, start & end date/time, location
				price = ManageCourse_Schedule.Check_InputPrice(Course_ScheduleList);
				
				//Ensure that the start date is before the end date
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
				
				location = Helper.readString("Enter location > ");
				
				//Update the details to the arraylist
				cs.setPrice(price);
				cs.setStart_date(start);
				cs.setEnd_date(end);
				cs.setLocation(location);
				
				isUpdate = true;
			}
		}
		
		if (isUpdate == true && isFound == true) {
			System.out.println("**Update Successful");
		} else if (isUpdate == false && isFound == true){
			System.out.println("**Update Failed");
		} else if (isFound == false) {
			System.out.println("**Course Schedule id not found");
		}
		
		
	}
	
	public static void SearchByPrice(ArrayList<Course_Schedule> Course_ScheduleList, double price) {
		
		boolean isFound = false;
		
		if (price > 0.0) {
			
			String output = String.format("%-20s %-10s %-20s %-20s %-30s\n", "Course Schedule Id", "Price", "Start Date/Time",
					"End Date/Time", "Location");
			
			for (int i = 0; i < Course_ScheduleList.size(); i++) {
				Course_Schedule cs = Course_ScheduleList.get(i);
				
				if (cs.getPrice() == price) {
					
					output += cs.display();
					isFound = true;
				}
			}
			
			if (isFound == true) {
				System.out.println(output);
			
			} else if (isFound == false){
				System.out.println("**No course schedule details relating to this price found");
			}
		} else {
			System.out.println("**Price cannot be zero or negative amount");
		}
		
		
	}
	
	public static int checkMember(String id) {
		
		int count = 0;
		for (int i = 0; i < registration.size(); i++) {
			Registration r =  registration.get(i);
			
			if (r.getSchedule_id().equals(id)) {
				
				count++;
			}
		}
		return count;
		
		
	}
	
	public static void viewMemberDetails(ArrayList<Course_Schedule> Course_ScheduleList, String id) {
		try {
			boolean isFound = false;
			boolean result = false;
			
			String output = String.format("%-15s %-10s %-20s %-20s %-15s %-20s\n", "NAME", "GENDER", "MOBILE NUMBER",
						"EMAIL", "DATE OF BIRTH", "COUNTRY");
			
			for (int b = 0; b < Course_ScheduleList.size(); b++) {
				if (Course_ScheduleList.get(b).getSchedule_id().equals(id)) {
					result = true;
				}
			}
			
			for (int i = 0; i < registration.size(); i++) {
				Registration r =  registration.get(i);
					
				if (r.getSchedule_id().equals(id)) {
						
					for (int a = 0; a < member.size(); a++) {
							
						Member m = member.get(a);
						if (m.getEmail().equals(r.getEmail())) {
							isFound = true;
							output += String.format("%-15s %-10s %-20d %-20s %-15s %-20s\n", m.getName(), m.getGender(),
										m.getMobile_number(), m.getEmail(), m.getDob(), m.getCountry());
						}
					}
				}
			}
				
			System.out.println(output);
			if (isFound == false && result == true) {	
				System.out.println("**Course Schedule id exist in Course Schedule but no one registered yet");
			} 
		
		
			if (result == false) {
				System.out.println("Course Schedule id is not found");
			}
		} catch (NullPointerException npe) {
			System.out.println("\nTo solve the error:\n1.Run the MainMenu class\n2.Select Option 1 and quit\n"
					+ "3.Select Option 5 and quit\n4.Select Option 4 (Manage Course Schedule) and error will be resolved\n");
		}
	}

}
