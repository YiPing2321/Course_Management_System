
import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19012734, Aug 22, 2020 3:03:32 PM
 */

public class ManageCourse {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Course> courseList = new ArrayList<Course>();
        
        int option = 0;

        while (option != 4) {

            ManageCourse.menu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                addCourse(courseList);
            } else if (option == 2) {
                viewCourse(courseList);
            } else if (option == 3) {
                deleteCourse(courseList);
            } else if (option == 4) {
                System.out.println("Thank you for using this system. Bye!");
            } else {
                System.out.println("Invalid option");
            }
        }
    }
        
    private static void addCourse(ArrayList<Course> courseList) {
        // TODO Auto-generated method stub
        Helper.line(40, "=");
        System.out.println("ADDING COURSE");
        Helper.line(40, "=");

 

        String courseCode = Helper.readString("Enter course code > ");
        String courseTitle = Helper.readString("Enter course title > ");
        String categoryName = Helper.readString("Enter category name > ");
        String courseDescription = Helper.readString("Enter course description > ");
        String courseDuration = Helper.readString("Enter course duration > ");
        String pre_requisite = Helper.readString("Enter prerequisite course > ");
        
        courseList.add(new Course(courseCode, courseTitle, categoryName, courseDescription, courseDuration, pre_requisite));

 

        ManageCourse.viewCourse(courseList);
        
        System.out.println("Course added!");        
    }

    private static void viewCourse(ArrayList<Course> courseList) {
        // TODO Auto-generated method stub
        System.out.println("COURSE LIST");
        
        String output = String.format("%-15s %-15s %-20s %-20s %15s %-15s \n", "COURSE CODE" , "COURSE TITLE", "CATEGORY NAME", "COURSE DESCRIPTION", "COURSE DURATION", "PRE-REQUISITE COURSE");
        
        for (int i = 0; i < courseList.size(); i++) {
            output += String.format("%-15s %-15s %-20s %-20s %15s %-15s \n", courseList.get(i).getCourseCode(), courseList.get(i).getCourseTitle(), courseList.get(i).getCategoryName(), courseList.get(i).getCourseDescription(), courseList.get(i).getCourseDuration(), courseList.get(i).getPrerequisiteCourse());
        }
        System.out.println(output);
    }

    private static void deleteCourse(ArrayList<Course> courseList) {
        // TODO Auto-generated method stub
        String code = Helper.readString("Enter course code > ");
        char confirm = Helper.readChar("Are you sure you want to delete this course? (y/n) >"); 
        
        for (int i = 0; i < courseList.size(); i++) {
            if (code == courseList.get(i).getCourseCode()) {
                if (confirm == 'y') {
                    courseList.remove(i);
                    System.out.println("Course deleted!");
                }
            } else if (code != courseList.get(i).getCourseCode()) {
                System.out.println("Invalid code.");
            }
        }
        
    }

        public static void menu() {
            System.out.println("MANAGE COURSE MENU");
            System.out.println("1. ADD COURSE");
            System.out.println("2. VIEW COURSE");
            System.out.println("3. DELETE COURSE");
            System.out.println("4. QUIT");
        }
}
