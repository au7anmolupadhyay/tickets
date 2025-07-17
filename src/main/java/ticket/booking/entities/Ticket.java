package ticket.booking.entities;

import java.sql.Date;
import java.sql.Time;

public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private Train train;
}
