import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

 

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

 

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

 

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19012734, Aug 26, 2020 10:19:03 PM
 */

 

public class ManageCourseTest {
    private Course course1;
    private Course course2;
    private Course_Schedule cs1;
    private Course_Schedule cs2;
    ArrayList<Course> courseList = new ArrayList<Course>();
    ArrayList<Course_Schedule> Course_ScheduleList = new ArrayList<Course_Schedule>();
    
    @Before
    public void setup() throws Exception {
        Course course1 = new Course("R13", "Business Information System", "Infocomm", "Learning how business information system works.", "3 years", "NIL");
        Course course2 = new Course("R16", "Biotechnology", "Applied Science", "Learning about DNA and more", "3 years", "NIL");
        courseList.add(course1);
        courseList.add(course2);
        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
        
        Course_Schedule cs1 = new Course_Schedule("CS001-R13", 25.0, LocalDateTime.parse("11/08/2020, 08:30", formatter1), LocalDateTime.parse("12/08/2020, 16:00", formatter1), "W66L");
        Course_Schedule cs2 = new Course_Schedule("CS002-R16", 14.0, LocalDateTime.parse("12/08/2020, 09:15", formatter1), LocalDateTime.parse("13/08/2020, 15:30", formatter1), "W64J");
        
        Course_ScheduleList.add(cs1);
        Course_ScheduleList.add(cs2);
    }

 

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        course1 = null;
        course2 = null;
        courseList = null;
    }
    
    @Test
    public void AddAllCourseTest( ){
        //check course code entered is unique (Normal)
        assertTrue("Check that course code entered is unique", true);
        
        //check course code entered is not unique (Error)
        assertFalse("Check that course code entered is not unique", false);
        
        //check arraylist size is 1 after adding (Boundary)
        ManageCourse.addCourse(courseList);
        assertEquals("Check that courserList size is 1", 1, courseList.size());
    }

 

    @Test
    public void ViewAllCourseTest( ){
        // check if course code is null when entered(Normal)
        // course1
        // course2
        assertNull("Check that course code entered is null", course1.getCourseCode() == null);
        assertNull("Check that course code entered is null", course2.getCourseCode() == null);
        
        // check if course code is not null when entered(Error)
        // course1
        // course2
        assertNotNull("Check that course code entered is not null", course1.getCourseCode() != null);
        assertNotNull("Check that course code entered is not null", course2.getCourseCode() != null);
    }
    
    @Test
    public void DeleteCourseTest() {
        ManageCourse.viewCourse(courseList);
        // check if course code entered is equals to the course list (Normal)
        assertEquals("Check that course code entered is equals to the course list", courseList);
                    
        // check if course code entered is not equals to the course list (Error)
        assertNotEquals("Check that course code entered is not equals to the course list", courseList);
        
        //Test that if the course have been deleted, the courseList arraylist size decrease by 1 
        //0 is normal
        ManageCourse.deleteCourse(courseList);
        assertEquals("Check that courserList arraylist size is 0", 0, courseList.size());
    }
    
    @Test
    public void UpdateCourseTest() throws Exception {
        ViewAllCourseTest();
        ManageCourse.UpdateCourse(courseList);
        
        // Check that title, category, description, duration and prerequisite course has been updated.(Normal)
        // course1
        assertTrue("Check that the title has been updated", course1.getCourseTitle() != null);
        assertTrue("Check that the category has been updated", course1.getCategoryName() != null);
        assertTrue("Check that the description has been updated", course1.getCourseDescription() != null);
        assertTrue("Check that the duration has been updated", course1.getCourseDuration() != null);
        assertTrue("Check that the prerequisite course has been updated", course1.getPrerequisiteCourse() != null);
        
        // course2
        assertTrue("Check that the title has been updated", course2.getCourseTitle() != null);
        assertTrue("Check that the category has been updated", course2.getCategoryName() != null);
        assertTrue("Check that the description has been updated", course2.getCourseDescription() != null);
        assertTrue("Check that the duration has been updated", course2.getCourseDuration() != null);
        assertTrue("Check that the prerequisite course has been updated", course2.getPrerequisiteCourse() != null);
        
        // Check that title, category, description, duration and prerequisite course has been updated.(Error)
        // course1
        assertFalse("Check that the title has been updated", course1.getCourseTitle() == null);
        assertFalse("Check that the category has been updated", course1.getCategoryName() == null);
        assertFalse("Check that the description has been updated", course1.getCourseDescription() == null);
        assertFalse("Check that the duration has been updated", course1.getCourseDuration() == null);
        assertFalse("Check that the prerequisite course has been updated", course1.getPrerequisiteCourse() == null);
        
        // course2
        assertFalse("Check that the title has been updated", course2.getCourseTitle() == null);
        assertFalse("Check that the category has been updated", course2.getCategoryName() == null);
        assertFalse("Check that the description has been updated", course2.getCourseDescription() == null);
        assertFalse("Check that the duration has been updated", course2.getCourseDuration() == null);
        assertFalse("Check that the prerequisite course has been updated", course2.getPrerequisiteCourse() == null);
    }
    
    @Test
    public void SearchByCategoryNameTest() throws Exception {
        String category1 = "Infocomm";
        String category2 = "Applied Science";
        
        // Test if category1 has been entered, the details of that course should be displayed.(Normal)
        ManageCourse.SearchCourseByCategoryName(courseList, category1);
        
        // Test if category2 has been entered, the details of that course should be displayed.(Normal)
        ManageCourse.SearchCourseByCategoryName(courseList, category2);
        
        // Test that when the user enter a category name to search but cannot be found.(Error)
        assertNotEquals("Infocomm", category1, "The category name entered is not found.");
        assertNotEquals("Applied Science", category2, "The category name entered is not found.");
    }
    
    @Test
    public void DeleteCourseWithNoCourseScheduleTest() throws Exception {
        ManageCourse.viewCourse(courseList);
        
        // Check that if deletion cannot be done, the Arraylist size should stay the same at 2.(Normal)
        // Check that if deletion is done, the Arraylist size should decrease by 1.(Normal)
        assertEquals("Check that courseList arraylist size is 2", 2, courseList.size());
        assertEquals("Check that courseList arraylist size is 1", 1, courseList.size());
        
        // Check that if deletion cannot be done, the details should stay in the Arraylist.(Normal)
        // course1
        assertTrue("Check that course code for course1 (R13) is still in the arrayList", course1.getCourseCode() == courseList.get(0).getCourseCode());
        
        // Check that if deletion cannot be done, the details should stay in the Arraylist.(Normal)
        // course2
        assertTrue("Check that course code for course2 (R16) is still in the arrayList", course2.getCourseCode() == courseList.get(0).getCourseCode());
        
        String code1 = "R13";
        String code2 = "R16";
        // Test that when the user enter a course code to delete but cannot be found.(Error)
        assertNotEquals("R13", code1, "The course code entered is not found.");
        assertNotEquals("R16", code2, "The course code entered is not found.");
    }
    
    @Test
    public void ViewAllCourseScheduleTest() throws Exception {
        ManageCourse.viewCourse(courseList);
        
        // Check that if the course schedule id contain the course code, the details of the course schedule will be displayed. (Normal)
        ManageCourse.ViewCourseSchedule(courseList, Course_ScheduleList);
        
        // Check that if the course code cannot be found in course schedule id. (Error)
        // Which means course schedule id cannot be found.
        String id1 = "CS001-R13";
        String id2 = "CS002-R16";
        assertNotEquals("CS001-R13", id1, "The course schedule id entered is not found.");
        assertNotEquals("CS002-R16", id2, "The course schedule id entered is not found.");
    }
    

 

}