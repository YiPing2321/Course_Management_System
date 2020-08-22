
import java.time.LocalDateTime;

public class Registration {
	private int registration_no;
	private String schedule_id;
	private String email;
	private String status;
	private String start_date;
	private String end_date;
	
	public Registration(int registration_no, String schedule_id, String email, String status, String start_date, String end_date) {
		this.registration_no = registration_no;
		this.schedule_id = schedule_id;
		this.email = email;
		this.status = status;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getRegistration_no() {
		return registration_no;
	}

	public String getSchedule_id() {
		return schedule_id;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

		
	}
	

