import java.util.Scanner;

class Student {
    Scanner sc = new Scanner(System.in);

    int rollNumber;
    String name;
    int attendance;
    double marks;

    void entry() {
        System.out.print("Enter Roll Number: ");
        rollNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        System.out.print("Enter Attendance Percentage: ");
        attendance = sc.nextInt();

        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();

        System.out.println("Student Record Added Successfully!");
    }

    void display() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Attendance: " + attendance + "%");
        System.out.println("Marks: " + marks);
    }

    void grade() {
        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else if (marks >= 40) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }

    void attendanceStatus() {
        if (attendance >= 75) {
            System.out.println("Attendance Status: Eligible");
        } else {
            System.out.println("Attendance Status: Shortage");
        }
    }

    void reportCard() {
        display();
        grade();
        attendanceStatus();
    }
}

public class STUDENTRECORD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        int choice;

        do {
            System.out.println("\n--- UNIVERSITY STUDENT RECORD SYSTEM ---");
            System.out.println("1. Enter Student Details");
            System.out.println("2. Display Student Details");
            System.out.println("3. Generate Report Card");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    s.entry();
                    break;

                case 2:
                    s.display();
                    break;

                case 3:
                    s.reportCard();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}