import static org.junit.Assert.*;

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
        
        @After
        public void tearDown() throws Exception {
            courseList = null;
        }
        
        @Test
        public void AddAllCourseTest = (Test); {
            //check memberList is not null
            assertNotNull("Test for valid arraylist to add new course", courseList);
            // check that the course code is unique
            char code1 = Helper.readChar("Enter one character code >");
            int code2 = Helper.readInt("Enter integer code >");
            String courseCode = Helper.readString("Enter final course code >");
            if (courseCode.equals(code1 + code2)) {
                System.out.println("This is a valid course code.");
            } else if (courseCode != code1 + code2) {
                System.out.println("Invalid course code! Try again.");
            }
            //check arraylist size is 1 after adding
            ManageCourse.addCourse(courseList);
            assertEquals("Check that courserList size is 1", 1, courseList.size());
        }
        
        @Test
        public void ViewAllCourseTest = (Test); {
            //check memberList is not null
            assertNotNull("Test for valid arraylist to view a course", courseList);
            // check if course code entered is null or not
            String CourseCode = Helper.readString("Enter a course code to view >");
            for (int i = 0; i < courseList.size(); i++) {
                if (courseCode.equals(null)) {
                    courseList = null;
                } else if(courseCode != null) {
                    System.out.println(courseList);
                }
            }
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
                assertNotNull("Test for valid arraylist to delete course from", courseList);
                //Test that if the course have been deleted, the courseList arraylist size decrease by 1
                //0 is normal
                ManageCourse.deleteCourse(courseList);
                assertEquals("Check that courserList arraylist size is 0", 0, courseList.size());
            }

        
        
        

 

    }

 

}
