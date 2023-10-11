package vyshnav.io;

import java.util.HashMap;
import java.util.Map;

import vyshnav.io.constants.Constants;
import vyshnav.io.controllers.FlightController;
import vyshnav.io.enums.FlightScheduleStatus;
import vyshnav.io.enums.SeatStatus;
import vyshnav.io.enums.SeatType;
import vyshnav.io.models.Airline;
import vyshnav.io.models.Airport;
import vyshnav.io.models.Customer;
import vyshnav.io.models.Flight;
import vyshnav.io.models.FlightSchedule;
import vyshnav.io.models.FlightScheduleSeat;
import vyshnav.io.models.FlightSeat;
import vyshnav.io.models.Ticket;
import vyshnav.io.repositories.FlightRepository;
import vyshnav.io.services.FlightService;

public class Driver { 
	
	public static void main(String[] args) {
		
		FlightRepository flightRepository = new FlightRepository();
		FlightService flightService = new FlightService(flightRepository);
		FlightController flightController = new FlightController(flightService);
		
		// AIRLINE
		String airlineId = flightController.createAirline(Constants.AIRLINE_NAME);
		
		// FLIGHT
		String flightId = flightController.creatFlight(airlineId, Constants.FLIGHT_NUMBER);
		Flight flight = flightService.getFlight(flightId);
		flight.setDuration(Constants.DURATION);
		
		String departureAirportId = flightController.createAirport(Constants.AIRPORT_NAME_DEPARTURE);
		Airport departureAirport = flightController.getAirport(departureAirportId);
		String arrivalAirportId = flightController.createAirport(Constants.AIRPORT_NAME_ARRIVAL);
		Airport arrivalAirport = flightController.getAirport(arrivalAirportId);
		flight.setArrivalAirport(arrivalAirport);
		flight.setDepartureAirport(departureAirport);
		flightController.updateFlight(flightId, flight);
		
		// What is the use of flightSeat1 and flightSeat2?
//		FlightSeat flightSeat1 = new FlightSeat(Constants.SEAT_NUMBER_1, SeatType.ECONOMY);
//		FlightSeat flightSeat2 = new FlightSeat(Constants.SEAT_NUMBER_2, SeatType.BUSINESS_CLASS);
//		flight.getSeatList().add(flightSeat1);
//		flight.getSeatList().add(flightSeat2);
		
		// FLIGHT SCHEDULE
		String flightScheduleId = flightController.createFlightSchedule(flightId);
		FlightSchedule flightSchedule = flightController.getFlightSchedule(flightScheduleId);
		flightSchedule.setDepartureTime(Constants.DEPARTURE_TIME);
		flightSchedule.setGate(Constants.GATE_NUMBER);
		flightSchedule.setFlightScheduleStatus(FlightScheduleStatus.ON_TIME);
		
		String flightScheduleSeatId1 = flightController.creatFlightScheduleSeat(Constants.SEAT_NUMBER_1, SeatType.ECONOMY);
		FlightScheduleSeat flightScheduleSeat1 = flightController.getFlightScheduleSeat(flightScheduleSeatId1);
		flightScheduleSeat1.setFare(Constants.FARE);
		flightScheduleSeat1.setStatus(SeatStatus.AVAILABLE);
		
		String flightScheduleSeatId2 = flightController.creatFlightScheduleSeat(Constants.SEAT_NUMBER_2, SeatType.BUSINESS_CLASS);
		FlightScheduleSeat flightScheduleSeat2 = flightController.getFlightScheduleSeat(flightScheduleSeatId2);
		flightScheduleSeat2.setFare(Constants.FARE);
		flightScheduleSeat2.setStatus(SeatStatus.AVAILABLE);
		
		flightSchedule.getFlightScheduleSeatList().add(flightScheduleSeat1);
		flightSchedule.getFlightScheduleSeatList().add(flightScheduleSeat2);
		flightController.updateFlightSchedule(flightScheduleId, flightSchedule);
		
		// CUSTOMER
		Customer customer1 = new Customer(Constants.CUSTOMER_NAME_1);
		Customer customer2 = new Customer(Constants.CUSTOMER_NAME_2);
		
		// TICKET
		Map<Customer, FlightScheduleSeat> customerSeatMap = new HashMap<>();
		customerSeatMap.put(customer1, flightScheduleSeat1);	// Do reverse mapping also
		customerSeatMap.put(customer2, flightScheduleSeat2);
		Ticket ticket = new Ticket(customer1, flightSchedule, customerSeatMap);
		
		// Cancel ticket
		
		
		
	}

}
