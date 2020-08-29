import java.util.ArrayList;


/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19009259, Aug 22, 2020 8:33:53 pm
 */
//Member 5 : -----------------------------Xin Ru---------------------------------

public class ManageRegistration {
	
	private static ArrayList<Registration> registrationList;
	private static ArrayList<Member> member;

	
	public static ArrayList<Registration> getRegistrationList() {
		return registrationList;
	}

	public static void main(String[] args) {
		
		registrationList = new ArrayList<Registration>();
		
		member = ManageMember.getMemberList();
		
		registrationList.add(new Registration("A1", "CS001-R13", "jade@rp.edu.sg", "Pending", "1/08/2020", "15/08/2020"));
		registrationList.add(new Registration("A2", "CS001-R13", "Jack@gmail.com", "Pending", "1/08/2020", "31/08/2020"));

		int option = 0;
		
		while (option != 6) {
			
			ManageRegistration.RegistrationMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				ManageRegistration.addCourseSchedule(registrationList);
				
			} else if (option == 2) {
				ManageRegistration.viewAllRegistration(registrationList);
				
			} else if (option == 3) {
				ManageRegistration.viewAllRegistration(registrationList);
				String registration_id = Helper.readString("Enter a Registration ID you wish to delete > ");
				ManageRegistration.deleteRegistration(registrationList, registration_id);
				
			} else if (option == 4) {
				ManageRegistration.updateRegistration(registrationList);
			
			} else if (option == 5) {
				String schedule_id = Helper.readString("Enter a schedule ID > ");
				ManageRegistration.SearchBySchedule_id(registrationList);
			
	
			} else if (option == 6) {
				  System.out.println("Thank you for using this system!");
            } else {
                System.out.println("Invalid option");
            }
        }
	}
				

	public static void RegistrationMenu() {
		Helper.line(50, "=");
		System.out.println("REGISTRATION MANAGEMENT");
		Helper.line(50, "=");
		
		System.out.println("1. Register for course schedule");
		System.out.println("2. View all registration ");
		System.out.println("3. Delete registration");
		System.out.println("4. Quit");
	}
	
	//method to check for unique registration no
		public static String checkRegistrationNo(ArrayList<Registration> registrationList) {
			String registration_no = "";
			boolean unique = true;
			while (unique != false) {
				String output = "";
				if(unique == true) {
					registration_no = Helper.readString("Enter unique registration number > ");
					for(int i=0;i<registrationList.size();i++) {
						Registration r = registrationList.get(i);
						
						if(r.getRegistration_no().equals(registration_no)) {
							System.out.println("Registration No has been used.");
							unique = true;
							output += r.getRegistration_no();
						}
					}
				}
				if (output == "") {
					unique = false;
				}
			}
			return registration_no;
			
		}
	
	//M5 : Task 1 - Register for course schedule
		//-----------------------------------REGISTER--------------------------------------

	public static void addCourseSchedule(ArrayList<Registration> registrationList) {
        // TODO Auto-generated method stub
        Helper.line(40, "=");
        System.out.println("REGISTER COURSE SCHEDULE");
        Helper.line(40, "=");

		String uniqueregistration_no = checkRegistrationNo(registrationList);


        String registration_no = Helper.readString("Enter Registration Number > ");
        String schedule_id = Helper.readString("Enter Schedule ID > ");
        String  email = Helper.readString("Enter Member's Email > ");
        String status = Helper.readString("Enter Status > ");	
        String start_date = Helper.readString("Enter Course Schedule Starting Date > ");
        String end_date = Helper.readString("Enter Course Schedule Ending Date > ");
        
        registrationList.add(new Registration(registration_no, schedule_id, email, status, start_date, end_date ));

        ManageRegistration.viewAllRegistration(registrationList);
        
        System.out.println("Course Schedule Registered!");        
    }


			//M5 : Task 2 - Display all items from arrayList of Registration
	//---------------------------------------RETRIEVE ARRAYLIST--------------------------------
	
  public static String retrieveAllRegistration(ArrayList<Registration> registrationList) {
        String output = "";
           
        for (int i = 0; i < registrationList.size(); i++) {
               
        	Registration r = registrationList.get(i);
            output += String.format("%-20s %-10.2f %-20s %-20s %-30s\n", r.getRegistration_no(), r.getSchedule_id(), r.getEmail(), r.getStatus(), r.getStart_date(), r.getEnd_date());
        }
        return output;
    }
	//M5 : Task 2 ------------------ VIEW ALL REGISTRATION---------------------------
			public static void viewAllRegistration(ArrayList<Registration> registrationList) {

			Helper.line(40, "-");
			System.out.println("VIEW ALL REGISTRATION");
			Helper.line(40, "-");
				
			String output = "";
			output += String.format("%-20s %-10s %-20s %-20s %-20s %-20s\n", "REGISTRATION_ID", "SCHEDULE_ID", "EMAIL", "STATUS", "START DATE", "ENDDATE");
			
			for(Registration r : registrationList) {
				output  += String.format("%-20s %-10s %-20s %-20s %-20s %-20s\n", r.getRegistration_no(), r.getSchedule_id(), r.getEmail(), r.getStatus(), r.getStart_date(), r.getEnd_date());
			}
			System.out.println(output);
		}
			
			//M5 : Task 3 - Delete Registered Course Schedule
			//--------------------------Delete Registration---------------------------
			
			public static void deleteRegistration(ArrayList<Registration> registrationList, String registration_id) {
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
		  
        	   
        	   //Update menu
        	   public static void updateMenu() {
        			Helper.line(40, "=");
        			System.out.println("1.Update Status");
        			System.out.println("2.Quit");
        			Helper.line(40, "=");
        	   }
        			
        			//M5 : Task 4 - Update Registered Course Schedule 
        			//--------------------------Update Registration--------------------------        
    
        	           public static void updateRegistration(ArrayList<Registration> registrationList) {

        			int option = 0; {
        			while (option != 2) {
        				updateMenu();
        				option = Helper.readInt("Enter option > ");
        				
        				if(option == 1) {
        					String checkRegistrationNo = Helper.readString("Enter Updated Status > ");
        					for(int i=0; i < registrationList.size();i++) {
        						if(checkRegistrationNo.equals(registrationList.get(i).getStatus())) {
        							System.out.println(String.format("Current Status: ", registrationList.get(i).getStatus()));
        							String newStatus = Helper.readString("Enter new Status > ");
									registrationList.get(i).setStatus(newStatus);
        							System.out.println("Password updated successfully");
        						}
        					}
        				
        			} else if(option == 2) {
        				System.out.println("Successfully quit update menu");
        			}
        		}
        			}
        	   }
           
	
	private static void SearchBySchedule_id(ArrayList<Registration> registrationList) {
        // TODO Auto-generated method stub
        Helper.line(20, "=");
        System.out.println("Search registration by schedule id");
        Helper.line(20, "=");
        
        String searchId = Helper.readString("Enter schedule id to search >");
        
        String output = "";
		output += String.format("%-20s %-10s %-20s %-20s %-20s %-20s\n", "REGISTRATION_ID", "SCHEDULE_ID", "EMAIL", "STATUS", "START DATE", "ENDDATE");        
		
        for (int i = 0; i < registrationList.size(); i++) {
            if (registrationList.get(i).getSchedule_id().equals(searchId)) {
                if (registrationList.get(i).getSchedule_id().contains(searchId)) {
                	Registration r = registrationList.get(i);
    				output  += String.format("%-20s %-10s %-20s %-20s %-20s %-20s\n", r.getRegistration_no(), r.getSchedule_id(), r.getEmail(), r.getStatus(), r.getStart_date(), r.getEnd_date());
                    System.out.println(output);
                    
                } else {
                    System.out.println("Schedule Id entered does not exist.");
                }
            }
        }
        
    }
	}
