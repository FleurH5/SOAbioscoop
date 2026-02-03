import java.time.LocalDateTime;

public class MovieScreening {

    private LocalDateTime dateAndTime;
    private double pricePerSeat;

    public MovieScreening(Movie movie, LocalDateTime dateAndTime, double pricePerSeat) {
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
    }

    public double getPricePerSeat() {
        return 0;
    }

    public String toString() {
        return "";
    }

}
