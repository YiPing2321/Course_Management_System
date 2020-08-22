import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19030407, Aug 22, 2020 7:34:46 AM
 */

public class ManageCategory {

	/**
	 * @param args
	 */
	private static final int Option_View = 1;
	private static final int Option_Add = 2;
	private static final int Option_Delete = 3;
	private static final int Option_Quit = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Course_Category> Course_Category = new ArrayList<Course_Category>();
		
		Course_Category.add(new Course_Category("Technology", "Gives a deeper insight about the world of Technology"));
		Course_Category.add(new Course_Category("Sports Science", "Studies how the healthy human body works during exercise"));
	
	
		int option = 0;
		
		while (option != Option_Quit) {
			
			ManageCategory.Schedule_Menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == Option_View) {
				ManageCategory.viewAllCategory(Course_Category);
			} else if (option == Option_Add) {
				ManageCategory.addCategory(Course_Category, inputCategoryDetails(Course_Category));
			} else if (option == Option_Delete) {
				ManageCategory.viewAllCategory(Course_Category);
				String id = Helper.readString("Enter a Course Schedule ID you wish to delete > ");
				ManageCategory.deleteCategory(Course_Category, id);
			} else if (option == Option_Quit) {
				System.out.println("Thank you for Manage Course Schedule service");
			} else {
				System.out.println("Invalid Option");
			}
		}
	}
	
	public static void Schedule_Menu() {
		C206_CaseStudy.setHeader("Manage Course Category");
		System.out.println("1. View Course Category");
		System.out.println("2. Add Course Category");
		System.out.println("3. Delete Course Category");
		System.out.println("4. Back");
		Helper.line(100, "-");
	}
	
	public static String retrieveAllCategory(ArrayList<Course_Category> Course_Category) {
		String output = "";
			
		for (int i = 0; i < Course_Category.size(); i++) {
				
			Course_Category getCategory = Course_Category.get(i);
			output += String.format("%-20s %-20s \n", getCategory.getCourse_name(), getCategory.getCourse_description());
		}
		return output;
	}
	
	public static void viewAllCategory(ArrayList<Course_Category> Course_Category) {
		String output = String.format("%-20s %-20s \n", "Category name", "Category description");
		output += retrieveAllCategory(Course_Category);
		System.out.println(output);
	}
	//======= Option 2 ========
	
	public static String Check_InputName(ArrayList<Course_Category> Course_Category) {
		
		String name = "";
		boolean isSame = true;

		while (isSame != false) {
			String output = "";
			if (isSame == true) {
				name = Helper.readString("Enter Category Name > ");
				name = name.toUpperCase();
				for (int i = 0; i < Course_Category.size(); i++) {
					Course_Category cc = Course_Category.get(i);
					
					if (cc.getCourse_name().equalsIgnoreCase(name)) {
						System.out.println("Category name has been used!!");
						isSame = true;
						output += cc.getCourse_name();
					} 
				}
			}
			
			if (output == "") {
				isSame = false;
			}
		}
		return name;
	}
	
	public static Course_Category inputCategoryDetails(ArrayList<Course_Category> Course_Category) {
		//All the course category details to be gathered and ask in this method
		
		String name = Check_InputName(Course_Category);
		
		String description = Helper.readString("Enter description > ");
		
		Course_Category cc = new Course_Category(name, description);
		return cc;
	}
	
	public static void addCategory(ArrayList<Course_Category> Course_Category, Course_Category cc) {
		
		Course_Category.add(cc);
		System.out.println("**Course Category added!!");
	}
	
	//-----------------------------------------------Option 3-------------------------------------------
	public static void deleteCategory(ArrayList<Course_Category> Course_Category, String name) {
		
		boolean isDeleted = false;
		
		for (int i = 0; i < Course_Category.size(); i++) {
			Course_Category cc = Course_Category.get(i);
			
			if (name.equals(cc.getCourse_name())){
				Course_Category.remove(i);
				isDeleted = true;
			}
		}
		
		if (isDeleted == false) {
			System.out.println("**Category Name not found");
		} else {
			System.out.println("**Category Name Successfully deleted!!");
		}
	}

	public static String retrieveAllCSchedule(ArrayList<Course_Category> course_Category) {
		// TODO Auto-generated method stub
		return null;
	}

}
