public class Course{
    private String id; // format CSXXX
    private String name;
    private int registeredStudents; 
    private int maxSeats;
    private String[] prerequisites; // separated by comma 

    // Constructor to initialize from file data 
    public Course(String id, String name, int registered, int max, String[] prereqs) {
        this.id = id;
        this.name = name;
        this.registeredStudents = registered;
        this.maxSeats = max;
        this.prerequisites = prereqs;
    }
    // Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String[] getPrerequisites() {
        return prerequisites;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public int getMaxSeats() {
        return maxSeats;
    }


    // check for open seats helper method
    public boolean hasOpenSeats() {
        return registeredStudents < maxSeats;
    }

    // increae registered student count by 1
    public void increaseRegisteredStudents() {
        if (hasOpenSeats()) {
            registeredStudents++;
        }
    } 

// returns status like 35/40
public String getStatus() {
    return registeredStudents + "/" + maxSeats;
}
    public String toString() {
        return id + " - " + name + " (" + getStatus() + ")";
    }
}
