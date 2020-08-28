
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

    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return CourseCode;
    }

    /**
     * @return the courseTitle
     */
    public String getCourseTitle() {
        return CourseTitle;
    }
    
    /**
     * @param courseTitle the courseTitle to set
     */
    public void setCourseTitle(String courseTitle) {
        CourseTitle = courseTitle;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return CategoryName;
    }
    
    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    /**
     * @return the courseDescription
     */
    public String getCourseDescription() {
        return CourseDescription;
    }
    
    /**
     * @param courseDescription the courseDescription to set
     */
    public void setCourseDescription(String courseDescription) {
        CourseDescription = courseDescription;
    }

    /**
     * @return the courseDuration
     */
    public String getCourseDuration() {
        return CourseDuration;
    }
    
    /**
     * @param courseDuration the courseDuration to set
     */
    public void setCourseDuration(String courseDuration) {
        CourseDuration = courseDuration;
    }

    /**
     * @return the prerequisiteCourse
     */
    public String getPrerequisiteCourse() {
        return PrerequisiteCourse;
    }
    
    /**
     * @param prerequisiteCourse the prerequisiteCourse to set
     */
    public void setPrerequisiteCourse(String prerequisiteCourse) {
        PrerequisiteCourse = prerequisiteCourse;
    }

}
