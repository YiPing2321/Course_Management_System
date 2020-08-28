import java.time.LocalDateTime;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19030407, Aug 22, 2020 7:29:13 AM
 */

public class Course_Schedule {
	private String schedule_id;
	private double price;
	private LocalDateTime start_date;
	private LocalDateTime end_date;
	private String location;
	
	public Course_Schedule(String schedule_id, double price, LocalDateTime start_date, LocalDateTime end_date,
			String location) {
		this.schedule_id = schedule_id;
		this.price = price;
		this.start_date = start_date;
		this.end_date = end_date;
		this.location = location;
	}
	
	public String getSchedule_id() {
		return schedule_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String display() {
		
		String output = String.format("%-20s %-10.1f %-20s %-20s %-30s\n", schedule_id, price, start_date, end_date, location);
		
		return output;
		
	}
}
