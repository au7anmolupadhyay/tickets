package ticket.booking.entities;

import java.util.List;

public class User {
    private String name;
    private String password;
    private String hashed_password;
    private List<Ticket> tickets_booked;
    private String user_id;

    public User(){}

    public User(String name, String password, String hashed_password, String user_id, List<Ticket> tickets_booked){
        this.name = name;
        this.password = password;
        this.hashed_password = hashed_password;
        this.user_id = user_id;
        this.tickets_booked = tickets_booked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashed_password() {
        return hashed_password;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public List<Ticket> getTickets_booked() {
        return tickets_booked;
    }

    public void setTickets_booked(List<Ticket> tickets_booked) {
        this.tickets_booked = tickets_booked;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void printTickets(){
        if(tickets_booked.isEmpty()){
            System.out.println("No tickets booked...");
        }
        else {
            for(int i = 0; i< tickets_booked.size(); i++){
                System.out.println(tickets_booked.get(i).getTicketInfo());
            }
        }
    }
}
