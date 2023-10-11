package vyshnav.io.models;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
	private String id;
	private String name;
	private Set<Ticket> ticketSet;
	
	public Customer(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
