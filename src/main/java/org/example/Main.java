import Gym_system.Member;
import Gym_system.Trainers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Lists to store objects while the program runs
    private static ArrayList<Member> members = new ArrayList<>();
    private static ArrayList<Trainers> trainers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getValidInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    viewAllMembers();
                    break;
                case 3:
                    addTrainer();
                    break;
                case 4:
                    viewAllTrainers();
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println(); // Empty line for spacing
        }
    }

    // --- DISPLAY METHOD ---
    private static void printMenu() {
        System.out.println("=== GYM SYSTEM ===");
        System.out.println("1. Add Member");
        System.out.println("2. View All Members");
        System.out.println("3. Add Trainer");
        System.out.println("4. View All Trainers");
        System.out.println("0. Exit");
    }

    // --- MEMBER LOGIC ---
    private static void addMember() {
        System.out.println("\n--- Add New Member ---");

        int id = getValidInt("Enter Member ID: ");

        System.out.print("Enter Name: ");
        String name = scanner.next(); // Using next() for single word or nextLine() for full name

        int age = getValidInt("Enter Age: ");

        // Basic boolean validation
        System.out.print("Is Active? (true/false): ");
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid input. Type 'true' or 'false'.");
            scanner.next();
        }
        boolean active = scanner.nextBoolean();

        // Creating the object using the Constructor from Member.java
        Member newMember = new Member(id, name, age, active);
        members.add(newMember);
        System.out.println("Member added successfully!");
    }

    private static void viewAllMembers() {
        System.out.println("\n--- All Members ---");
        if (members.isEmpty()) {
            System.out.println("No members found.");
        } else {
            // Enhanced for-loop to display objects
            for (Member m : members) {
                System.out.println(m.toString());
            }
        }
    }

    // --- TRAINER LOGIC ---
    private static void addTrainer() {
        System.out.println("\n--- Add New Trainer ---");

        int id = getValidInt("Enter Trainer ID: ");

        System.out.print("Enter Name: ");
        String name = scanner.next();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.next();

        int experience = getValidInt("Enter Years of Experience: ");

        // Creating the object using the Constructor from Trainers.java
        Trainers newTrainer = new Trainers(id, name, specialization, experience);
        trainers.add(newTrainer);
        System.out.println("Trainer added successfully!");
    }

    private static void viewAllTrainers() {
        System.out.println("\n--- All Trainers ---");
        if (trainers.isEmpty()) {
            System.out.println("No trainers found.");
        } else {
            for (Trainers t : trainers) {
                System.out.println(t.toString());
            }
        }
    }

    // --- VALIDATION HELPER ---
    // This method prevents the app from crashing if user enters text instead of a number
    private static int getValidInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Error: Please enter a valid number.");
            System.out.print(prompt);
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }
}
