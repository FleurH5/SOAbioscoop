import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;
    private List<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
        this.tickets = new ArrayList<>();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public double calculatePrice() {
        // standaardticket gooi ik op 13 euro.

        // conditions: studenten
        // 1) student heeft hele week 2e kaartje gratis
        // 2) premium stoel = +2
        // 1 studententicket = alles is student in die order.

        // conditions rest:
        // de rest heeft ma-do 2e kaartje gratis
        // vr-zo is vanaf 6 kaartjes 10% korting
        // premium stoel = +3
        double total = 0;

        // basisprijs iedereen
        for (MovieTicket ticket : tickets) {
            total += ticket.getPrice(isStudentOrder);
        }

        // studentenkorting 2e gratis
        if (isStudentOrder) {
            int freeTickets = tickets.size() / 2;

            for (int i = 0; i < freeTickets; i++) {
                total -= tickets.get(i).getPrice(true);
            }
        }

        // rest vd mesnen
        if (!tickets.isEmpty()) {
            var day = tickets.get(0).getMovieScreening().getDateAndTime().getDayOfWeek();

            boolean weekend = (day.getValue() >= 5);

            if (!weekend) {
                int freeTickets = tickets.size() / 2;

                for (int i = 0; i < freeTickets; i++) {
                    total -= tickets.get(i).getPrice(false);
                }
            } else {
                if (tickets.size() >= 6) {
                    total *= 0.9;
                }
            }
        }

        return total;
    }

    public void export(TicketExportFormat exportFormat) {
        switch (exportFormat) {
            case PLAINTEXT:
                System.out.println("Ordernr: " + orderNr);
                for (MovieTicket ticket : tickets) {
                    System.out.println(ticket);
                }

                System.out.println("Totaal: " + calculatePrice());
                break;

            // json raar
            case JSON:
                System.out.println("{}");
                System.out.println("  \"orderNr\": " + orderNr + ",");
                System.out.println("  \"tickets\": [");

                for (int i = 0; i < tickets.size(); i++) {
                    System.out.print("    \"" + tickets.get(i) + "\"");
                    if (i < tickets.size() - 1)
                        System.out.print(",");
                    System.out.println();
                }

                System.out.println("  ],");
                System.out.println("  \"total\": " + calculatePrice());
                System.out.println("}");
                break;
        }
    }
}
