public class Course{
    private String id; // format CSXXX
    private String name;
    private int registeredStudents;
    private int maxSeats;
    private String[] prerequisites; // separated by comma
  private static String courseType;

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

    //used for getting the numbers
  public static int seperateBinarySearch(String target) {
    //Seperate
    String classType = "";
    int intTarget;

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
    courseType = classType;
    return intTarget;

  }

  private static String getCourseType(String n) {
      String type = "";
      char temp;
      boolean isRunning = true;
      for (int i = 0; isRunning; i++) {
        temp = n.charAt(i);
        if (Character.isLetter(temp)) {
          type += temp;
        }
        else {
          isRunning = false;
        }
      }
    return type;
  }

  //Gets rid of the null entries, making the array "full"
  public static Course[] nullEraser(Course[] listC) {
      Course []temp = listC;
      int size = 1; //default

    String [] f = {"a", "b", "c"};

      for (int i = 0; i < listC.length ; i++) {
        if (listC[i] == null) {
          break;
       }


        Course []tempB = new Course[size];
        int count = 0;

        while (count < size) {
          tempB[count] = listC[count];
          count++;

          if (count == size-1) {
          }

        }
        size++;

        temp = tempB;
      }

      return temp;
  }

  private static boolean isValidCourse(String n, Course[] listC) {
      boolean check = true;
      for (int i = 0; i < listC.length; i++) {
        String temp = listC[i].toString();

        if (temp.contains(n)) {
          check = true;
          break;
        }
        else if (i == listC.length -1 && !temp.contains(n)) {
          check = false;
        }

      }
      return check;
  }

  private static int getIndex (String n, Course[] listC) {
      //should always return a real index
      int indexG = 0;

      for (int i = 0; i < listC.length; i++) {
        String temp = listC[i].toString();

        if (temp.contains(n)) {
          indexG = i;
        }
      }
      return indexG;
  }

  //Return a string, being toString of course
  public static String searchCourseById(Course[] listC ,String target, String low, String high) {

    //Seperate

    //int targetInt = seperateBinarySearch(target);
    //int lowInt = seperateBinarySearch(low);
    //int highInt = seperateBinarySearch(high);

    //gets a more convient array to work with
    Course[] filledList = nullEraser(listC);

    boolean validTarget = isValidCourse(target, filledList);
    boolean validLow = isValidCourse(low, filledList);
    boolean validHigh = isValidCourse(high, filledList);

    String classType = getCourseType(target);

    String index = target + " is not a course";

    if (validTarget == false || validLow == false || validHigh == false) {
      System.out.println("There was an error with one of the ranges. Try again");
    }
    else {
      int targetInt = getIndex(target, filledList);
      int lowInt = getIndex(low, filledList);
      int highInt = getIndex(high, filledList);

      while (lowInt <= highInt) {

        int midInt = lowInt + ((highInt-lowInt) /2);

        if (midInt < targetInt) {
          lowInt = midInt + 1;
        } else if (midInt > targetInt) {
          highInt = midInt - 1;
        } else if (midInt == targetInt) {
          index = listC[targetInt].toString();
          break;
        }

      }
    }
      return index;

  }
}
