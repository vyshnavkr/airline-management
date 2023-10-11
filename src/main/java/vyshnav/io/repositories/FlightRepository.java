package vyshnav.io.repositories;

import java.util.HashMap;
import java.util.Map;

import vyshnav.io.models.Airline;
import vyshnav.io.models.Airport;
import vyshnav.io.models.Flight;
import vyshnav.io.models.FlightSchedule;
import vyshnav.io.models.FlightScheduleSeat;
import vyshnav.io.models.FlightSeat;

// Doubt: Do we need @NonNull in repository functions' arguments
public class FlightRepository {
	
	private Map<String, Airport> airportMap;
	private Map<String, Airline> airlineMap;
	private Map<String, Flight> flightMap;
	private Map<String, FlightSchedule> flightScheduleMap;
	private Map<String, FlightSeat> flightSeatMap;
	private Map<String, FlightScheduleSeat> flightScheduleSeatMap;
	
	public FlightRepository() {
		this.airportMap = new HashMap<>();
		this.airlineMap = new HashMap<>();
		this.flightMap = new HashMap<>();
		this.flightScheduleMap = new HashMap<>();
		this.flightSeatMap = new HashMap<>();
		this.flightScheduleSeatMap = new HashMap<>();
	}
	
	public Airport createAirport(Airport airport) {
		airportMap.put(airport.getId(), airport);
		return airport;
	}
	
	public Airline createAirline(Airline airline) {
		airlineMap.put(airline.getId(), airline);
		return airline;
	}
	
	public Flight createFlight(Flight flight) {
		flightMap.put(flight.getId(), flight);
		return flight;
	}
	
	public FlightSchedule createFlightSchedule(FlightSchedule flightSchedule) {
		flightScheduleMap.put(flightSchedule.getId(), flightSchedule);
		return flightSchedule;
	}
	
	public FlightSeat createFlightSeat(FlightSeat flightSeat) {
		flightSeatMap.put(flightSeat.getId(), flightSeat);
		return flightSeat;
	}
	
	public FlightScheduleSeat createFlightScheduleSeat(FlightScheduleSeat flightScheduleSeat) {
		flightScheduleSeatMap.put(flightScheduleSeat.getId(), flightScheduleSeat);
		return flightScheduleSeat;
	}

	public Airline getAirline(String airlineId) {
		return airlineMap.get(airlineId);
	}
	
	public Airport getAirport(String airportId) {
		return airportMap.get(airportId);
	}

	public Flight getFlight(String flightId) {
		return flightMap.get(flightId);
	}

	public FlightSchedule getFlightSchedule(String flightScheduleId) {
		return flightScheduleMap.get(flightScheduleId);
	} 
	
	public FlightScheduleSeat getFlightScheduleSeat(String flightScheduleSeatId) {
		return flightScheduleSeatMap.get(flightScheduleSeatId);
	}

	public Airport updateAirport(Airport airport) {
		airportMap.put(airport.getId(), airport);
		return airport;	// return from map to ensure saved
	}

	public Airline updateAirline(Airline airline) {
		airlineMap.put(airline.getId(), airline);
		return airline;	// return from map to ensure saved
	}

	public Flight updateFlight(Flight flight) {
		flightMap.put(flight.getId(), flight);
		return flight;	// return from map to ensure saved
	}

	public FlightSchedule updateFlightSchedule(FlightSchedule flightSchedule) {
		flightScheduleMap.put(flightSchedule.getId(), flightSchedule);
		return flightSchedule;	// return from map to ensure saved
	}

}
