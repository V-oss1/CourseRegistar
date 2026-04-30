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

    // Decrease the number of registered students by 1 
    public void decreaseRegisteredStudents() { 
        if (registeredStudents > 0 ) { 
            registeredStudents--;
        }
    }

public static void RegisterMenu() {
    final String BAR_LINE = "\n============================";
    String menuType = "\n|====Registration Menu=====|";
    String optionA = "\n|1. Print all courses      |";
    String optionB = "\n|2. Print completed courses|";
    String optionC = "\n|3. Search for a course    |";
    String optionD = "\n|4. Register for a course  |";
    String optionE = "\n|5. Cancel a course        |";
    String optionF = "\n|6. Show Requirments       |";
    String optionG = "\n|7. Currently Registered   |";
    String optionH = "\n|8. Exit                   |";
    String requirement = "\nPlease enter a choice (1-6): ";

    System.out.println(BAR_LINE + menuType + optionA + optionB + optionC + optionD + optionE + optionF + optionG + optionH + BAR_LINE + requirement);

}

// returns status like 35/40
public String getStatus() {
    return registeredStudents + "/" + maxSeats;
}
    public String toString() {
        return id + " - " + name + " (" + getStatus() + ")";
    }
//course functions    
}
