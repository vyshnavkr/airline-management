package vyshnav.io.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import vyshnav.io.enums.SeatStatus;
import vyshnav.io.models.Customer;
import vyshnav.io.models.FlightSchedule;
import vyshnav.io.models.FlightScheduleSeat;
import vyshnav.io.models.Ticket;
import vyshnav.io.repositories.TicketRepository;

@AllArgsConstructor
public class TicketService {
	
	private final TicketRepository ticketRepository;
	private final CustomerService customerService;
	private final FlightService flightService;
	
	public Ticket createTicket(@NonNull String bookedByCustomerId, @NonNull String flightScheduleId, @NonNull Map<String, String> customerIdSeatIdMap) {
		String ticketId = UUID.randomUUID().toString();
		// Before creating ticket: Get customer, flightSchedule, and populate customerSeatMap
		Customer originalCustomer = customerService.getCustomer(bookedByCustomerId);
		FlightSchedule originalFlightSchedule = flightService.getFlightSchedule(flightScheduleId);
		Map<Customer, FlightScheduleSeat> customerSeatMap = new HashMap<>();
		for (String customerId : customerIdSeatIdMap.keySet()) {
			Customer currentCustomer = customerService.getCustomer(customerId);
			String flightScheduleSeatId = customerIdSeatIdMap.get(customerId);
			FlightScheduleSeat currentFlightScheduleSeat = flightService.getFlightScheduleSeat(flightScheduleSeatId);
			customerSeatMap.put(currentCustomer, currentFlightScheduleSeat);
		}
		
		Ticket ticket = new Ticket(ticketId, originalCustomer, originalFlightSchedule, customerSeatMap);
		
		// Bidirectional mapping: add ticket in customer's tickets
		originalCustomer.getTicketSet().add(ticket);
		
		// Bidirectional mapping: update seat status to booked in flightScheduleSeat
		customerSeatMap.values().forEach(flightScheduleSeat -> flightScheduleSeat.setStatus(SeatStatus.BOOKED));
	
		return ticketRepository.createTicket(ticket);
	}
	
	public Ticket getTicket(@NonNull String ticketId) {
		return ticketRepository.getTicket(ticketId);
	}

}
