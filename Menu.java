// Menu.java
// Handles all console input/output — completely separate from business logic.
// Isolates Scanner and System.out from business logic (ArrayList operations).

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private StudentManager manager;
    private Scanner scanner;

    public Menu(StudentManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    // ──────────────────────────────────────────
    // Main Menu Loop
    // ──────────────────────────────────────────

    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:  addStudent();       break;
                case 2:  viewAllStudents();  break;
                case 3:  searchStudent();    break;
                case 4:  updateStudent();   break;
                case 5:  deleteStudent();    break;
                case 6:  running = false;    break;
                default: System.out.println("Invalid option. Enter 1-6.");
            }
        }
    }

    // ──────────────────────────────────────────
    // Menu Display
    // ──────────────────────────────────────────

    private void displayMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search by ID");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Save & Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.next(); // clear bad input
        }
        return scanner.nextInt();
    }

    // ──────────────────────────────────────────
    // Operation Handlers
    // ──────────────────────────────────────────

    private void addStudent() {
        System.out.print("Enter ID: ");
        String id = scanner.next().trim();
        System.out.print("Enter Name: ");
        scanner.nextLine(); // consume leftover newline
        String name = scanner.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = scanner.next().trim();
        System.out.print("Enter Phone: ");
        String phone = scanner.next().trim();
        System.out.print("Enter Grade (e.g., Freshman): ");
        String grade = scanner.next().trim();

        Student student = new Student(id, name, email, phone, grade);
        manager.addStudent(student);
    }

    private void viewAllStudents() {
        ArrayList<Student> all = manager.getAllStudents();
        if (all.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("\n--- All Students ---");
        for (Student s : all) {
            System.out.println(s);
        }
    }

    private void searchStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.next().trim();
        Student found = manager.searchById(id);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.next().trim();
        System.out.print("Which field to update? (name, email, phone, grade): ");
        String field = scanner.next().trim();
        System.out.print("Enter new value: ");
        scanner.nextLine(); // consume leftover newline
        String newValue = scanner.nextLine().trim();

        manager.updateStudent(id, field, newValue);
    }

    private void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.next().trim();
        System.out.print("Confirm deletion? (yes/no): ");
        String confirm = scanner.next().trim();
        if (confirm.equalsIgnoreCase("yes")) {
            manager.deleteStudent(id);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
}