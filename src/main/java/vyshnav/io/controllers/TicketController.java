package vyshnav.io.controllers;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import vyshnav.io.models.Customer;
import vyshnav.io.models.FlightSchedule;
import vyshnav.io.models.FlightScheduleSeat;
import vyshnav.io.models.Ticket;
import vyshnav.io.services.TicketService;

@AllArgsConstructor
public class TicketController {
	private final TicketService ticketService;
	
	public String createTicket(@NonNull String bookedByCustomerId, @NonNull String flightScheduleId, @NonNull Map<String, String> customerIdSeatIdMap) {
		return ticketService.createTicket(bookedByCustomerId, flightScheduleId, customerIdSeatIdMap).getId();
	}
	
	public Ticket getTicket(@NonNull String ticketId) {
		return ticketService.getTicket(ticketId);
	}
}
