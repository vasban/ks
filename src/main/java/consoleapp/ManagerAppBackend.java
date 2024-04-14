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

}
