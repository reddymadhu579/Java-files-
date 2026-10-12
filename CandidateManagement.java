import java.util.Scanner;
import java.util.ArrayList;

class Candidate {
    int id;
    String name;
    String skills;
    String interviewStatus;

    Candidate(int id, String name, String skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.interviewStatus = "Pending";
    }

    void updateStatus(String status) {
        interviewStatus = status;
        System.out.println("Interview status updated.");
    }

    void displayCandidate() {
        System.out.println("\nCandidate ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Skills: " + skills);
        System.out.println("Interview Status: " + interviewStatus);
    }

    boolean hasSkill(String skill) {
        String[] skillList = skills.split(",");

        for (String s : skillList) {
            if (s.trim().equalsIgnoreCase(skill.trim())) {
                return true;
            }
        }

        return false;
    }
}

public class CandidateManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Candidate> candidates = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Candidate Management System ---");
            System.out.println("1. Add Candidate");
            System.out.println("2. Search by Skill");
            System.out.println("3. Update Interview Status");
            System.out.println("4. Display Recruitment Report");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Candidate ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;

                    for (Candidate c : candidates) {
                        if (c.id == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Candidate ID already exists.");
                        break;
                    }

                    System.out.print("Enter Candidate Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Skills (comma-separated): ");
                    String skills = sc.nextLine();

                    candidates.add(new Candidate(id, name, skills));
                    System.out.println("Candidate Added Successfully.");
                    break;

                case 2:
                    System.out.print("Enter Skill to Search: ");
                    String skill = sc.nextLine();

                    boolean found = false;

                    for (Candidate c : candidates) {
                        if (c.hasSkill(skill)) {
                            c.displayCandidate();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No candidates found with that skill.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Candidate ID: ");
                    int candidateId = sc.nextInt();
                    sc.nextLine();

                    Candidate selected = null;

                    for (Candidate c : candidates) {
                        if (c.id == candidateId) {
                            selected = c;
                            break;
                        }
                    }

                    if (selected != null) {
                        System.out.println("1. Selected");
                        System.out.println("2. Rejected");
                        System.out.println("3. Interview Pending");
                        System.out.print("Choose Status: ");
                        int status = sc.nextInt();
                        sc.nextLine();

                        if (status == 1) {
                            selected.updateStatus("Selected");
                        } else if (status == 2) {
                            selected.updateStatus("Rejected");
                        } else if (status == 3) {
                            selected.updateStatus("Pending");
                        } else {
                            System.out.println("Invalid Status.");
                        }
                    } else {
                        System.out.println("Candidate Not Found.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Recruitment Report ---");

                    if (candidates.isEmpty()) {
                        System.out.println("No candidate records available.");
                    } else {
                        for (Candidate c : candidates) {
                            c.displayCandidate();
                        }

                        System.out.println("\nTotal Candidates: " + candidates.size());
                    }
                    break;

                case 5:
                    System.out.println("Exiting Candidate Management System.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}