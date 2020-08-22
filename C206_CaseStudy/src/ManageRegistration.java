import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19030407, Aug 22, 2020 7:33:53 AM
 */

public class ManageRegistration {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Registration> registrationList = new ArrayList<Registration>();
		
		int option = 0;
		while (option != 4) {
			
			ManageRegistration.RegistrationMenu();
			option = Helper.readInt("Enter an option > ");
			 
			if (option == 1) {
				ManageRegistration.viewAllRegistration(registrationList);
			} else if (option == 2) {
				
			} else if (option == 3) {
				
			} else if (option == 4) {
				System.out.println("Thank you for Manage Course Schedule service");
			} else {
				System.out.println("Invalid Option");
			}
		}
		
	}
	//Member 5 : xinru
	public static void RegistrationMenu() {
		Helper.line(30, "=");
		System.out.println("REGISTRATION MANAGEMENT");
		Helper.line(30, "=");
		System.out.println("1. View all registration");
		System.out.println("2. View all registration ");
		System.out.println("3. Delete registration");
		System.out.println("4. Back");
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
	}

			// NOT CONFIRMED : XINRU
			
//			      Helper.line(40, "-");
//			      System.out.println("DELETE REGISTRATION");
//			      Helper.line(40, "-");
//			      
//			      int registration_no = Helper.readInt("Enter Registration ID > ");
//			      boolean exist = false;
//			      
//			      for (Registration r : Registration) {
//
//			        if (r.Registration_no().equalsIgnoreCase(Registration_no)) {
//
//			         {
//			        	 Registration.remove(r);
//			          exist = true;
//			          break;
//			        } 
//			      }
//			      if (exist == false) {
//			        System.out.println("Registration ID does not exist");
//			      }
//			      
//			    }
//			  }