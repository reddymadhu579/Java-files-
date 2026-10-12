import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class TravelPackage {
    int packageId;
    String destination;
    double price;
    int availableSeats;

    TravelPackage(int packageId, String destination, double price,
                  int availableSeats) {
        this.packageId = packageId;
        this.destination = destination;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    void displayPackage() {
        System.out.println(packageId + ". " + destination
                + " | Price: Rs. " + price
                + " | Available Seats: " + availableSeats);
    }
}

class Booking {
    String customerName;
    TravelPackage travelPackage;
    LocalDate travelDate;
    boolean paid;

    Booking(String customerName, TravelPackage travelPackage,
            LocalDate travelDate) {
        this.customerName = customerName;
        this.travelPackage = travelPackage;
        this.travelDate = travelDate;
        this.paid = false;
    }

    void makePayment() {
        paid = true;
        System.out.println("Payment completed successfully.");
    }

    void displayBooking() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("\nCustomer: " + customerName);
        System.out.println("Destination: " + travelPackage.destination);
        System.out.println("Travel Date: " + travelDate.format(format));
        System.out.println("Amount: Rs. " + travelPackage.price);
        System.out.println("Payment: " + (paid ? "Paid" : "Pending"));
    }
}

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<TravelPackage> packages = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        packages.add(new TravelPackage(1, "Goa", 5000, 10));
        packages.add(new TravelPackage(2, "Hyderabad", 3000, 10));
        packages.add(new TravelPackage(3, "Kerala", 7000, 10));

        int choice;

        do {
            System.out.println("\n--- Travel Booking System ---");
            System.out.println("1. View Packages");
            System.out.println("2. Book Package");
            System.out.println("3. Make Payment");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (TravelPackage p : packages) {
                        p.displayPackage();
                    }
                    break;

                case 2:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    for (TravelPackage p : packages) {
                        p.displayPackage();
                    }

                    System.out.print("Enter Package ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    TravelPackage selected = null;

                    for (TravelPackage p : packages) {
                        if (p.packageId == id) {
                            selected = p;
                            break;
                        }
                    }

                    if (selected == null) {
                        System.out.println("Invalid Package ID.");
                        break;
                    }

                    if (selected.availableSeats <= 0) {
                        System.out.println("No seats available.");
                        break;
                    }

                    System.out.print("Enter Travel Date (yyyy-MM-dd): ");
                    LocalDate date;

                    try {
                        date = LocalDate.parse(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid date format.");
                        break;
                    }

                    if (!date.isAfter(LocalDate.now())) {
                        System.out.println("Travel date must be in the future.");
                        break;
                    }

                    bookings.add(new Booking(name, selected, date));
                    selected.availableSeats--;

                    System.out.println("Booking Successful.");
                    break;

                case 3:
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings available.");
                        break;
                    }

                    for (int i = 0; i < bookings.size(); i++) {
                        System.out.println((i + 1) + ". "
                                + bookings.get(i).customerName
                                + " - " + bookings.get(i).travelPackage.destination
                                + " - "
                                + (bookings.get(i).paid ? "Paid" : "Pending"));
                    }

                    System.out.print("Enter Booking Number: ");
                    int bookingNo = sc.nextInt();

                    if (bookingNo >= 1 && bookingNo <= bookings.size()) {
                        bookings.get(bookingNo - 1).makePayment();
                    } else {
                        System.out.println("Invalid Booking Number.");
                    }
                    break;

                case 4:
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings available.");
                    } else {
                        for (Booking b : bookings) {
                            b.displayBooking();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Travel Booking System.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}