package ticket.booking;

import ticket.booking.entities.User;
import ticket.booking.services.UserBookingService;
import ticket.booking.util.UserServiceUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class App
{

    // in java functions are first class citizen i.e. they can be passed as a function and can be used
    public static void main( String[] args )
    {
        System.out.println("running system!");
        boolean isUserLoggedIn = false;
        User loggedInUser = null;
        int option = 0;

        Scanner scanner = new Scanner(System.in);

        UserBookingService userBookingService;
        try{
            userBookingService = new UserBookingService();
        }catch(IOException ex){
            System.out.println("There is something wrong!");
            ex.printStackTrace();
            return;
        }

        while(option != 7){
            System.out.println("Choose an option");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Fetch Bookings");
            System.out.println("4. Search Trains");
            System.out.println("5. Book a seat");
            System.out.println("6. Cancel my booking");
            System.out.println("7. Exit the app");

            option = scanner.nextInt();

            switch(option){
                case 1:
                    System.out.println("Enter username to signup: ");
                    String nameToSignUp = scanner.next();
                    System.out.println("Enter password: ");
                    String passwordToSignUp = scanner.next();
                    User userToSignUp = new User(nameToSignUp, passwordToSignUp,
                            UserServiceUtil.hashPassword(passwordToSignUp), UUID.randomUUID().toString(),
                            new ArrayList<>());
                    userBookingService.signUp(userToSignUp);
                    break;

                case 2:
                    System.out.println("Enter your username: ");
                    String nameToLogin = scanner.next();
                    System.out.println("Enter your password: ");
                    String passwordToLogin = scanner.next();
                    isUserLoggedIn = userBookingService.loginUser(nameToLogin, passwordToLogin);
                    if(isUserLoggedIn){
                        loggedInUser = userBookingService.getUserInfoByUsername(nameToLogin);
                        break;
                    }else{
                        System.out.println("Wrong username or password");
                        break;
                    }

                case 3:
                    if(!isUserLoggedIn){
                        System.out.println("Kindly login to see your bookings!");
                        break;
                    }
                    else{
                        System.out.println("Fetching your bookings! .....");
                        userBookingService.fetchBooking(loggedInUser);
                        break;
                    }
            }
        }

    }
}
