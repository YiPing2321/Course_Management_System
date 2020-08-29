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
	private static final int Option_Update = 4;
	private static final int Option_SearchByName = 5;
	private static final int Option_Quit = 6 ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Course_Category> Course_Category = new ArrayList<Course_Category>();
		
		Course_Category.add(new Course_Category("Technology", "Gives a deeper insight about the world of Technology"));
		Course_Category.add(new Course_Category("Sports Science", "Studies how the healthy human body works during exercise"));
	
	
		int option = 0;
		
		while (option != Option_Quit) {
			
			ManageCategory.Category_Menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == Option_View) {
				ManageCategory.viewAllCategory(Course_Category);
			} else if (option == Option_Add) {
				ManageCategory.addCategory(Course_Category, inputCategoryDetails(Course_Category));
			} else if (option == Option_Delete) {
				ManageCategory.viewAllCategory(Course_Category);
				String id = Helper.readString("Enter a Course Category Name you wish to delete > ");
				ManageCategory.deleteCategory(Course_Category, id);
			} else if (option == Option_Update) {
				String name = Helper.readString("Enter a Course Category Name you wish to update > ");
				ManageCategory.updateCategory(Course_Category, name);				
			} else if (option == Option_SearchByName) {
				String name = Helper.readString("Enter a name > ");
				ManageCategory.SearchByName(Course_Category, name);
			} else if (option == Option_Quit) {
				System.out.println("Thank you for Manage Course Category service");
			} else {
				System.out.println("Invalid Option");
			}
		}
	}
	
	public static void Category_Menu() {
		C206_CaseStudy.setHeader("Manage Course Category");
		System.out.println("1. View Course Category");
		System.out.println("2. Add Course Category");
		System.out.println("3. Delete Course Category");
		System.out.println("4. Update Course Category");
		System.out.println("5. Search Course Category by Name");
		System.out.println("6. Back");
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


	public static void updateCategory(ArrayList<Course_Category> Course_Category, String name) {
		
		boolean isUpdate = false;
		boolean isFound = false;
		
		String output = String.format("%-20s %-20s \n", "Category name", "Category description");
		
		String description = "";
		for (int i = 0; i < Course_Category.size(); i++) {
			Course_Category cc = Course_Category.get(i);
			if (cc.getCourse_name().equals(name)) {
				//Retrieve the current details of the category
				
				isFound = true;
				output += cc.display();
				
				
				
				
				System.out.println(output);
				description = Helper.readString("Enter description > ");
				
				
				
				//Update the details to the arraylist
				cc.setCourse_description(description);
				
				isUpdate = true;
			} 
		}
		if (isFound == false) {
			System.out.println("Not found");
		}
 	}
	
	public static void SearchByName(ArrayList<Course_Category> Course_Category, String name) {
		
		boolean isFound = false;
		
			
		String output = String.format("%-20s %-20s \n", "Category name", "Category description");
			
		for (int i = 0; i < Course_Category.size(); i++) {
			Course_Category cc = Course_Category.get(i);
				
			if (cc.getCourse_name().contentEquals(name)) {
					
				output += cc.display();
				isFound = true;
			}
		
		}	
		if (isFound == true) {
			System.out.println(output);
		
		}
			
		else if (isFound == false){
			System.out.println("**No course category details relating to this name found");
		}
		
		
		
	}
	
	
}
