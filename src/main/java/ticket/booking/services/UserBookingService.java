package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.IOException;
import java.util.List;
import java.io.File;
import java.util.Optional;

public class UserBookingService {
    private User user;

    private List<User> userList;

    // object to json -> SERIALIZE
    // JSON to Object -> DESERIALIZE
    private ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String USERS_PATH = "src/main/java/ticket/booking/localDB/users.json";
    //why static? -> persists in memory across function calls or throughout the program's lifetime

    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        File users = new File(USERS_PATH);
        userList = OBJECT_MAPPER.readValue(users, new TypeReference<List<User>>() {
        });
    }

    public Boolean loginUser() {
        // we use optional to make sure even if we face null , it does not throw NPE (null pointer exception)
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User user) {
        try {
            userList.add(user);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    public void saveUserListToFile() throws IOException {
        File usersFile = new File(USERS_PATH);
        //serialization -> Object to JSON
        OBJECT_MAPPER.writeValue(usersFile, userList);
    }

    public void fetchBooking() {
        user.printTickets();
    }

    public Boolean cancelBooking(Ticket ticketId) {
        return Boolean.FALSE;
    }
}
