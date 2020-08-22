
public class Course {
    private String CourseCode;
    private String CourseTitle;
    private String CategoryName;
    private String CourseDescription; 
    private String CourseDuration;
    private String PrerequisiteCourse;
    
    public Course(String CourseCode, String CourseTitle, String CategoryName, String CourseDescription, String CourseDuration, String PrerequisiteCourse) {
        this.CourseCode = CourseCode;
        this.CourseTitle = CourseTitle;
        this.CategoryName = CategoryName;
        this.CourseDescription = CourseDescription;
        this.CourseDuration = CourseDuration;
        this.PrerequisiteCourse = PrerequisiteCourse;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public String getCourseDescription() {
        return CourseDescription;
    }

    public String getCourseDuration() {
        return CourseDuration;
    }

    public String getPrerequisiteCourse() {
        return PrerequisiteCourse;
    }
}
