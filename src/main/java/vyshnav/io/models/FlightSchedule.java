package vyshnav.io.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import vyshnav.io.enums.FlightScheduleStatus;

@Getter
@Setter
public class FlightSchedule {
	private String id;
	private Flight flight;
	private int departureTime;
	private String gate;
	private FlightScheduleStatus flightScheduleStatus;
	private List<FlightScheduleSeat> flightScheduleSeatList;
	
	public FlightSchedule(String id, Flight flight) {
		this.id = id;
		this.flight = flight;
		this.flightScheduleSeatList = new ArrayList<>();
	}
	
}
