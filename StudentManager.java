// StudentManager.java
// All business logic lives here.
// Controls the ArrayList<Student> — add, search, update, delete operations.
// File operations are delegated to FileHandler (separation of concerns).

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students;
    private FileHandler fileHandler;

    public StudentManager() {
        this.students = new ArrayList<>();
        this.fileHandler = new FileHandler();
    }

    // Get the students list reference (used by Menu to iterate)
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    // Refuse duplicate IDs; add to list
    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(student.getId())) {
                System.out.println("Error: Student with ID '" + student.getId() + "' already exists.");
                return;
            }
        }
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Linear search by ID
    public Student searchById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null; // not found
    }

    // Update one field of a student record
    public void updateStudent(String id, String field, String newValue) {
        Student target = searchById(id);
        if (target == null) {
            System.out.println("Student not found.");
            return;
        }

        switch (field.toLowerCase()) {
            case "name":
                target.setName(newValue);
                break;
            case "email":
                target.setEmail(newValue);
                break;
            case "phone":
                target.setPhone(newValue);
                break;
            case "grade":
                target.setGrade(newValue);
                break;
            default:
                System.out.println("Invalid field: " + field + ". Valid fields: name, email, phone, grade");
                return;
        }
        System.out.println("Student updated.");
    }

    // Remove student by ID
    public void deleteStudent(String id) {
        Student target = searchById(id);
        if (target == null) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(target);
        System.out.println("Student deleted.");
    }

    // Delegate file loading to FileHandler
    public void loadFromFile(String filename) {
        ArrayList<Student> loaded = fileHandler.loadFromFile(filename);
        if (loaded != null) {
            this.students = loaded;
        }
        // If load failed, students stays as empty ArrayList
    }

    // Delegate file saving to FileHandler
    public void saveToFile(String filename) {
        fileHandler.saveToFile(students, filename);
    }
}