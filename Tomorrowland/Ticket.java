package Tomorrowland;
import java.util.Random;

public class Ticket {
    private int ticketNumber;

    public Ticket() {
        generarTicket();
    }

    private void generarTicket() {
        Random random = new Random();
        ticketNumber = random.nextInt(33000) + 1;
    }

    public boolean esTicketApto() {
        Random random = new Random();
        int numeroA = random.nextInt(15000) + 1;
        int numeroB = random.nextInt(15000) + 1;

        return (ticketNumber + numeroA + numeroB) % 2 == 0;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}
