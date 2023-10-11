package vyshnav.io.repositories;

import java.util.HashMap;
import java.util.Map;

import vyshnav.io.models.Ticket;

public class TicketRepository {
	
	private final Map<String, Ticket> ticketMap;
	
	public TicketRepository() {
		this.ticketMap = new HashMap<>();
	}
	
	public Ticket createTicket(Ticket ticket) {
		ticketMap.put(ticket.getId(), ticket);
		return ticketMap.get(ticket.getId());
	}
	
	public Ticket getTicket(String ticketId) {
		return ticketMap.get(ticketId);
	}

}
