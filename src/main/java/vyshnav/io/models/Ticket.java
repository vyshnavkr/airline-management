package vyshnav.io.models;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import vyshnav.io.enums.TicketStatus;

@Getter
@Setter
public class Ticket {
	private String id;
	private String ticketNumber;
	private Customer bookedBy;
	private FlightSchedule flightSchedule;
	private Map<Customer, FlightScheduleSeat> customerSeatMap;
	private TicketStatus status;
	
	public Ticket(String id, Customer bookedBy, FlightSchedule flightSchedule, Map<Customer, FlightScheduleSeat> customerSeatMap) {
		this.id = id;
		this.ticketNumber = Math.random() + "";
		this.bookedBy = bookedBy;
		this.flightSchedule = flightSchedule;
		this.customerSeatMap = customerSeatMap;
		this.status = TicketStatus.BOOKED;
	}
	
}
