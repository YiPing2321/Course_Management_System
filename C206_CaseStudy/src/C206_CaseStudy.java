import java.util.ArrayList;

import c206_caseStudy.Registration;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		
		int option = 0;
		
		while (option != 6) {
			C206_CaseStudy.menu();
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
				//Member 5 : xinru
				public static void RegistrationMenu() {
					Helper.line(30, "=");
					System.out.println("REGISTRATION MANAGEMENT");
					Helper.line(30, "=");
					System.out.println("1. View all registration");
					System.out.println("2. View all registration ");
					System.out.println("3. Delete registration");
			}
			}
					//M5 : Task 2 - Display all items from arrayList of Registration
			//retrieve ArrayList
		  public static String retrieveAllRegistration(ArrayList<Registration> registrationList) {
		        String output = "";
		           
		        for (int i = 0; i < registrationList.size(); i++) {
		               
		        	Registration r = registrationList.get(i);
		            output += String.format("%-20s %-10.2f %-20s %-20s %-30s\n", r.getRegistration_no(), r.getSchedule_id(), r.getEmail(), r.getStatus(), r.getStart_date(), r.getEnd_date());
		        }
		        return output;
		    }
		       //View arrayList
					private static void viewAllRegistration(ArrayList<Registration> registrationList) {

					Helper.line(40, "-");
					System.out.println("VIEW ALL REGISTRATION");
					Helper.line(40, "-");
						
					String output = "";
					output += String.format("%-20s %-10s %-20s %-20s %-20s %-20s\n", "REGISTRATION_ID", "SCHEDULE_ID", "EMAIL", "STATUS", "STARTDATE/ TIME", "ENDDATE/ TIME");
					
					for(Registration r : registrationList) {
						output  += String.format("%-20s %-10s %-20s %-20s %-20s %-20s\n", r.getRegistration_no(), r.getSchedule_id(), r.getEmail(), r.getStatus(), r.getStart_date(), r.getEnd_date());
					}
					System.out.println(output);
				}
					
					//M5 : Task 3 - Delete Registration
					public static void deleteRegistration(ArrayList<Registration> registrationList, int registration_id) {
					        for (int i = 0; i < registrationList.size(); i++) {
					        	Registration r = registrationList.get(i);
					           
					            if (r.getRegistration_no() == registration_id) {
					            	registrationList.remove(i);
					                System.out.println("**Registration deleted!");
					            } else {
					                System.out.println("**Registration ID not found");
					            }
					        }
					}
					// NOT CONFIRMED : XINRU
					
//					      Helper.line(40, "-");
//					      System.out.println("DELETE REGISTRATION");
//					      Helper.line(40, "-");
//					      
//					      int registration_no = Helper.readInt("Enter Registration ID > ");
//					      boolean exist = false;
//					      
//					      for (Registration r : Registration) {
//
//					        if (r.Registration_no().equalsIgnoreCase(Registration_no)) {
//
//					         {
//					        	 Registration.remove(r);
//					          exist = true;
//					          break;
//					        } 
//					      }
//					      if (exist == false) {
//					        System.out.println("Registration ID does not exist");
//					      }
//					      
//					    }
//					  }
			} else if (option == 6) {
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
