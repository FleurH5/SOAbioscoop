import java.time.LocalDateTime;

public class MovieScreening {

    private LocalDateTime dateAndTime;
    private double pricePerSeat;

    public MovieScreening(Movie movie, LocalDateTime dateAndTime, double pricePerSeat) {
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public String toString() {
        return "Screening op " + dateAndTime + ". Prijs per stoel: €" + pricePerSeat;
    }

}
