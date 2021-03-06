import java.util.ArrayList;
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19046377, Aug 24, 2020 3:00:05 AM
 */

//Marvin
public class ManageMember{
	private static ArrayList<Registration> registered;
	private static ArrayList<Member> memberList;

	public static ArrayList<Member> getMemberList() {
		return memberList;
	}
	
	public static void main(String[] args) {
		registered = ManageRegistration.getRegistrationList();
		memberList = new ArrayList<Member>(); 
		
		memberList.add(new Member("Jade","F",94850592,"jade@rp.edu.sg","05/11/95","Singapore", "abc123"));
		memberList.add(new Member("Jack","M",85716392,"Jack@gmail.com","31/03/85","Colombia", "hello"));
		
		int option = 0;
		while(option != 6) {
			menu();
			option = Helper.readInt("Enter option > ");
			
			if(option == 1) {
				ManageMember.retrieveMembers(memberList);
				
			}else if (option == 2) {
				ManageMember.addMembers(memberList);
				
			}else if (option == 3) {
				ManageMember.deleteMembers(memberList);
				
			}else if (option == 4) {
				ManageMember.updateMembers(memberList);
				
			}else if (option == 5) {
				ManageMember.viewCourses(memberList);
				
			}else if (option == 6) {
				System.out.println("Successfully quit from system");
			}
		}

	}
	public static void menu() {
			Helper.line(30, "=");
			System.out.println("Manage Members");
			Helper.line(30, "=");
			System.out.println("1.View members");
			System.out.println("2.Add member");
			System.out.println("3.Delete member");
			System.out.println("4.Update member");
			System.out.println("5.List all upcoming courses of a member");
			System.out.println("6.Quit");
		
	}
	//method to check for unique email
	public static String checkEmail(ArrayList<Member>memberList) {
		String email = "";
		boolean unique = true;
		while (unique != false) {
			String output = "";
			if(unique == true) {
				email = Helper.readString("Enter unique email > ");
				for(int i=0;i<memberList.size();i++) {
					Member m = memberList.get(i);
					
					if(m.getEmail().equals(email)) {
						System.out.println("Email has been used.");
						unique = true;
						output += m.getEmail();
					}
				}
			}
			if (output == "") {
				unique = false;
			}
		}
		return email;
	}
	
	public static String retrieveMembers(ArrayList<Member>memberList) {
		String output = "";
		for(int i=0;i<memberList.size();i++) {
			output += String.format("%-10s %-10s %-20d %-20s %-20s %-20s %-20s\n",memberList.get(i).getName(),memberList.get(i).getGender(),memberList.get(i).getMobile_number(),memberList.get(i).getEmail(),memberList.get(i).getDob(),memberList.get(i).getCountry(),memberList.get(i).getPassword());
		}
		System.out.println(output);
		//view by country of residence
		String filteroutput = "";
		String cor = Helper.readString("Enter country of residence to filter list by > ");
		for(int i=0;i<memberList.size();i++) {
			if(cor.equals(memberList.get(i).getCountry())) {
				filteroutput += String.format("%-10s %-10s %-20d %-20s %-20s %-20s %-20s\n",memberList.get(i).getName(),memberList.get(i).getGender(),memberList.get(i).getMobile_number(),memberList.get(i).getEmail(),memberList.get(i).getDob(),memberList.get(i).getCountry(),memberList.get(i).getPassword());
			}
		}
		System.out.println(filteroutput);
		return null;
	}
	public static void addMembers(ArrayList<Member>memberList) {
		String uniquemail = checkEmail(memberList);
		
		String name = Helper.readString("Enter Name >");
		String gender = Helper.readString("Enter Gender M/F > ");
		int mobile = Helper.readInt("Enter mobile number > ");
		String email = Helper.readString("Enter email > ");
		String dob = Helper.readString("Enter Date of Birth(dd/mm/yy) > ");
		String country = Helper.readString("Enter country of residence > ");
		String password = Helper.readString("Enter password > ");

		Member m = new Member(name,gender,mobile,email,dob,country,password);
		memberList.add(m);
		System.out.println("Member added!");
	}
	public static void deleteMembers(ArrayList<Member>memberList) {
		String email = Helper.readString("Enter email corresponding to the account >");
		for(int i=0;i<memberList.size();i++) {
			if(email.equals(memberList.get(i).getEmail())) {
				if(email.equals(registered.get(i).getEmail())) {
					System.out.println("Member has registered for course and cannot be deleted");
				}else {
					memberList.remove(i);
					System.out.println("Member deleted");
				}				
			}
		}
		
	}
	//update menu
	public static void updateMenu() {
		Helper.line(40, "=");
		System.out.println("1.Update password");
		System.out.println("2.Update country of residence");
		System.out.println("3.Update mobile");
		System.out.println("4.Quit");
		Helper.line(40, "=");
	}
	public static void updateMembers(ArrayList<Member>memberList) {
		int option = 0;
		while (option != 4) {
			updateMenu();
			option = Helper.readInt("Enter option > ");
			if(option == 1) {
				String checkEmail = Helper.readString("Enter email of member account > ");
				for(int i=0; i<memberList.size();i++) {
					if(checkEmail.equals(memberList.get(i).getEmail())) {
						System.out.println(String.format("Current password: %s", memberList.get(i).getPassword()));
						String newPass = Helper.readString("Enter new password > ");
						memberList.get(i).setPassword(newPass);
						System.out.println("Password updated successfully");
					}
				}
			}else if(option == 2) {
				String checkEmail = Helper.readString("Enter email of member account > ");
				for(int i=0; i<memberList.size();i++) {
					if(checkEmail.equals(memberList.get(i).getEmail())) {
						System.out.println(String.format("Current country: %s", memberList.get(i).getCountry()));
						String newCountry = Helper.readString("Enter new country > ");
						memberList.get(i).setCountry(newCountry);
						System.out.println("Country updated successfully");
					}
				}
			}else if(option == 3) {
				String checkEmail = Helper.readString("Enter email of member account > ");
				for(int i=0;i<memberList.size();i++) {
					if(checkEmail.equals(memberList.get(i).getEmail())) {
						System.out.println(String.format("Current Mobile: %s", memberList.get(i).getMobile_number()));
						int newMobile = Helper.readInt("Enter new mobile > ");
						memberList.get(i).setMobile_number(newMobile);
						System.out.println("Mobile updated successfully");
					}
				}
			}else if(option == 4) {
				System.out.println("Successfully quit update menu");
			}
		}
	}
	public static void viewCourses(ArrayList<Member>memberList) {
		String email = Helper.readString("Enter member's email to view upcoming courses > ");
		for(int i=0;i<memberList.size();i++) {
			if(email.equals(registered.get(i).getEmail())) {
				System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s %-20s", "NAME","EMAIL","COURSE NO","STATUS","START DATE","END DATE"));
				System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s %-20s\n", memberList.get(i).getName(),memberList.get(i).getEmail(),registered.get(i).getRegistration_no(),registered.get(i).getStatus(),registered.get(i).getStart_date(),registered.get(i).getEnd_date()));
			}
		}
	}
	
	
}
