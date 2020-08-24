import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManageRegistrationTest {
	
	private Registration r1;
	private Registration r2;
	
	
	private ArrayList<Registration> registrationList;
	
	@Before
	public void setUp() throws Exception {
		
		r1 = new Registration(1, "CS001", "ABC@gmail.com", "Pending", "1/08/2020", "15/08/2020");
		r2 = new Registration(2, "CS002", "EFG@gmail.com", "Pending", "1/08/2020", "31/08/2020");
		
		registrationList = new ArrayList<Registration>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	r1 = null;
	r2 = null;
		
	registrationList = null;
	}

	@Test
	
	public void retrieveAllRegistration() {
		// Test if Registration list is not null but empty - boundary
		assertNotNull("Test if there is valid registrationList arraylist to retrieve item", registrationList);
		
		//test if the list of Course Category retrieved from the SourceCentre is empty - boundary
		String allRegistration = ManageRegistration.retrieveAllRegistration(registrationList);
		String testOutput = "";
		assertEquals("Check that ViewAllRegistration", testOutput, allRegistration);
		
		//Given an empty list, after adding 1 item, test if the size of the list is 1 - normal
		ManageRegistration.addCourseSchedule(registrationList);
		ManageRegistration.addCourseSchedule(registrationList);
		assertEquals("Test that registration arraylist size is 1", 1, registrationList.size());
		
		//test if the expected output string same as the list of Course Registration retrieved from the Case_Study	
		allRegistration = ManageRegistration.retrieveAllRegistration(registrationList);
		testOutput = String.format("%-20s %-10.2f %-20s %-20s %-30s\n", 1, "CS001", "ABC@gmail.com", "Pending", "1/08/2020", "15/08/2020");
		
		testOutput += String.format("%-20s %-10.2f %-20s %-20s %-30s\n", 2, "CS002", "EFG@gmail.com", "Pending", "1/08/2020", "31/08/2020");
	
		assertEquals("Test that ViewAllRegistration", testOutput, allRegistration);
	}
	
	@Test
	public void addRegistration() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Registration arraylist to add to", registrationList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		ManageRegistration.addCourseSchedule(registrationList);
		assertEquals("Check that Registration arraylist size is 1", 1, registrationList.size());
		assertSame("Check that Registration is added", r1, registrationList.get(0));
						
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		ManageRegistration.addCourseSchedule(registrationList);
		assertEquals("Check that Course_Category arraylist size is 2", 2, registrationList.size());
		assertSame("Check that Course Category is added", r2, registrationList.get(1));
	}
		
	
		@Test
		public void deleteRegistration() {
			
		retrieveAllRegistration();
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Course Category arraylist to delete item", registrationList);
		
		//Test that if the item have been deleted, the Registration arraylist size is decrease by 1 
		// which in this case is 1 - normal
		int name = r1.getRegistration_no();
		ManageRegistration.deleteRegistration(registrationList, r1.getRegistration_no());
		assertEquals("Check that Registration arraylist size is 1", 1, registrationList.size());
		assertEquals("Check that the deleted ID is not used anymore?",
				true, name != registrationList.get(0).getRegistration_no());
						
		//Test that if the item have been deleted, the Registration arraylist size is decrease by 1 
		// which in this case is 0 - normal
	ManageRegistration.deleteRegistration(registrationList, r2.getRegistration_no());
		assertEquals("Check that Registration arraylist size is 0", 0, registrationList.size());
	}
}


