package vyshnav.io.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vyshnav.io.enums.SeatType;

@Getter
@Setter
@AllArgsConstructor
public class FlightSeat {
	private String id;
	private String seatNumber;
	private SeatType seatType;
}
