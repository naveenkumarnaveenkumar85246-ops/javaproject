```java
import java.util.ArrayList;
import java.util.Scanner;

class Participant {
    int id;
    String name;
    String email;
    String program;
    boolean attended;

    Participant(int id, String name, String email, String program) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.program = program;
        this.attended = false;
    }

    void display() {
        System.out.println("-----------------------------------");
        System.out.println("Participant ID : " + id);
        System.out.println("Name           : " + name);
        System.out.println("Email          : " + email);
        System.out.println("Training       : " + program);
        System.out.println("Attendance     : "
                + (attended ? "Present" : "Not Marked"));
    }
}

public class TrainingProgramSystem {

    static ArrayList<Participant> participants = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1001;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== TRAINING PROGRAM REGISTRATION =====");
            System.out.println("1. Register Participant");
            System.out.println("2. View All Participants");
            System.out.println("3. Search Participant by ID");
            System.out.println("4. Mark Attendance");
            System.out.println("5. Show Participant Count");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerParticipant();
                    break;

                case 2:
                    viewParticipants();
                    break;

                case 3:
                    searchParticipant();
                    break;

                case 4:
                    markAttendance();
                    break;

                case 5:
                    System.out.println(
                        "Total Participants: " + participants.size()
                    );
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    static void registerParticipant() {

        System.out.println("\n--- Participant Registration ---");

        System.out.print("Enter participant name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter email address: ");
        String email = sc.nextLine().trim();

        System.out.print("Enter training program name: ");
        String program = sc.nextLine().trim();

        if (name.isEmpty() || email.isEmpty() || program.isEmpty()) {
            System.out.println("All fields are required!");
            return;
        }

        Participant p = new Participant(
            nextId++, name, email, program
        );

        participants.add(p);

        System.out.println("Registration successful!");
        System.out.println("Participant ID: " + p.id);
    }

    static void viewParticipants() {

        if (participants.isEmpty()) {
            System.out.println("No participants registered yet.");
            return;
        }

        System.out.println("\n--- Registered Participants ---");

        for (Participant p : participants) {
            p.display();
        }
    }

    static void searchParticipant() {

        System.out.print("Enter participant ID to search: ");

        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid participant ID: ");
            sc.next();
        }

        int id = sc.nextInt();
        sc.nextLine();

        Participant p = findParticipant(id);

        if (p == null) {
            System.out.println("Participant not found!");
        } else {
            System.out.println("Participant found:");
            p.display();
        }
    }

    static void markAttendance() {

        System.out.print("Enter participant ID: ");

        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid participant ID: ");
            sc.next();
        }

        int id = sc.nextInt();
        sc.nextLine();

        Participant p = findParticipant(id);

        if (p == null) {
            System.out.println("Participant not found!");
        } else {
            p.attended = true;
            System.out.println(
                "Attendance marked as Present for " + p.name
            );
        }
    }

    static Participant findParticipant(int id) {

        for (Participant p : participants) {
            if (p.id == id) {
                return p;
            }
        }

        return null;
    }
}
```
