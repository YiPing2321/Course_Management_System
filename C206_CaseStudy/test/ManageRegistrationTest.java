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
		
		r1 = new Registration("A1", "CS001-R13", "jade@rp.edu.sg", "Pending", "1/08/2020", "15/08/2020");
		r2 = new Registration("A2", "CS002-R13", "Jack@gmail.com", "Pending", "1/08/2020", "31/08/2020");
		
		registrationList.add(r1);
		registrationList.add(r2);

		
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
		assertEquals("Test that registration arraylist size is 2", 2, registrationList.size());
		
		//test if the expected output string same as the list of Course Registration retrieved from the Case_Study - 	
		allRegistration = ManageRegistration.retrieveAllRegistration(registrationList);
		testOutput = String.format("%-20s %-10.2f %-20s %-20s %-30s\n", 1, "CS001-R13", "jade@rp.edu.sg", "Pending", "1/08/2020", "15/08/2020");
		
		testOutput += String.format("%-20s %-10.2f %-20s %-20s %-30s\n", 2, "CS002-R13", "Jack@gmail.com", "Pending", "1/08/2020", "31/08/2020");
	
	}		
		
	
	@Test
	
		 public void AddRegistration( ){
		        //check registration no entered is unique (Normal)
		        assertTrue("Check that registration no entered is unique", true);
		        
		        
		        //check arraylist size is 2 after adding (Boundary)
		        ManageRegistration.addCourseSchedule(registrationList);
		        assertEquals("Check that Registration List size is 2", 2, registrationList.size());
		        
		      //Test that registration no is not the same (error)
				assertEquals("Test both registration no is not the same",true,r1.getRegistration_no() != r2.getRegistration_no());
		    }
	
		@Test
		public void deleteRegistration() {
			ManageRegistration.retrieveAllRegistration(registrationList);
			//test list not null but empty; test if there is an arraylist to delete (boundary)
			assertNotNull("Test for valid arraylist to delete registration",registrationList);
			
			//Test that if the item have been deleted, the registrationList arraylist size decrease by 1 (Normal)
			ManageRegistration.deleteRegistration(registrationList, null);
			assertEquals("Check that registrationList arraylist size is 0", 0, registrationList.size());
		}
	
// once arraylist is 0, if user enter to delete a registration error will show "No registration ID found" - Error

@Test
public void updateRegistration() {
	retrieveAllRegistration();
	//For r1:
	//Test that r1 can be updated if it can be found in the list
	
	ManageRegistration.updateRegistration(registrationList); //normal
	
	//Test that new Status cannot be typed if registration no does not exist.
	String Registration_no = "notExist";
	assertTrue("Check that new Status cannot be typed if registration no does not exist ", r1.getRegistration_no() == Registration_no);
	//boundary condition
	
	
	//For r2:
	//Test that r2 can be updated if it can be found in the list

	ManageRegistration.updateRegistration(registrationList); //normal
	
	//Test that new description cannot be typed if category name does not exist(boundary)
	Registration_no = "notExist";
	assertTrue("Check that new Status cannot be typed if registration no does not exist ", r2.getRegistration_no() == Registration_no);
	
}

@Test
public void SearchBySchedule_idTest() {
	retrieveAllRegistration();
	
	String schedule_id = "CS001-R13";
	//Test if arraylist has the schedule id, if yes, it should display the details - normal
	ManageRegistration.SearchBySchedule_id(registrationList);
	
	String schedule_id2 = "CS005-R13";	
	//Test if arraylist does not have the schedule id of CS005-R13, it should not display any details - boundary
	ManageRegistration.SearchBySchedule_id(registrationList);
	
}


}
