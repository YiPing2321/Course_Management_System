import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

public class ManageCourse_ScheduleTest {

	private Course_Schedule cs1;
	private Course_Schedule cs2;
	private Course_Schedule cs3;
	private Course_Schedule cs4;
	private static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
	
	
	private ArrayList<Course_Schedule> Course_ScheduleList;
	
	@Before
	public void setUp() throws Exception {
		
		//normal
		cs1 = new Course_Schedule("CS001", 25.0, LocalDateTime.parse("11/08/2020, 08:30", formatter1), 
				LocalDateTime.parse("12/08/2020, 16:00", formatter1), "W66L");
		
		cs2 = new Course_Schedule("CS002", 14.0, LocalDateTime.parse("12/08/2020, 09:15", formatter1), 
				LocalDateTime.parse("13/08/2020, 15:30", formatter1), "W64J");
		
		cs3 = new Course_Schedule("CS003", 0.0, LocalDateTime.parse("13/08/2020, 09:45", formatter1), 
				LocalDateTime.parse("13/08/2020, 09:46", formatter1), "W46L");
		
		//For error test purpose 
		cs4 = new Course_Schedule("CS003", -0.1, LocalDateTime.parse("13/08/2020, 09:45", formatter1), 
				LocalDateTime.parse("13/08/2020, 09:40", formatter1), "W46L");
		Course_ScheduleList = new ArrayList<Course_Schedule>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cs1 = null;
		cs2 = null;
		
		Course_ScheduleList = null;
	}

	@Test
	
	public void retrieveAllCSchedule() {
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Course_ScheduleList arraylist to retrieve item", Course_ScheduleList);
		
		//test if the list of Course Schedule retrieved from the SourceCentre is empty - boundary
		String allCSchedule= ManageCourse_Schedule.retrieveAllCSchedule(Course_ScheduleList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCSchedule);
		
		//Test that cs1 and cs2 schedule id is not the same - error
		assertEquals("Check if both course schedule id is not the same?", true, cs1.getSchedule_id() != cs2.getSchedule_id());

		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		ManageCourse_Schedule.addCSchedule(Course_ScheduleList, cs1);
		ManageCourse_Schedule.addCSchedule(Course_ScheduleList, cs2);
		assertEquals("Test that Course_ScheduleList arraylist size is 2", 2, Course_ScheduleList.size());
		
		//test if the expected output string same as the list of Course Schedule retrieved from the Case_Study	
		allCSchedule= ManageCourse_Schedule.retrieveAllCSchedule(Course_ScheduleList);
		testOutput = String.format("%-20s %-10.1f %-20s %-20s %-30s\n", "CS001", 25.0, 
				LocalDateTime.parse("11/08/2020, 08:30", formatter1), 
				LocalDateTime.parse("12/08/2020, 16:00", formatter1), "W66L");
		
		testOutput += String.format("%-20s %-10.1f %-20s %-20s %-30s\n", "CS002", 14.0, 
				LocalDateTime.parse("12/08/2020, 09:15", formatter1), 
				LocalDateTime.parse("13/08/2020, 15:30", formatter1), "W64J");
	
		assertEquals("Test that ViewAllCSchedulelist", testOutput, allCSchedule);
	}
	
	@Test
	public void addCScheduleTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Course Schedule arraylist to add to", Course_ScheduleList);
		
		//-----------------------------------------------------------------------------------------------------------/
		//For cs1:
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		ManageCourse_Schedule.addCSchedule(Course_ScheduleList, cs1);
		assertEquals("Check that Course_ScheduleList arraylist size is 1", 1, Course_ScheduleList.size());
		assertSame("Check that Course Schedule is added", cs1, Course_ScheduleList.get(0));
		
		//Test that price is not a negative number for cs1 - normal
		assertEquals("Check that price is a positive number?", true, cs1.getPrice() > 0.0);
		
		//Test that start date is before end date for cs1 - normal
		assertEquals("Check that start date is before end date", true, cs1.getStart_date().isBefore(cs1.getEnd_date()));
		
		//-----------------------------------------------------------------------------------------------------------/
		//For cs2:
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		ManageCourse_Schedule.addCSchedule(Course_ScheduleList, cs2);
		assertEquals("Check that Course_ScheduleList arraylist size is 2", 2, Course_ScheduleList.size());
		assertSame("Check that Course Schedule is added", cs2, Course_ScheduleList.get(1));
		
		//Test that price is not a negative number for cs2 - normal
		assertEquals("Check that price is a positive number?", true, cs2.getPrice() > 0.0);
				
		//Test that start date is before end date for cs2 - normal
		assertEquals("Check that start date is before end date", true, cs2.getStart_date().isBefore(cs2.getEnd_date()));
		
		//-----------------------------------------------------------------------------------------------------------/
		//For cs3: (Boundary test case for price - price at 0.0 (minimum) 
		//Add another schedule test The size of the list is 3? -normal
		//The schedule just added is as same as the second item of the list
		ManageCourse_Schedule.addCSchedule(Course_ScheduleList, cs3);
		assertEquals("Check that Course_ScheduleList arraylist size is 3", 3, Course_ScheduleList.size());
		assertSame("Check that Course Schedule is added", cs3, Course_ScheduleList.get(2));
			
		//Test that price is not a negative number for cs3 - boundary
		assertEquals("Check that price is a positive number?", true, cs3.getPrice() >= 0.0);
					
		//Test that start date is before end date for cs3 - error
		assertEquals("Check that start date is before end date", true, cs3.getStart_date().isBefore(cs3.getEnd_date()));
		
		//-----------------------------------------------------------------------------------------------------------/
		//For cs4: (Error test case for price and date - less than 0.0 and start date/time is after end date/time)
		//Test that price is not a negative number for cs2 - error
		assertEquals("Check that price is a positive number?", true, cs4.getPrice() < 0.0);
						
		//Test that start date is before end date for cs2 - error
		assertEquals("Check that start date is before end date", true, !(cs4.getStart_date().isBefore(cs4.getEnd_date())));
		
	}
	
	@Test
	public void deleteCScheduleTest() {
		retrieveAllCSchedule();
		// Test if arraylist is not null - boundary
		assertNotNull("Test if there is valid Course Schedule arraylist to delete item", Course_ScheduleList);
		
		//Test that if the item have been deleted, the Course_Schedule List arraylist size is decrease by 1 
		// which in this case is 1 - normal
		String id = cs1.getSchedule_id();
		ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, cs1.getSchedule_id());
		assertEquals("Check that Course_ScheduleList arraylist size is 1", 1, Course_ScheduleList.size());
		assertEquals("Check that if the deleted schedule id is not used anymore?",
				true, id != Course_ScheduleList.get(0).getSchedule_id());
						
		//Test that if the item have been deleted, the Course_Schedule List arraylist size is decrease by 1 
		// which in this case is 0 - normal
		ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, cs2.getSchedule_id());
		assertEquals("Check that Course_ScheduleList arraylist size is 0", 0, Course_ScheduleList.size());
		//If the arraylist is 0 which is checked to be 0, then we do not need to check if 
		// the deleted schedule id is not used anymore.
		
		//Test that after the arraylist is null already, deletion can be completed
		ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, cs2.getSchedule_id());
	}

}
