package vyshnav.io.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import vyshnav.io.enums.SeatType;
import vyshnav.io.models.Airline;
import vyshnav.io.models.Airport;
import vyshnav.io.models.Flight;
import vyshnav.io.models.FlightSchedule;
import vyshnav.io.models.FlightScheduleSeat;
import vyshnav.io.services.FlightService;

@AllArgsConstructor
public class FlightController {
	private final FlightService flightService;
	
	public String createAirline(@NonNull String airlineName) {
		return flightService.createAirline(airlineName).getId();	
	}
	
	public String createAirport(@NonNull String airportName) {
		return flightService.createAirport(airportName).getId();
	}
	
	public String creatFlight(@NonNull String airlineId, @NonNull String flightNumber) {
		return flightService.createFlight(airlineId, flightNumber).getId();
	}
	
	public String createFlightSchedule(@NonNull String flightId) {
		return flightService.createFlightSchedule(flightId).getId();
	}
	
	public String creatFlightSeat(@NonNull String seatNumber, @NonNull SeatType seatType) {
		return flightService.createFlightSeat(seatNumber, seatType).getId();
	}
	
	public String creatFlightScheduleSeat(@NonNull String seatNumber, @NonNull SeatType seatType) {
		return flightService.createFlightScheduleSeat(seatNumber, seatType).getId();
	}

	public Airline getAirline(@NonNull String airlineId) {
		return flightService.getAirline(airlineId);
	}
	
	public Airport getAirport(@NonNull String airportId) {
		return flightService.getAirport(airportId);
	}

	public Flight getFlight(@NonNull String flightId) {
		return flightService.getFlight(flightId);
	}

	public FlightSchedule getFlightSchedule(@NonNull String flightScheduleId) {
		return flightService.getFlightSchedule(flightScheduleId);
	} 
	
	public FlightScheduleSeat getFlightScheduleSeat(@NonNull String flightScheduleSeatId) {
		return flightService.getFlightScheduleSeat(flightScheduleSeatId);
	}

	public String updateFlight(@NonNull String flightId, @NonNull Flight flight) {
		return flightService.updateFlight(flightId, flight).getId();
	}

	public String updateFlightSchedule(String flightScheduleId, FlightSchedule flightSchedule) {
		return flightService.updateFlightSchedule(flightScheduleId, flightSchedule).getId();
		
	}
}
