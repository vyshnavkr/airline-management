package vyshnav.io;

import java.util.HashMap;
import java.util.Map;

import vyshnav.io.constants.Constants;
import vyshnav.io.controllers.CustomerController;
import vyshnav.io.controllers.FlightController;
import vyshnav.io.controllers.TicketController;
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
import vyshnav.io.repositories.CustomerRepository;
import vyshnav.io.repositories.FlightRepository;
import vyshnav.io.repositories.TicketRepository;
import vyshnav.io.services.CustomerService;
import vyshnav.io.services.FlightService;
import vyshnav.io.services.TicketService;

public class Driver { 
	
	public static void main(String[] args) {
		
		// FLIGHT MANAGEMENT: AIRLINE, FLIGHT, FLIGHTSCHEDULE
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

		// CUSTOMER MANAGEMENT: CUSTOMER
		CustomerRepository customerRepository = new CustomerRepository();
		CustomerService customerService = new CustomerService(customerRepository);
		CustomerController customerController = new CustomerController(customerService);
		
		// CUSTOMER
		String customerId1 = customerController.createCustomer(Constants.CUSTOMER_NAME_1);
		Customer customer1 = customerController.getCustomer(customerId1);
		String customerId2 = customerController.createCustomer(Constants.CUSTOMER_NAME_2);
		Customer customer2 = customerController.getCustomer(customerId2);
		
		// TICKET MANAGEMENT: TICKET
		TicketRepository ticketRepository = new TicketRepository();
		TicketService ticketService = new TicketService(ticketRepository, customerService, flightService);
		TicketController ticketController = new TicketController(ticketService);
		
		// TICKET
		Map<String, String> customerIdSeatIdMap = new HashMap<>();
		customerIdSeatIdMap.put(customerId1, flightScheduleSeatId1);	//todo: Only book available seats
		customerIdSeatIdMap.put(customerId2, flightScheduleSeatId2);	//todo: Only book available seats
		String ticketId = ticketController.createTicket(customerId1, flightScheduleId, customerIdSeatIdMap);
		Ticket ticket = ticketController.getTicket(ticketId);
		
		// Cancel ticket
		
		// Search features: search flight given source and destination, search 
		
		
		
	}

}
