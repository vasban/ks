import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.*;

public class ManagerAppBackend {
    public static void addAccommodation(String jsonPath) {
        System.out.println(String.format("DEBUG: Added accommodation from %s.", jsonPath));
    }

    public static void addAvailableDate(String date) {
        System.out.println(String.format("DEBUG: Added available date for %s.", date.toString()));
    }

    public static void addAvailableDates(String startDate, String endDate) {
        System.out.println(
                String.format("DEBUG: Added available dates for %s - %s.", startDate.toString(), endDate.toString()));
    }

    public static void addAvailableDates(String dates) {
        System.out.println(String.format("DEBUG: Added available dates for %s.", dates.toString()));
    }

    public static void getReservations() {
        System.out.println("DEBUG: Reservations here.");
    }

    public static void main(String []args){
        Socket masterSocket = null;
        ObjectOutputStream output = null;
        ObjectInputStream input = null;

        try{
            masterSocket = new Socket("localhost",5001);
            output = new ObjectOutputStream(masterSocket.getOutputStream());
            input = new ObjectInputStream(masterSocket.getInputStream());
            System.out.println("Hello from manager");
            Accommodation acc = new Accommodation("prwto",1,"prwto",1,1);
            Message message = new Message(1, 0, acc);
            output.writeObject(message);
            output.flush();
            System.out.println("I send a message");
        }catch(IOException io){
            io.printStackTrace();
        }finally{
            try{
                masterSocket.close();
                output.close();
                input.close();
            }catch(IOException io){
                io.printStackTrace();
            }
        }

    }

}
