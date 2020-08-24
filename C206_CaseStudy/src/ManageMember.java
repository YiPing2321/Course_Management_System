import java.util.ArrayList;
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19046377, Aug 22, 2020 7:34:05 AM
 */

//Marvin
public class ManageMember{
	//private static ArrayList<Member> memberList; 	

	public static void main(String[] args) {
		ArrayList<Member> memberList = new ArrayList<Member>(); 
		int option = -1;
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
			System.out.println("4.Quit");
		
	}
	public static void retrieveMembers(ArrayList<Member>memberList) {
		String output = "";
		for(int i=0;i<memberList.size();i++) {
			output += String.format("%-10s %-10s %-20d %-20s %-20s %-20s\n",memberList.get(i).getName(),memberList.get(i).getGender(),memberList.get(i).getMobile_number(),memberList.get(i).getEmail(),memberList.get(i).getDob(),memberList.get(i).getCountry());
		}
	}
	public static void addMembers(ArrayList<Member>memberList) {
		String name = Helper.readString("Enter Name >");
		String gender = Helper.readString("Enter Gender M/F > ");
		int mobile = Helper.readInt("Enter mobile number > ");
		String email = Helper.readString("Enter email > ");
		String dob = Helper.readString("Enter Date of Birth(dd/mm/yy) > ");
		String country = Helper.readString("Enter country of residence > ");

		Member m = new Member(name,gender,mobile,email,dob,country);
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
}
