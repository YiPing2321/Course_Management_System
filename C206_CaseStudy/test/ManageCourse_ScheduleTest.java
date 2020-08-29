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
//By Guang Hao..
public class ManageCourse_ScheduleTest {
	//To Run everything successfully
	//When you will see the main menu
	//Select Option 1 (Manage Member) and quit
	//Select Option 5 (Manage Registration) and quit
	//Select Option 4 (Manage Course Schedule) and quit
	//Now you will only need to just press the quit everytime the main menu appears

	private static final String[] args = null;
	private Course_Schedule cs1;
	private Course_Schedule cs2;
	private Course_Schedule cs3;
	private Course_Schedule cs4;
	private static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
	
	private ArrayList<Course_Schedule> Course_ScheduleList;
	
	@Before
	public void setUp() throws Exception {
		C206_CaseStudy.main(args);
		//normal - cs1 and cs2
		cs1 = new Course_Schedule("CS001-R13", 25.0, LocalDateTime.parse("11/08/2020, 08:30", formatter1), 
				LocalDateTime.parse("12/08/2020, 16:00", formatter1), "W66L");
		
		cs2 = new Course_Schedule("CS002-R13", 14.0, LocalDateTime.parse("15/08/2020, 09:15", formatter1), 
				LocalDateTime.parse("15/08/2020, 15:30", formatter1), "W64J");
		
		//Testing boundary - cs3
		cs3 = new Course_Schedule("CS003-R16", 0.1, LocalDateTime.parse("13/08/2020, 09:45", formatter1), 
				LocalDateTime.parse("13/08/2020, 09:46", formatter1), "W46L");
		
		//For error test purpose - cs4
		cs4 = new Course_Schedule("CS003-R13", -0.1, LocalDateTime.parse("13/08/2020, 09:45", formatter1), 
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
		cs3 = null;
		
		Course_ScheduleList = null;
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
		assertEquals("Check that price is a positive number?", true, cs1.getPrice() > 0.1);
		
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
		assertEquals("Check that price is a positive number?", true, cs2.getPrice() > 0.1);
				
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
		assertEquals("Check that price is a positive number?", true, cs3.getPrice() >= 0.1);
					
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
	public void retrieveAllCSchedule() {
		// Test if Course Schedule list is not null - boundary
		assertNotNull("Test if there is valid Course_ScheduleList arraylist to retrieve schedule", Course_ScheduleList);
		
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
		
		//test if the expected output string same as the list of Course Schedule retrieved 	
		allCSchedule= ManageCourse_Schedule.retrieveAllCSchedule(Course_ScheduleList);
		testOutput = String.format("%-20s %-10.1f %-20s %-20s %-30s\n", "CS001-R13", 25.0, 
				LocalDateTime.parse("11/08/2020, 08:30", formatter1), 
				LocalDateTime.parse("12/08/2020, 16:00", formatter1), "W66L");
		
		testOutput += String.format("%-20s %-10.1f %-20s %-20s %-30s\n", "CS002-R13", 14.0, 
				LocalDateTime.parse("15/08/2020, 09:15", formatter1), 
				LocalDateTime.parse("15/08/2020, 15:30", formatter1), "W64J");
	
		assertEquals("Test that ViewAllCSchedulelist", testOutput, allCSchedule);
	}
	
	@Test
	public void deleteCScheduleTest() {
		
		retrieveAllCSchedule();

		// Test if Course Schedule list is not null then they will be able to delete schedule - boundary
		assertNotNull("Test if there is valid Course Schedule arraylist to delete schedule", Course_ScheduleList);
		
		//---------------------------------Testing for cs1:--------------------------------------------//
		//Test that if there are course schedule id have registered member, deletion cannot be continue 
		// - cs1 of course schedule id (CS001) have 2 registered member -> normal
		String id = cs1.getSchedule_id();
		int count = ManageCourse_Schedule.checkMember(id);
		assertTrue("Test if there are registered member? > ", count > 0);
		
		//Since there are registered member, deletion cannot be done - normal
		ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, cs1.getSchedule_id(), count);
		
		//Since deletion is not done, the arraylist size should stay at 2 - normal
		assertEquals("Check that Course_ScheduleList arraylist size is 2", 2, Course_ScheduleList.size());
		
		//Since deletion cannot be done then the details should stay in the arraylist
		assertTrue("Check that course schedule id for (CSOO1) is still in the arrayList",
				cs1.getSchedule_id() == Course_ScheduleList.get(0).getSchedule_id());
		
		//---------------------------------Testing for cs2:--------------------------------------------//
		//Test that if there are course schedule id have registered member, deletion cannot be continue 
		// - cs2 of course schedule id (CS002) have 0 registered member -> boundary
		id = cs2.getSchedule_id();
		count = ManageCourse_Schedule.checkMember(id);
		assertFalse("Test if there are registered member? > ", count > 0);
		
		//Since there are 0 registered member, the details can be deleted 
		ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, cs2.getSchedule_id(), count);
		
		//After deletion, the Course Schedule List size should decrease by 1
		assertEquals("Check that Course_ScheduleList arraylist size is 1?", 1, Course_ScheduleList.size());
		
		
		//---------------------------------Testing for cs3:--------------------------------------------//
		//Test that if there are course schedule id have registered member, deletion cannot be continue 
		// - cs3 of course schedule id (CS003) have 0 registered member -> boundary
		id = cs3.getSchedule_id();
		count = ManageCourse_Schedule.checkMember(id);
		assertFalse("Test if there are registered member? > ", count > 0);
		
		//Since there are 0 registered member, the details can be deleted 
		ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, cs3.getSchedule_id(), count);
		
		//After deletion, the Course Schedule List size should decrease by 1
		assertEquals("Check that Course_ScheduleList arraylist size is 1?", 1, Course_ScheduleList.size());
		
		
		//Test that after the course schedule id for "CS002" and "CS003" is already deleted,
		//it should not be able to be found in the arraylist anymore
		//Error Message : "Course Schedule cannot be found"
		ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, cs2.getSchedule_id(), ManageCourse_Schedule.checkMember(cs2.getSchedule_id()));
		ManageCourse_Schedule.deleteCSchedule(Course_ScheduleList, cs3.getSchedule_id(), ManageCourse_Schedule.checkMember(cs3.getSchedule_id()));
	}
	
	@Test
	public void updateCScheduleTest() {
		retrieveAllCSchedule();
		//For cs1:
		//Test that cs1 can be update if it can be found in the list
		//Updated value 
		//Price -> 0.1
		//Start date/time -> 08/08/2020, 00:00
		//End date/time -> 08/08/2020, 00:01
		//Location -> W45K
		ManageCourse_Schedule.updateCSchedule(Course_ScheduleList, cs1.getSchedule_id()); //normal
		
		//Test that price is updated to 0.1 and it is cannot be a negative number 
		assertTrue("Check that the price is updated to 0.0? ", cs1.getPrice() == 0.1);
		assertTrue("Check that price is a positive number?", cs1.getPrice() >= 0.1); //boundary condition
		
		//Test that if cs1 end date/time is before start date/time
		//If condition is true when user enter the user input, the error message "Start date should be before end date"
		//Continue entering the input, until it is correct
		//If user have entered correct and update to the list, cs1 should display false
		assertFalse("Check that end date/time is not before start date/time", cs1.getEnd_date().isBefore(cs1.getStart_date()));
		
		//For cs2:
		//Test that cs2 can be update if it can be found in the list
		//Price -> 0.1
		//Start date/time -> 08/08/2020, 08:40
		//End date/time -> 08/08/2020, 16:00
		//Location -> W46L
		ManageCourse_Schedule.updateCSchedule(Course_ScheduleList, cs2.getSchedule_id());
		
		//Test that price is updated to 0.1 and it is cannot be a negative number
		assertTrue("Check that the price is updated to 0.0? ", cs2.getPrice() == 0.1);
		assertTrue("Check that price is a positive number?", cs2.getPrice() >= 0.1); //boundary condition
		
		//Test that if cs2 end date/time is before start date/time
		//If condition is true when user enter the user input, the error message "Start date should be before end date"
		//Continue entering the input, until it is correct
		//If user have entered correct and update to the list, cs2 should display false
		assertFalse("Check that end date/time is not before start date/time", cs2.getEnd_date().isBefore(cs2.getStart_date()));
		
	}
	
	@Test
	public void SearchByPriceTest() {
		retrieveAllCSchedule();
		
		double price = 25.0;
		//Test if cs1 have the price 25.0, it should display the details - normal
		ManageCourse_Schedule.SearchByPrice(Course_ScheduleList, price);
		
		price = 0.1;
		//Test if cs2 does not have the price 0.0, it should not display any details - boundary
		ManageCourse_Schedule.SearchByPrice(Course_ScheduleList, price);
		
		//Test if the user entered a price that is negative or a zero amount - error
		//Print "Price cannot be zero or negative amount" if condition met
		price = 0.0;
		ManageCourse_Schedule.SearchByPrice(Course_ScheduleList, price);
		
		price = -10;
		ManageCourse_Schedule.SearchByPrice(Course_ScheduleList, price);
	}
	
	@Test
	public void viewMemberDetailsTest() {
		retrieveAllCSchedule();
		
		//Test if there are registered member linking to the id (CS001),
		// then details will be display - normal 
		ManageCourse_Schedule.viewMemberDetails(Course_ScheduleList, cs1.getSchedule_id());
		
		
		//Test if there are registered member linking to the id (CS002),
		// then details will be display - boundary
		ManageCourse_Schedule.viewMemberDetails(Course_ScheduleList, cs2.getSchedule_id());
		
		//Test if what happen when that course schedule id is not found in the course schedule list
		String id = "CS100-R13";
		ManageCourse_Schedule.viewMemberDetails(Course_ScheduleList, id);
	}
	
}
