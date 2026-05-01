public class Course{
    private String id; // format CSXXX
    private String name;
    private int registeredStudents;
    private int maxSeats;
    private String[] prerequisites; // separated by comma

  private String targetClass;
  private int targetInt;
  private int lowInt;
  private int highInt;

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

  public static void RegisterMenu() {
    final String BAR_LINE = "\n============================";
    String menuType = "\n|====Registration Menu=====|";
    String optionA = "\n|1. Print all courses      |";
    String optionB = "\n|2. Print completed courses|";
    String optionC = "\n|3. Search for a course    |";
    String optionD = "\n|4. Register for a course  |";
    String optionE = "\n|5. Exit                   |";
    String requirement = "\nPlease enter a choice (1-5): ";

    System.out.println(BAR_LINE + menuType + optionA + optionB + optionC + optionD + optionE + BAR_LINE + requirement);

  }

// returns status like 35/40
public String getStatus() {
    return registeredStudents + "/" + maxSeats;
}
    public String toString() {
        return id + " - " + name + " (" + getStatus() + ")";
    }

public int seperateBinarySearch(String target) {
  //Seperate
  String classType = "";
  int intTarget;
  int lowInt;
  int highInt;

  int inc = 0;
  int counter = 0;

  char test = target.charAt(inc); //initial
  while (Character.isDigit(test) == false) {
    classType+=test;
    inc++;
    counter++;

    test = target.charAt(inc);
  }

  char tempA = target.charAt(inc);
  String tempTargetInt = "";

  //gets numbers
  while (inc < target.length()) {

    tempA = target.charAt(inc);
    inc++;
    tempTargetInt += tempA;

  }

  intTarget = Integer.parseInt(tempTargetInt);
  return intTarget;

}

  //Return a string, being toString of course
  public static String searchCourseById(Course[] listC ,String target, String low, String high) {
     //Course[] courseCatalog = new Course[100]; //set max courses
    //listC = courseCatalog;

    //Seperate
    String classType = "";

    int lowInt;
    int highInt;

    //ERROR CHECKING HERE

     //String index = listC[listC.length-1].toString(); //max place
    //System.out.println(index);
    //String index = "a";
    //System.out.println(listC[listC.length-1]);

    String index = listC[1].toString(); //TEST

    //int highInt = Integer.parseInt(high);
    //int lowInt = Integer.parseInt(low);

    int lowCheck = low.compareTo(high);
    int highCheck = high.compareTo(low);

    /*
     while (low.compareTo(high) <= high) {

     int n = lowInd + ((highInt - lowInt)/2);
     String mid = listC[n].toString();

     if (mid.compareTo(target) < target.compareTo(mid)) {
     int midInt = Integer.parseInt(mid);
       lowInt = midInt + 1;
     }

     else if (mid.compareTo(target) > target.compareTo(mid)) {
       int midInt = Integer.parseInt(mid);
     highInt = midInt - 1;
     }

     else if (mid.equals(target)) {
     index = mid;
     break;
     }

     }*/
    return index;

     }


}
