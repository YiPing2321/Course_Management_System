import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//By Yi Ping..
public class ManageCourseTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	@Before 
        public void setUp() throws Exception {
    		ArrayList<Course> courseList = new ArrayList<Course>();
        }
        
    	/**
    	 * @throws java.lang.Exception
    	 */
        @After
        public void tearDown() throws Exception {
            courseList = null;
        }
        
        @Test
        public void AddAllCourseTest = (Test); {
            //check course code entered is unique (Normal)
            assertTrue("Check that course code entered is unique", true);
           
            //check course code entered is not unique (Error)
            assertFalse("Check that course code entered is not unique", false);
           
            //check arraylist size is 1 after adding (Boundary)
            ManageCourse.addCourse(courseList);
            assertEquals("Check that courserList size is 1", 1, courseList.size());
        }
       
        @Test
        public void ViewAllCourseTest = (Test); {
            // check if course code entered is null (Normal)
            assertFalse("Check that course code entered is null", False);
           
            // check if course code entered is not null (Error)
            assertTrue("Check that course code entered is not null", True);
        }
        
        @Test
        public void DeleteCourseTest = (Test); {
            ManageCourse.viewCourse(courseList);
            //test course code entered is null
            String courseCode = Helper.readString("Enter course code >");
            for (int i = 0; i < courseList.size(); i++) {
                if (courseCode.equals(null)) {
                    System.out.println("Please enter a course code to delete course");
                } else if (courseCode != null) {
                    courseList.remove(i);
                    System.out.println("Course deleted!");
                }
            }
            //test list not null but empty
            assertNotNull("Test for valid arraylist to delete members from",memberList);
            //Test that if the item have been deleted, the memberList arraylist size decrease by 1 
            //0 is normal
            ManageMember.deleteMembers(memberList);
            assertEquals("Check that memberList arraylist size is 0", 0, memberList.size());
        }


    }

}
