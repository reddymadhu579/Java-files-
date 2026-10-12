import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;

class Birthday {
    String name;
    LocalDate dob;

    Birthday(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    void displayDetails() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = dob.withYear(today.getYear());

        if (nextBirthday.isBefore(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        Period age = Period.between(dob, today);
        long days = ChronoUnit.DAYS.between(today, nextBirthday);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("\nCurrent Date: " + today.format(format));
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob.format(format));
        System.out.println("Age: " + age.getYears());
        System.out.println("Born On: " + dob.getDayOfWeek());
        System.out.println("Days Until Next Birthday: " + days);

        if (dob.getMonthValue() == today.getMonthValue()
                && dob.getDayOfMonth() == today.getDayOfMonth()) {
            System.out.println("Happy Birthday, " + name + "!");
        }
    }
}

public class BirthdayReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());

        if (dob.isAfter(LocalDate.now())) {
            System.out.println("Date of birth cannot be in the future.");
        } else {
            Birthday b = new Birthday(name, dob);
            b.displayDetails();
        }

        sc.close();
    }
}