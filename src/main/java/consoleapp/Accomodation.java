public class Accomodation {
    private String roomName;
    private int nOfPersons;
    private String area;
    private int stars;
    private int nOfReviews;

    public Accomodation(String roomName, int nOfPersons, String area, int stars, int nOfReviews) {
        this.roomName = roomName;
        this.nOfPersons = nOfPersons;
        this.area = area;
        this.stars = stars;
        this.nOfReviews = nOfReviews;
    }

    public Accomodation() {
        this.roomName = "";
        this.nOfPersons = 0;
        this.area = "";
        this.stars = 0;
        this.nOfReviews = 0;
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

}
