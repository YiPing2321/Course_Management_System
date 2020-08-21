
import java.time.LocalDateTime;

public class Registration {
	private int registration_no;
	private String schedule_id;
	private String email;
	private String status;
	private LocalDateTime start_date;
	private LocalDateTime end_date;
	
	public Registration(int registration_no, String schedule_id, String email, String status, LocalDateTime start_date, LocalDateTime end_date) {
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

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}

		
	}
	

