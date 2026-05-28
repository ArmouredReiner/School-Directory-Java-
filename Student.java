// Student.java
// Plain data class — groups all student fields into one unit.
// Private fields + public getters/setters = encapsulation.
// No business logic here — pure data container.

public class Student {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String grade;

    // Constructor
    public Student(String id, String name, String email, String phone, String grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.grade = grade;
    }

    // Getters
    public String getId()  { return id; }
    public String getName()  { return name; }
    public String getEmail()  { return email; }
    public String getPhone()  { return phone; }
    public String getGrade()  { return grade; }

    // Setters
    public void setId(String id)  { this.id = id; }
    public void setName(String name)  { this.name = name; }
    public void setEmail(String email)  { this.email = email; }
    public void setPhone(String phone)  { this.phone = phone; }
    public void setGrade(String grade)  { this.grade = grade; }

    // Convenience: display one line per student
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Email: %s | Phone: %s | Grade: %s",
                id, name, email, phone, grade);
    }
}