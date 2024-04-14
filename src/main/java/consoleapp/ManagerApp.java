import java.util.Scanner;

public class ManagerApp {

    private static void mainMenu() {
        int selection = 0;
        Boolean isLoop = true;
        while (isLoop) {
            isLoop = false;

            System.out.println("Choose from the following options");
            System.out.println("-------------------------\n");
            System.out.println("1 - Register new accommodation");
            System.out.println("2 - Register available dates");
            System.out.println("3 - View registered reservations for your accommodations");
            System.out.println("4 - Quit");

            Scanner input = new Scanner(System.in);
            selection = input.nextInt();
            input.close();
            switch (selection) {
                case 1:
                    addAccomodation();
                    break;
                case 2:
                    addAvailableDates();
                    break;
                case 3:
                    getReservations();
                    break;
                case 4:
                    System.out.println("Closing application.");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    isLoop = true;
                    break;
            }
        }
    }

    private static void addAccomodation() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert path to json file:\n");
        String jsonPath = input.next();
        input.close();
        ManagerAppBackend.addAccommodation(jsonPath);
        mainMenu();
    }

    private static void addAvailableDates() {
        Scanner input = new Scanner(System.in);
        int selection;
        Boolean isLoop = true;
        while (isLoop) {
            isLoop = false;

            System.out.println("Choose from the following options");
            System.out.println("-------------------------\n");
            System.out.println("1 - Enter a single date");
            System.out.println("2 - Enter a range of dates");
            System.out.println("3 - Enter dates seperated by commas(\",\")");
            System.out.println("4 - Return");
            selection = input.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Insert date (DD-MM-YYYY):\n");
                    String date = input.nextLine();
                    input.close();
                    ManagerAppBackend.addAvailableDate(date);
                    break;
                case 2:
                    String startDate, endDate;
                    System.out.println("Insert start date (DD-MM-YYYY):\n");
                    startDate = input.nextLine();
                    System.out.println("Insert end date (DD-MM-YYYY):\n");
                    endDate = input.nextLine();
                    input.close();
                    ManagerAppBackend.addAvailableDates(startDate, endDate);
                    break;
                case 3:
                    System.out.println("Insert dates (DD-MM-YYYY) seperated by commas (\",\"):\n");
                    String dates = input.nextLine();
                    input.close();
                    ManagerAppBackend.addAvailableDate(dates);
                    break;
                case 4:
                    System.out.println("Go back.");
                    input.close();
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    isLoop = true;
            }
        }
    }

    private static void getReservations() {
        ManagerAppBackend.getReservations();
        System.out.println();
        mainMenu();
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
