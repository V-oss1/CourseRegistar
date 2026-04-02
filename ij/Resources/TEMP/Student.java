package Resources.TEMP;
public class Student {
    private String name;
    private String aNumber;
    private String[] previousCourses;
    private String[] registeredNextSemester; // max 5 courses 

    public Student(String name, String aNumber, String[] previous) {
        this.name = name;
        this.aNumber = aNumber;
        this.previousCourses = previous;
        this.registeredNextSemester = new String[5]; // limit check needed
    }

    // Logic to verify prerequisites
    public boolean hasTakenPrereqs(String[] requiredPrereqs) {
        return true; 
    }
}