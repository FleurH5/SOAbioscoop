import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {

        MovieScreening screening = new MovieScreening(null, LocalDateTime.now(), 13);

        MovieTicket t1 = new MovieTicket(screening, false, 1, 1);
        MovieTicket t2 = new MovieTicket(screening, true, 1, 2);

        Order order = new Order(1, true);
        order.addSeatReservation(t1);
        order.addSeatReservation(t2);

        order.export(TicketExportFormat.PLAINTEXT);

    }
}
