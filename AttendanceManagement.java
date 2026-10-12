import java.util.Scanner;
import java.util.ArrayList;

class Student {
    int id;
    String name;
    int totalClasses;
    int attendedClasses;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        totalClasses = 0;
        attendedClasses = 0;
    }

    void markAttendance(boolean present) {
        totalClasses++;

        if (present) {
            attendedClasses++;
        }
    }

    double getPercentage() {
        if (totalClasses == 0) {
            return 0;
        }

        return (attendedClasses * 100.0) / totalClasses;
    }

    void displayReport() {
        System.out.println("\nStudent ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Total Classes: " + totalClasses);
        System.out.println("Attended Classes: " + attendedClasses);
        System.out.printf("Attendance: %.2f%%\n", getPercentage());

        if (getPercentage() < 75) {
            System.out.println("Warning: Low Attendance!");
        } else {
            System.out.println("Attendance Status: Satisfactory");
        }
    }
}

public class AttendanceManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Attendance Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Display Reports");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;

                    for (Student s : students) {
                        if (s.id == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Student ID already exists.");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    students.add(new Student(id, name));
                    System.out.println("Student Added Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int attendanceId = sc.nextInt();

                    Student found = null;

                    for (Student s : students) {
                        if (s.id == attendanceId) {
                            found = s;
                            break;
                        }
                    }

                    if (found != null) {
                        System.out.print("Present? (1 = Yes, 0 = No): ");
                        int status = sc.nextInt();

                        if (status == 1 || status == 0) {
                            found.markAttendance(status == 1);
                            System.out.println("Attendance Recorded.");
                        } else {
                            System.out.println("Invalid attendance status.");
                        }
                    } else {
                        System.out.println("Student Not Found.");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        for (Student s : students) {
                            s.displayReport();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting Attendance Management.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}