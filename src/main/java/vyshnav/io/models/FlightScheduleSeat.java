package vyshnav.io.models;


import lombok.Getter;
import lombok.Setter;
import vyshnav.io.enums.SeatStatus;
import vyshnav.io.enums.SeatType;

@Getter
@Setter
public class FlightScheduleSeat extends FlightSeat{
	private String id;
	//	private FlightSchedule flightSchedule; // you can use it if you want to get FlightSchedule from FlightScheduleSeat. Just justify your code to interviewer
	private int fare;
	private SeatStatus status;
	

	public FlightScheduleSeat(String id, String seatNumber, SeatType seatType) {
		super(id, seatNumber, seatType);
	}
	
}
