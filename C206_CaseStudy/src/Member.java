
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19046377, Aug 23, 2020 2:52:08 PM
 */
//Marvin
public class Member {
	private String name;
	private String gender;
	private int mobile_number;
	private String email;
	private String dob;
	private String country;
	
	public Member(String name, String gender, int mobile_number, String email, String dob, String country) {
		this.name = name;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.email = email;
		this.dob = dob;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String x) {
		this.name = x;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String x) {
		this.gender = x;
	}
	
	public int getMobile_number() {
		return mobile_number;
	}
	
	public void setMobile_number(int x) {
		this.mobile_number = x;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String e) {
		this.email = e;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String d) {
		this.dob = d;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String c) {
		this.country = c;
	}
}
