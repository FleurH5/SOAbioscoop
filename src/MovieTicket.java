public class MovieTicket {
    private MovieScreening movieScreening;
    private int rowNr;
    private int seatNr;
    private boolean isPremium;

    public MovieTicket(MovieScreening movieScreening, boolean isPremiumReservation, int seatRow, int seatNr) {
        this.movieScreening = movieScreening;
        this.rowNr = seatRow;
        this.seatNr = seatNr;
        this.isPremium = isPremiumReservation;
    }

    public boolean isPremiumTicket() {
        return isPremium;
    }

    public MovieScreening getMovieScreening() {
        return movieScreening;
    }

    public double getPrice(boolean isStudentOrder) {
        double price = movieScreening.getPricePerSeat();

        if (isPremium) {
            price += isStudentOrder ? 2.0 : 3.0;
        }
        return price;
    }

    public String toString() {
        return "Rij: " + rowNr + ", stoel: " + seatNr;

    }
}
