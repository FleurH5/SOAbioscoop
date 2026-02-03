public class MovieTicket {
    private int rowNr;
    private int seatNr;
    private boolean isPremium;

    public MovieTicket(MovieScreening movieScreening, boolean isPremiumReservation, int seatRow, int seatNr) {
        this.rowNr = seatRow;
        this.seatNr = seatNr;
        this.isPremium = isPremiumReservation;
    }

    public boolean isPremiumTicket() {
        return false;
    }

    public double getPrice() {
        return 0;
    }

    public String toString() {
        return "";

    }
}
