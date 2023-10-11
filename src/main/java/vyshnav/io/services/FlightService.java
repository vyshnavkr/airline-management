package vyshnav.io.services;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import vyshnav.io.enums.SeatType;
import vyshnav.io.models.Airline;
import vyshnav.io.models.Airport;
import vyshnav.io.models.Flight;
import vyshnav.io.models.FlightSchedule;
import vyshnav.io.models.FlightScheduleSeat;
import vyshnav.io.models.FlightSeat;
import vyshnav.io.repositories.FlightRepository;

@AllArgsConstructor
public class FlightService {
	private final FlightRepository flightRepository;
	
	public Airline createAirline(@NonNull String airlineName) {
		String id = UUID.randomUUID().toString();
		Airline airline = new Airline(id, airlineName);
		return flightRepository.createAirline(airline);
	}	
	
	public Airport createAirport(@NonNull String airportName) {
		String id = UUID.randomUUID().toString();
		Airport airport = new Airport(id, airportName);
		return flightRepository.createAirport(airport);
	}
	
	public Flight createFlight(@NonNull String airlineId, @NonNull String flightNumber) {
		String id = UUID.randomUUID().toString();
		Airline airline = getAirline(airlineId);
		updateAirline(airlineId, airline);
		Flight flight = new Flight(id, airline, flightNumber);
		return flightRepository.createFlight(flight);
	}

	public FlightSchedule createFlightSchedule(@NonNull String flightId) {
		String id = UUID.randomUUID().toString();
		Flight flight = getFlight(flightId);
		FlightSchedule flightSchedule = new FlightSchedule(id, flight);
		return flightRepository.createFlightSchedule(flightSchedule);
	}
	
	public FlightSeat createFlightSeat(@NonNull String seatNumber, @NonNull SeatType seatType) {
		String id = UUID.randomUUID().toString();
		FlightSeat flightSeat = new FlightSeat(id, seatNumber, seatType);
		return flightRepository.createFlightSeat(flightSeat);
	}
	
	public FlightScheduleSeat createFlightScheduleSeat(@NonNull String seatNumber, @NonNull SeatType seatType) {
		String id = UUID.randomUUID().toString();
		FlightScheduleSeat flightScheduleSeat = new FlightScheduleSeat(id, seatNumber, seatType);
		return flightRepository.createFlightScheduleSeat(flightScheduleSeat);
	}
	
	public Airline getAirline(@NonNull String id) {
		return flightRepository.getAirline(id);
	}
	
	public Airport getAirport(@NonNull String airportId) {
		return flightRepository.getAirport(airportId);
	}

	public Flight getFlight(@NonNull String flightId) {
		return flightRepository.getFlight(flightId);
	}

	public FlightSchedule getFlightSchedule(@NonNull String flightScheduleId) {
		return flightRepository.getFlightSchedule(flightScheduleId);
	} 
	
	public FlightScheduleSeat getFlightScheduleSeat(@NonNull String flightScheduleSeatId) {
		return flightRepository.getFlightScheduleSeat(flightScheduleSeatId);
	}
	
	public Airport updateAirpot(String airportId, Airport airport) {
		Airport originalAirport = getAirport(airportId);
		airport.getFlightSet().forEach(flight -> originalAirport.getFlightSet().add(flight));
		return flightRepository.updateAirport(originalAirport);
	}
	
	private Airline updateAirline(String airlineId, Airline airline) {
		Airline originalAirline = getAirline(airlineId);
		airline.getFlightSet().forEach(flight -> originalAirline.getFlightSet().add(flight));
		return flightRepository.updateAirline(originalAirline);
	}

	public Flight updateFlight(String flightId, Flight flight) {
		Flight originalFlight = getFlight(flightId);
		originalFlight.setDuration(flight.getDuration());
		originalFlight.setDepartureAirport(flight.getDepartureAirport());
		updateAirpot(flight.getDepartureAirport().getId(), flight.getDepartureAirport());	// bidirectional mapping
		originalFlight.setArrivalAirport(flight.getArrivalAirport());
		updateAirpot(flight.getArrivalAirport().getId(), flight.getArrivalAirport());	// bidirectional mapping
		return flightRepository.updateFlight(originalFlight);
	}

	public FlightSchedule updateFlightSchedule(String flightScheduleId, FlightSchedule flightSchedule) {
		FlightSchedule originalFlightSchedule = getFlightSchedule(flightScheduleId);
		originalFlightSchedule.setDepartureTime(flightSchedule.getDepartureTime());
		originalFlightSchedule.setGate(flightSchedule.getGate());
		originalFlightSchedule.setFlightScheduleStatus(flightSchedule.getFlightScheduleStatus());
		flightSchedule.getFlightScheduleSeatList().forEach(seat -> originalFlightSchedule.getFlightScheduleSeatList().add(seat));
		return flightRepository.updateFlightSchedule(originalFlightSchedule);
	}
}
