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

	public static void main(String[] args) {
		ArrayList<Member> memberList = new ArrayList<Member>(); 
		int option = 0;
		while(option != 4) {
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
			System.out.println("5.Quit");
		
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
		return null;
	}
	public static void addMembers(ArrayList<Member>memberList) {
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
				memberList.remove(i);
				System.out.println("Member deleted");
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
	
	
	
}
