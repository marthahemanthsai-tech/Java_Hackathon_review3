class TicketBooking {
    private String customerName;
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;

    
    private static final double DEFAULT_TICKET_PRICE = 200.0;

    
    public TicketBooking(String customerName, String movieName, double ticketPrice, int numberOfTickets) {
        this.customerName = sanitize(customerName);
        this.movieName = sanitize(movieName);
        this.ticketPrice = Math.max(0.0, ticketPrice);
        this.numberOfTickets = Math.max(0, numberOfTickets);
    }

    
    
    public TicketBooking(String customerName, String movieName, int numberOfTickets) {
        this(customerName, movieName, DEFAULT_TICKET_PRICE, numberOfTickets);
    }

    
    
    private String sanitize(String input) {
        if (input == null) return "";
        return input.trim().toUpperCase();
    }

    
    public String getCustomerName() {
        return customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    
    public void processBooking(String customerName, String movieName, double ticketPrice, int numberOfTickets) {
        this.customerName = sanitize(customerName);
        this.movieName = sanitize(movieName);
        this.ticketPrice = Math.max(0.0, ticketPrice);
        this.numberOfTickets = Math.max(0, numberOfTickets);
        displayBookingSummary();
    }

    
    public void processBooking() {
        displayBookingSummary();
    }

   
    public boolean verifyCustomer(String searchName) {
        if (searchName == null) return false;
        return this.customerName.equalsIgnoreCase(searchName.trim());
    }

   
    public void displayBookingSummary() {
        if (numberOfTickets <= 0) {
            System.out.println("Booking Failed: Invalid number of tickets.\n");
            return;
        }

        double totalAmount = ticketPrice * numberOfTickets;
        double discount = 0.0;

        
        if (numberOfTickets >= 5) {
            discount = totalAmount * 0.10;
        }

        double finalAmount = totalAmount - discount;

        System.out.printf("Customer Name   : %s%n", customerName);
        System.out.printf("Movie Name      : %s%n", movieName);
        System.out.printf("Ticket Price    : Rs. %.2f%n", ticketPrice);
        System.out.printf("Number of Tickets: %d%n", numberOfTickets);
        System.out.println("Booking Status  : Booking Successful");
        System.out.printf("Total Amount    : Rs. %.2f%n", totalAmount);
        System.out.printf("Discount        : Rs. %.2f%n", discount);
        System.out.printf("Final Amount    : Rs. %.2f%n%n", finalAmount);
    }

    
    
    public void displayBasicInfo() {
        System.out.printf("Customer Name   : %s%n", customerName);
        System.out.printf("Movie Name      : %s%n", movieName);
        System.out.printf("Number of Tickets: %d%n%n", numberOfTickets);
    }
}

public class CinemaBookingSystem {
    public static void main(String[] args) {
        System.out.println("========== CINEMA TICKET BOOKING ==========\n");

        
        TicketBooking booking1 = new TicketBooking("Sneha", "Avatar", 200.00, 5);
        booking1.processBooking();

       
        TicketBooking booking2 = new TicketBooking("Arjun", "Avatar", 2);
        booking2.displayBasicInfo();
    }
}