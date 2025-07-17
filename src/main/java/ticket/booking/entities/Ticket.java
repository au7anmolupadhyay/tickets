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

    public Ticket(String ticketId, Train train, Date dateOfTravel, String destination, String source, String userId) {
        this.ticketId = ticketId;
        this.train = train;
        this.dateOfTravel = dateOfTravel;
        this.destination = destination;
        this.source = source;
        this.userId = userId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTicketInfo(){
        return String.format("Ticket ID: %s belongs to User %s from %s to %s on %s", ticketId, userId, source, destination, dateOfTravel);
    }

}
