package vyshnav.io.models;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airport {
	private String id;
	private String name;
	private Set<Flight> flightSet;
	
	public Airport(String id, String name) {
		this.id = id;
		this.name = name;
		this.flightSet = new HashSet<>();
	}
}
