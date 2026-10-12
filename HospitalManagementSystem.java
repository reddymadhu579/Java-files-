import java.util.*;

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Patient> patients = new ArrayList<>();

    static class Patient {
        int id;
        String name;
        int age;
        String doctor;
        double bill;

        Patient(int id, String name, int age, String doctor, double bill) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.doctor = doctor;
            this.bill = bill;
        }

        void display() {
            System.out.println("\n--- Patient Record ---");
            System.out.println("Patient ID : " + id);
            System.out.println("Name       : " + name);
            System.out.println("Age        : " + age);
            System.out.println("Doctor     : " + doctor);
            System.out.println("Bill       : Rs." + bill);
        }
    }

    static void registerPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();

        System.out.print("Enter Bill Amount: ");
        double bill = sc.nextDouble();

        patients.add(new Patient(id, name, age, doctor, bill));

        System.out.println("Patient registered successfully!");
    }

    static void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        for (Patient p : patients)
            p.display();
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patient Records");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;

                case 2:
                    displayPatients();
                    break;

                case 3:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}