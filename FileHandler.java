// FileHandler.java
// Handles all file I/O — isolates JSON serialization from business logic.
// If you later switch from JSON to CSV or binary, you only change this class.
// Uses Gson for JSON serialization/deserialization.

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler {
    private Gson gson;

    public FileHandler() {
        // Pretty-print: JSON is readable when you open students.json in a text editor
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // Save ArrayList<Student> to JSON file
    public void saveToFile(ArrayList<Student> students, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(students, writer);
            System.out.println("Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // Load JSON file into ArrayList<Student>
    public ArrayList<Student> loadFromFile(String filename) {
        // Check if file exists first
        if (!Files.exists(Paths.get(filename))) {
            System.out.println("No existing data file found — starting fresh.");
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(filename)) {
            // TypeToken tells Gson what type to deserialize INTO
            Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
            ArrayList<Student> loaded = gson.fromJson(reader, listType);
            return loaded != null ? loaded : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
            System.out.println("Starting with empty list.");
            return new ArrayList<>();
        } catch (Exception e) {
            // Corrupt JSON, unexpected format, etc.
            System.out.println("Error reading data: " + e.getMessage());
            System.out.println("Starting with empty list.");
            return new ArrayList<>();
        }
    }
}