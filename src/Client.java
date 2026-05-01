import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class Client {
    private Student currentStudent;
    private Course[] courseCatalog = new Course[100]; //set max courses
    private int courseCount;

    public static void main(String[] args) {
        Client client = new Client();

        // read the two input files
        client.readFile1("CS-26F.txt");
        client.readFile2("A20123456.txt");

        // start menu after files are loaded
        client.menu();

    }
     //logic to create client object and call methods to read files, search courses, register students, and write back to files
    public void readFile1(String filename) {
        File courseFile = new File(filename); //set file path
        // Logic to read student data from file and initialize User object
        try {
            Scanner scr = new Scanner(courseFile);

            if (scr.hasNextLine()) {
                scr.nextLine(); //skip header line

                while (scr.hasNextLine()) {
                    String line = scr.nextLine();
                    String[] columns = line.split("\t"); //uses tab as delimiter'

                    String courseID = columns[0];
                    String courseName = columns[1];

                    //find if seats are avalible
                    String status = columns[2];
                    String[] seats = status.split("/"); //splits by taken/total)
                    int registered = Integer.parseInt(seats[0]);
                    int capacity = Integer.parseInt(seats[1]);

                    // handle prerequisites if they exist by creating an empty array then filling it if they exist.
                    String[] prereqs = new String[0];
                    if (columns.length > 3 && !columns[3].trim().equals("")) {
                        prereqs = columns[3].replace("\"", "").split(","); //split by comma
                        }

                    //import parsed data into Course object
                    Course newCourse = new Course(courseID, courseName, registered, capacity, prereqs);
                    courseCatalog[courseCount] = newCourse;
                    courseCount++;
                }
            }

            System.out.println("Course data loaded successfully." + courseCount + " courses found.");
            scr.close();

    }   catch (FileNotFoundException e) {
            System.out.println("Course data file not found.");
        }
    }

    // reads student data from file and creates Student object
    public void readFile2(String filename) {
        File studentFile = new File(filename); //set file path
        // Logic to read student data from file and initialize User object
        try {
                Scanner scr = new Scanner(studentFile);

                String studentName = scr.nextLine();
                String studentID = scr.nextLine();
                String courses = scr.nextLine();
                String[] previousCourses = courses.split(",");
                //import parsed data into Student object
                currentStudent = new Student(studentName, studentID, previousCourses);
            // check if there is a 4th line for registered next semester
            if (scr.hasNextLine()) {
                String registeredLine = scr.nextLine();

                if (!registeredLine.trim().equals("")) {
                    String[] registeredCourses = registeredLine.split(",");
                    currentStudent.setRegisteredNextSemester(registeredCourses);
                }
            }
                scr.close();

            } catch (FileNotFoundException e) {
                System.out.println("Student data file not found. " + filename);
            }
    }

    // prints all loaded coures
    public void printAllCourses() {
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courseCatalog[i].getId() + " - " + courseCatalog[i].getName());
        }
    }

    // prints courses the student already completed
    public void printCompletedCourses() {
        String[] completed = currentStudent.getPreviousCourses();

        System.out.println("Completed courses:");
        for (int i = 0; i < completed.length; i++) {
            System.out.println(completed[i]);
        }
    }
    // searches for a coures by ID
    public Course searchCourseById(String id) {
        for (int i = 0; i < courseCount; i++) {
            if (courseCatalog[i].getId().equalsIgnoreCase(id)) {
                return courseCatalog[i];
            }
        }
        return null;
    }
    // register for a course by ID
    public void registerForCourse(String id) {
        Course foundCourse = searchCourseById(id);

        if (foundCourse == null) {
            System.out.println("Course not found.");
        } else {
            currentStudent.register(foundCourse);
        }
    }
    // writes updated course data back into course file
    public void writeFile1(String filename) {
        try {
            // PrintWriter is usef to overwrite the file w/ new content
            PrintWriter pw = new PrintWriter(filename);
            // first line is the header row
            pw.println("ID\tName\tStatus\tPrerequisite");

            // loop thru every course stored in courseCatalog array
            for (int i = 0; i < courseCount; i++) {
                // easier ref to current course object
                Course c = courseCatalog[i];
                // write course ID then tab
                pw.print(c.getId() + "\t");
                // write course name then tab
                pw.print(c.getName() + "\t");
                // write updated status like 35/40 or 120/120 then tab
                pw.print(c.getStatus() + "\t");

                // get pre req array for current course
                String[] prereqs = c.getPrerequisites();
                // only write pre req if course has any
                if (prereqs != null && prereqs.length > 0) {
                    for (int j = 0; j < prereqs.length; j++) {
                        // write pre req course ID
                        pw.print(prereqs[j].trim());
                        // if not the last pre req add a comma after it
                        if (j < prereqs.length - 1) {
                            pw.print(",");
                        }
                    }
                }

                pw.println();
            }
            // close to save changes
            pw.close();
            System.out.println("Course file updated.");
        } catch (IOException e) {
            System.out.println("Error writing course file.");
        }
    }
    // Cancels a course for the current student
    public void cancelRegisteredCourse(String id) {
        Course foundCourse = searchCourseById(id);

        if (foundCourse == null) {
            System.out.println("Course not found in the catalog.");
        } else {
            currentStudent.cancelCourse(foundCourse);
        }
    }

    // writes updated student data back into student file
    public void writeFile2(String filename) {
        try {
            // PrintWriter overwrites old file with updated data
            PrintWriter pw = new PrintWriter(filename);
            // line 1 -> student full name
            pw.println(currentStudent.getName());
            // line 2 -> student A num
            pw.println(currentStudent.getID());
            // line 3 -> completed courses
            String [] completed = currentStudent.getPreviousCourses();
            // loop thru completed courses array
            for (int i = 0; i < completed.length; i++) {
                pw.print(completed[i].trim());
                if (i < completed.length - 1) {
                    pw.print(",");
                }
            }
            pw.println();
            // line 4 -> courses registered for next semester
            String[] registered = currentStudent.getRegisteredNextSemester();
            // prevents comma at beginning by tracking if a course has already been printed
            boolean hasRegisteredCourse = false;

            // loop thru registered array
            for (int i = 0; i < registered.length; i++) {
                if  (registered[i] != null) {
                    if (hasRegisteredCourse) {
                        pw.print(",");
                    }
                    pw.print(registered[i]);
                    // at least one course has been printed by now
                    hasRegisteredCourse = true;
                }
            }
            pw.println();

            // close to save
            pw.close();

            // writing failed :(
            System.out.println("Student file updated.");
        } catch (IOException e) {
            System.out.println("Error writing student file.");
        }
    }
    // prints the prerequisites for selected course
    public void printCoursePrerequisites(String id) {
        Course foundCourse = searchCourseById(id);

        if (foundCourse == null) {
            System.out.println("Course not found.");
            return;
        }

        String[] prereqs = foundCourse.getPrerequisites();

        // Check if the array is null or empty
        if (prereqs == null || prereqs.length == 0) {
            System.out.println(foundCourse.getId() + " has no prerequisites.");
        } else {
            System.out.println("Prerequisites for " + foundCourse.getId() + ":");
            for (int i = 0; i < prereqs.length; i++) {
            System.out.println("- " + prereqs[i].trim());
            }
        }
    }

        // prints the courses the student is currently registered for next semester
    public void printCurrentSchedule() {
        String[] registered = currentStudent.getRegisteredNextSemester();
        boolean hasCourses = false;

        System.out.println("\n--- Current Schedule for " + currentStudent.getName() + " ---");
        
        // Loop through the 5 possible registration spots
        for (int i = 0; i < registered.length; i++) {
            if (registered[i] != null) {
                hasCourses = true;
                // Find the full course details to make the output look nice
                Course c = searchCourseById(registered[i]);
                
                if (c != null) {
                    System.out.println("- " + c.toString());
                } else {
                    // Fallback just in case a course ID exists but the course object doesn't
                    System.out.println("- " + registered[i] + " (Details not found in catalog)");
                }
            }
        }

        // If the array was entirely nulls
        if (!hasCourses) {
            System.out.println("You are not currently registered for any courses next semester.");
        }
        System.out.println("----------------------------------");
    }

    public void menu() {
        Scanner input = new Scanner(System.in);
        while (true){

            Course.RegisterMenu();

            //case statesments to handle user input to call methods for each choice
            int choice = input.nextInt();
            input.nextLine(); // clear leftover new line

            switch (choice) {
                case 1:
                    printAllCourses();
                    break;
                case 2:
                    printCompletedCourses();
                    break;
                case 3:
                    System.out.print("Enter course ID: ");
                    String searchID = input.nextLine();
                    Course result = searchCourseById(searchID);

                    if (result == null) {
                        System.out.println("Course not found.");
                    } else {
                        System.out.println(result);
                    }
                    break;

                case 4:
                    System.out.print("Enter course ID to register: ");
                    String registerID = input.nextLine();
                    registerForCourse(registerID);
                    break;

                case 5:
                    System.out.print("Enter course ID to cancel: ");
                    String cancelID = input.nextLine();
                    cancelRegisteredCourse(cancelID);
                    break;
                case 6:
                    System.out.print("Enter course ID to view prerequisites: ");
                    String prereqID = input.nextLine();
                    printCoursePrerequisites(prereqID);
                    break;

                case 7:
                    printCurrentSchedule();
                    break;

                case 8:
                    writeFile1("CS-26F.txt");
                    writeFile2("A20123456.txt");
                    System.out.println("Exiting...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


// Things  to impliment
//     1.print courses the student has already completed
//     2.Merge sort the course catalog by course ID for faster searching (binary search) and to print in sorted order
//     3.impliment binary search for searching courses by ID
//     4. add two reasonable funtions to this program
//         a. print the requiremnts for a course (prereqs)
//         b. print the students current schedule (courses registered for next semester)
//     5. remove a registerd course from the students schedule
//     6. make course.java an abstract class

//Demetrius: Test123
