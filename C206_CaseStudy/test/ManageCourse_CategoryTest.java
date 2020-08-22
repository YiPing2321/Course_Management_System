import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19030407, Aug 22, 2020 10:56:36 AM
 */

public class ManageCourse_CategoryTest {

	private Course_Category cc1;
	private Course_Category cc2;
	
	
	private ArrayList<Course_Category> Course_Category;
	
	@Before
	public void setUp() throws Exception {
		
		cc1 = new Course_Category("Technology", "Gives a deeper insight about the world of Technology");
		cc2 = new Course_Category("Sports Science", "Studies how the healthy human body works during exercise");
		
		Course_Category = new ArrayList<Course_Category>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		
		Course_Category = null;
	}

	@Test
	
	public void retrieveAllCategory() {
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Course_Category arraylist to retrieve item", Course_Category);
		
		//test if the list of Course Category retrieved from the SourceCentre is empty - boundary
		String allCategory = ManageCategory.retrieveAllCategory(Course_Category);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCategory);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		ManageCategory.addCategory(Course_Category, cc1);
		ManageCategory.addCategory(Course_Category, cc2);
		assertEquals("Test that Course_Category arraylist size is 2", 2, Course_Category.size());
		
		//test if the expected output string same as the list of Course Category retrieved from the Case_Study	
		allCategory = ManageCategory.retrieveAllCategory(Course_Category);
		testOutput = String.format("%-20s %-20s \n", "Technology", "Gives a deeper insight about the world of Technology");
		
		testOutput += String.format("%-20s %-20s \n", "Sports Science", "Studies how the healthy human body works during exercise");
	
		assertEquals("Test that ViewAllCategory", testOutput, allCategory);
	}
	
	@Test
	public void addCategoryTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Course Category arraylist to add to", Course_Category);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		ManageCategory.addCategory(Course_Category, cc1);
		assertEquals("Check that Course_Category arraylist size is 1", 1, Course_Category.size());
		assertSame("Check that Course Category is added", cc1, Course_Category.get(0));
		
		//Test that name does not exist yet - boundary
		//NA since it's tested below in CC2
		
		//Test that field is filled - error
		assertEquals("Check that all field is filled", true, cc1.getCourse_name() != null && cc1.getCourse_description() != null);
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		ManageCategory.addCategory(Course_Category, cc2);
		assertEquals("Check that Course_Category arraylist size is 2", 2, Course_Category.size());
		assertSame("Check that Course Category is added", cc2, Course_Category.get(1));
		
		//Test that name does not exist yet - boundary
		assertEquals("Check that category name does not exist yet?", true, cc2.getCourse_name() != cc1.getCourse_name() );
				
		//Test that field is filled - error
		assertEquals("Check that all field is filled", true, cc2.getCourse_name() != null && cc2.getCourse_description() != null);
	}
	
	@Test
	public void deleteCategory() {
		retrieveAllCategory();
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Course Category arraylist to delete item", Course_Category);
		
		//Test that if the item have been deleted, the Course_Schedule List arraylist size is decrease by 1 
		// which in this case is 1 - normal
		String name = cc1.getCourse_name();
		ManageCategory.deleteCategory(Course_Category, cc1.getCourse_name());
		assertEquals("Check that Course_Category arraylist size is 1", 1, Course_Category.size());
		assertEquals("Check that if the deleted name is not used anymore?",
				true, name != Course_Category.get(0).getCourse_name());
						
		//Test that if the item have been deleted, the Course_Category List arraylist size is decrease by 1 
		// which in this case is 0 - normal
		ManageCategory.deleteCategory(Course_Category, cc2.getCourse_name());
		assertEquals("Check that Course_Category arraylist size is 0", 0, Course_Category.size());
		//No need to check if the deleted name is not used anymore becuse the size of the arraylist is 0, and 1 will be null
	}

}
