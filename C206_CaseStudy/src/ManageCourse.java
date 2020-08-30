
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19012734, Aug 22, 2020 3:03:32 PM
 */

public class ManageCourse {
    private static final int Option_Add = 1;
    private static final int Option_View = 2;
    private static final int Option_DeleteCourse = 3;
    private static final int Option_Update = 4;
    private static final int Option_Search = 5;
    private static final int Option_Delete = 6;
    private static final int Option_ViewSchedule = 7;
    private static final int Option_Quit = 8;


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Course> courseList = new ArrayList<Course>();
        
        Course course1 = new Course("R13", "Business Information System", "Infocomm", "Learning how business information system works.", "3 years", "NIL");
        Course course2 = new Course("R16", "Biotechnology", "Applied Science", "Learning about DNA and more", "3 years", "NIL");
        courseList.add(course1);
        courseList.add(course2);
        
        ArrayList<Course_Schedule> Course_ScheduleList = new ArrayList<Course_Schedule>();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");
        
        Course_ScheduleList.add(new Course_Schedule("CS001-R13", 25.0, LocalDateTime.parse("11/08/2020, 08:30", formatter1), 
                LocalDateTime.parse("12/08/2020, 16:00", formatter1), "W66L"));
        
        Course_ScheduleList.add(new Course_Schedule("CS002-R16", 14.0, LocalDateTime.parse("12/08/2020, 09:15", formatter1), 
                LocalDateTime.parse("13/08/2020, 15:30", formatter1), "W64J"));
        
        int option = 0;


        while (option != 8) {


            ManageCourse.Course_menu();
            option = Helper.readInt("Enter an option > ");


            if (option == Option_Add) {
                addCourse(courseList);
            } else if (option == Option_View) {
                viewCourse(courseList);
            } else if (option == Option_DeleteCourse) {
                deleteCourse(courseList);
            } else if (option == Option_Update) {
                UpdateCourse(courseList);
            } else if (option == Option_Search) {
                String searchName = Helper.readString("Enter category name to search >");
                SearchCourseByCategoryName(courseList, searchName);
            } else if (option == Option_Delete) {
                ManageCourse.DeleteCourse(courseList, Course_ScheduleList);
            } else if (option == Option_ViewSchedule) {
                ManageCourse.ViewCourseSchedule(courseList, Course_ScheduleList);
            } else if (option == Option_Quit) {
                System.out.println("Thank you for using course management system!");
            } else {
                System.out.println("Invalid option.");
            }
        }


    }


        /**
     * 
     */
    @SuppressWarnings("unlikely-arg-type")
    public static void addCourse(ArrayList<Course> courseList) {
        // TODO Auto-generated method stub
        Helper.line(40, "=");
        System.out.println("ADDING COURSE");
        Helper.line(40, "=");


        char code1 = Helper.readChar("Enter one character code >");
        int code2 = Helper.readInt("Enter integer code >");
        String courseCode = Helper.readString("Enter course code > ");
        String courseTitle = Helper.readString("Enter course title > ");
        String categoryName = Helper.readString("Enter category name > ");
        String courseDescription = Helper.readString("Enter course description > ");
        String courseDuration = Helper.readString("Enter course duration > ");
        String pre_requisite = Helper.readString("Enter prerequisite course > ");
        
        if (courseCode.equals(code1 + code2)) {
            System.out.println("This is a valid course code.");
        } else {
            System.out.println("Invalid course code! Try again.");
        }
        
        courseList.add(new Course(courseCode, courseTitle, categoryName, courseDescription, courseDuration, pre_requisite));


        ManageCourse.viewCourse(courseList);
        
        System.out.println("Course added!");



        
    }

    public static void viewCourse(ArrayList<Course> courseList) {
        // TODO Auto-generated method stub
        System.out.println("COURSE LIST");


        String output = String.format("%-15s %-30s %-20s %-50s %20s %-20s \n", "COURSE CODE" , "COURSE TITLE", "CATEGORY NAME", "COURSE DESCRIPTION", "COURSE DURATION", "PRE-REQUISITE COURSE");
        
        for (int i = 0; i < courseList.size(); i++) {
            output += String.format("%-15s %-30s %-20s %-50s %20s %-20s \n", courseList.get(i).getCourseCode(), courseList.get(i).getCourseTitle(), courseList.get(i).getCategoryName(), courseList.get(i).getCourseDescription(), courseList.get(i).getCourseDuration(), courseList.get(i).getPrerequisiteCourse());
        }
        
        String CourseCode = Helper.readString("Enter a course code to view >");
        for (int i = 0; i < courseList.size(); i++) {
            if (CourseCode.equals(null)) {
                courseList = null;
            } else if(CourseCode != null) {
                System.out.println("You are able to view the courses.");
            }
        }
        System.out.println(output);
    }

    public static void deleteCourse(ArrayList<Course> courseList) {
        // TODO Auto-generated method stub
        String code = Helper.readString("Enter course code > ");
        char confirm = Helper.readChar("Are you sure you want to delete this course? (y/n) >");
        
        for (int i = 0; i < courseList.size(); i++) {
            String courseCode = courseList.get(i).getCourseCode();
            if (code.equals(courseCode)) {
                if (confirm == 'y') {
                    courseList.remove(i);
                    System.out.println("Course deleted!");
                }
            } else if (code != courseList.get(i).getCourseCode()) {
                System.out.println("Invalid code.");
            }
        }
        
    }
    
    public static void UpdateCourse(ArrayList<Course> courseList) {
        // TODO Auto-generated method stub
        String code = Helper.readString("Enter course code >");
        
        Helper.line(20, "=");
        System.out.println("Update course details");
        Helper.line(20, "=");
            
        String title = Helper.readString("Enter new course title >");
        String category = Helper.readString("Enter new course category >");
        String description = Helper.readString("Enter new course description >");
        String duration = Helper.readString("Enter new course duration > ");
        String prerequisite = Helper.readString("Enter new prerequisite course >");
            
        for (int i = 0; i < courseList.size(); i++) {
            if (code.equals(courseList.get(i).getCourseCode())) {
                        
                if (title == null) {
                    System.out.println("Please fill in the field.");
                }
                if (category == null) {
                    System.out.println("Please fill in the field.");
                }
                if (description == null) {
                    System.out.println("Please fill in the field.");
                }
                if (duration == null) {
                    System.out.println("Please fill in the field.");
                }
                if (prerequisite == null) {
                    System.out.println("Please fill in the field.");
                } else {
                    courseList.get(i).setCourseTitle(title);
                    courseList.get(i).setCategoryName(category);
                    courseList.get(i).setCourseDescription(description);
                    courseList.get(i).setCourseDuration(duration);
                    courseList.get(i).setPrerequisiteCourse(prerequisite);
                    System.out.println("Course details has been updated.");
                }
            }    
        }
        ManageCourse.viewCourse(courseList);
    }
       
    public static void SearchCourseByCategoryName(ArrayList<Course> courseList, String searchName) {
        // TODO Auto-generated method stub
        Helper.line(20, "=");
        System.out.println("Search course by category name");
        Helper.line(20, "=");
        
        String output = String.format("%-15s %-30s %-20s %-50s %20s %-20s \n", "COURSE CODE" , "COURSE TITLE", "CATEGORY NAME", "COURSE DESCRIPTION", "COURSE DURATION", "PRE-REQUISITE COURSE");
        
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCategoryName().equals(searchName)) {
                if (courseList.get(i).getCategoryName().contains(searchName)) {
                    Course c = courseList.get(i);
                    output += String.format("%-15s %-30s %-20s %-50s %20s %-20s \n", c.getCourseCode(), c.getCourseTitle(), c.getCategoryName(), c.getCourseDescription(), c.getCourseDuration(), c.getPrerequisiteCourse());
                    System.out.println(output);
                } else {
                    System.out.println("Category name entered does not exist.");
                }
            }
        }
        
    }

    public static void DeleteCourse(ArrayList<Course> courseList, ArrayList<Course_Schedule> Course_ScheduleList) {
        // TODO Auto-generated method stub
        String code = Helper.readString("Enter course code > ");
        char confirm = Helper.readChar("Are you sure you want to delete this course? (y/n) >");
        
        for (int i = 0; i < courseList.size(); i++) {
            if (Course_ScheduleList.get(i).getSchedule_id().contains(code)) {
                if (confirm == 'y') {
                    System.out.println("This course cannot be deleted because it have a course schedule.");
                }
            } else {
                courseList.remove(i);
            }
        }
        
    }

    public static void ViewCourseSchedule(ArrayList<Course> courseList, ArrayList<Course_Schedule> Course_ScheduleList) {
        // TODO Auto-generated method stub
        System.out.println("COURSE SCHEDULE LIST");
        
        String output = String.format("%-20s %-10s %-20s %-20s %-30s\n", "Course Schedule Id", "Price", "Start Date/Time", "End Date/Time", "Location");
        String code = Helper.readString("Enter course code > ");
        
        for (int i = 0; i < Course_ScheduleList.size(); i++) {
            output += String.format("%-20s %-10.1f %-20s %-20s %-30s\n", Course_ScheduleList.get(i).getSchedule_id(), Course_ScheduleList.get(i).getPrice(), Course_ScheduleList.get(i).getStart_date(), Course_ScheduleList.get(i).getEnd_date(), Course_ScheduleList.get(i).getLocation());
            if (Course_ScheduleList.get(i).getSchedule_id().contains(code)) {
                System.out.println(output);
            } else {
                System.out.println("Course schedule id cannot be found.");
            }
        }
        
    }


        public static void Course_menu() {
            C206_CaseStudy.setHeader("Manage Course menu");
            System.out.println("1. ADD COURSE");
            System.out.println("2. VIEW COURSE");
            System.out.println("3. DELETE COURSE");
            System.out.println("4. UPDATE COURSE");
            System.out.println("5. SEARCH COURSE BY CATEGORY NAME");
            System.out.println("6. DELETE COURSE SCHEDULE");
            System.out.println("7. VIEW COURSE SCHEDULE");
            System.out.println("8. QUIT");
        }


}






