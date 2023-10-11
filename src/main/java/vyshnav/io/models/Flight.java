package vyshnav.io.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {
	private String id;
	private Airline airline;
	private String flightNumber;
	private Airport departureAirport;
	private Airport arrivalAirport;
	private int duration;
//	private List<FlightSchedule> flightScheduleList; // you can use it if you want to get flightScheduleList from Flight. Just justify your code to interviewer
	private List<FlightSeat> seatList;	
	
	public Flight(String id, Airline airline, String flightNumber) {
		this.id = id;
		this.airline = airline;
		this.flightNumber = flightNumber;
		this.seatList = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (flightNumber == null) {
			if (other.flightNumber != null)
				return false;
		} else if (!flightNumber.equals(other.flightNumber))
			return false;
		return true;
	}
	
	
	
	
}
