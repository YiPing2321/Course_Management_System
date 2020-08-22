
public class Course_Category {
	
	private String course_name;
	private String course_description;
	
	public Course_Category(String course_name, String course_description) {
		this.course_name = course_name;
		this.course_description = course_description;
	}

	public String getCourse_name() {
		return course_name;
	}

	public String getCourse_description() {
		return course_description;
	}
	
}
