import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;

public class Accommodation implements Serializable {
    private String roomName;
    private int nOfPersons;
    private String area;
    private int stars;
    private int nOfReviews;
    private Set<LocalDate> availableDates;

    public Accommodation(String roomName, int nOfPersons, String area, int stars, int nOfReviews) {
        this.roomName = roomName;
        this.nOfPersons = nOfPersons;
        this.area = area;
        this.stars = stars;
        this.nOfReviews = nOfReviews;
        this.availableDates = new HashSet<LocalDate>();
    }

    public Accommodation() {
        this.roomName = "";
        this.nOfPersons = 0;
        this.area = "";
        this.stars = 0;
        this.nOfReviews = 0;
        this.availableDates = new HashSet<LocalDate>();
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNOfPersons() {
        return this.nOfPersons;
    }

    public void setNOfPersons(int nOfPersons) {
        this.nOfPersons = nOfPersons;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getNOfReviews() {
        return this.nOfReviews;
    }

    public void setNOfReviews(int nOfReviews) {
        this.nOfReviews = nOfReviews;
    }

    public Set<LocalDate> getAvailableDates() {
        return this.availableDates;
    }

    public void setAvailableDates(Set<LocalDate> dates) {
        this.availableDates.addAll(dates);
    }

    public void setAvailableDates(LocalDate date) {
        this.availableDates.add(date);
    }

    public void setAvailableDates(LocalDate startDate, LocalDate endDate) {
        for (LocalDate date = startDate; date.isBefore(endDate); date.plusDays(1)) {
            this.availableDates.add(date);
        }
    }

    public void removeAvailableDates(Set<LocalDate> dates) {
        this.availableDates.removeAll(dates);
    }

    public void removeAvailableDates(LocalDate date) {
        this.availableDates.remove(date);
    }

    public void removeAvailableDates(LocalDate startDate, LocalDate endDate) {
        for (LocalDate date = startDate; date.isBefore(endDate); date.plusDays(1)) {
            this.availableDates.remove(date);
        }
    }

    @Override
    public String toString() {
        String sPersons = "People";
        if (nOfPersons == 1)
            sPersons = "Person";

        return String.format("%s\n%s | %d %s\n%d stars | %d reviews",
                this.roomName,
                this.area, this.nOfPersons, sPersons,
                this.stars, this.nOfReviews);
    }
}
