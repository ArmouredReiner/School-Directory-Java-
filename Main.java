// Main.java
// Application entry point.
// Wires together StudentManager, FileHandler, and Menu.
// Manages the application lifecycle: load data → run menu → save on exit.

public class Main {
    private static final String FILENAME = "students.json";

    public static void main(String[] args) {
        // 1. Create the manager (shares the same ArrayList and FileHandler)
        StudentManager manager = new StudentManager();

        // 2. Load existing students from file on startup
        manager.loadFromFile(FILENAME);

        // 3. Create menu with reference to manager, then start
        Menu menu = new Menu(manager);
        menu.start();

        // 4. Save all student data to file before exiting
        manager.saveToFile(FILENAME);
        System.out.println("Data saved. Goodbye!");
    }
}