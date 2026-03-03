import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class test {

    private MovieScreening screening;

    @Before
    public void setUp() {
        screening = new MovieScreening(null, LocalDateTime.now(), 13);
    }

    @Test
    public void testCalculatePriceIfStudentOrder() {
        Order order = new Order(1, true);
        MovieTicket t1 = new MovieTicket(screening, false, 1, 1);
        MovieTicket t2 = new MovieTicket(screening, false, 1, 2);
        order.addSeatReservation(t1);
        order.addSeatReservation(t2);

        var ticketPrice = order.calculatePrice();

        assertEquals(13, ticketPrice, 0.0);
    }

    @Test
    public void testCalculatePriceIfStudentOrderWithPremiumSeats() {
        Order order = new Order(1, true);
        MovieTicket t1 = new MovieTicket(screening, false, 1, 1);
        MovieTicket t2 = new MovieTicket(screening, true, 1, 2);
        order.addSeatReservation(t1);
        order.addSeatReservation(t2);

        var ticketPrice = order.calculatePrice();

        assertEquals(15, ticketPrice, 0.0);
    }

    @Test
    public void testCalculatePriceIfNotStudentOrderOnWeekday() {
        Order order = new Order(1, false);
        MovieScreening screeningWeekday = new MovieScreening(null, LocalDateTime.of(2026, 3, 4, 20, 0), 13);
        MovieTicket t1 = new MovieTicket(screeningWeekday, false, 1, 1);
        MovieTicket t2 = new MovieTicket(screeningWeekday, false, 1, 2);
        order.addSeatReservation(t1);
        order.addSeatReservation(t2);
        
        var ticketPrice = order.calculatePrice();

        assertEquals(13, ticketPrice, 0.0);
    }

    @Test
    public void testcalculatePriceIfNotStudentOrderOnWeekend() {
        Order order = new Order(1, false);
        MovieScreening screeningWeekend = new MovieScreening(null, LocalDateTime.of(2026, 3, 7, 20, 0), 13);
        MovieTicket t1 = new MovieTicket(screeningWeekend, false, 1, 1);
        MovieTicket t2 = new MovieTicket(screeningWeekend, false, 1, 2);
        order.addSeatReservation(t1);
        order.addSeatReservation(t2);

        
        var ticketPrice = order.calculatePrice();

        assertEquals(26, ticketPrice, 0.0);
    }

    @Test
    public void testcalculatePriceIfNotStudentOrderOnWeekendSixOrMoreTickets() {
        Order order = new Order(1, false);
        MovieScreening screeningWeekend = new MovieScreening(null, LocalDateTime.of(2026, 3, 7, 20, 0), 13);
        MovieTicket t1 = new MovieTicket(screeningWeekend, false, 1, 1);
        MovieTicket t2 = new MovieTicket(screeningWeekend, false, 1, 2);
        MovieTicket t3 = new MovieTicket(screeningWeekend, false, 1, 3);
        MovieTicket t4 = new MovieTicket(screeningWeekend, false, 1, 4);
        MovieTicket t5 = new MovieTicket(screeningWeekend, false, 1, 5);
        MovieTicket t6 = new MovieTicket(screeningWeekend, false, 1, 6);
        order.addSeatReservation(t1);
        order.addSeatReservation(t2);
        order.addSeatReservation(t3);
        order.addSeatReservation(t4);
        order.addSeatReservation(t5);
        order.addSeatReservation(t6);

        
        var ticketPrice = order.calculatePrice();

        assertEquals(70.2, ticketPrice, 0.0);
    }
}
