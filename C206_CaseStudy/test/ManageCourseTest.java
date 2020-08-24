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
<<<<<<< HEAD
       
        @Test
=======
        
<<<<<<< HEAD
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
=======
        
        @Test      
>>>>>>> branch 'master' of https://github.com/YiPing2321/Course_Management_System.git
        public void DeleteCourseTest = (Test); {
<<<<<<< HEAD
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
=======
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
                assertNotNull("Test for valid arraylist to delete course from", courseList);
                //Test that if the course have been deleted, the courseList arraylist size decrease by 1
                //0 is normal
                ManageCourse.deleteCourse(courseList);
                assertEquals("Check that courserList arraylist size is 0", 0, courseList.size());
            }

>>>>>>> branch 'master' of https://github.com/YiPing2321/Course_Management_System.git
        
        
        

 
>>>>>>> branch 'master' of https://github.com/YiPing2321/Course_Management_System.git

    }

}
