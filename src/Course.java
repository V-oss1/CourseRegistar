import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Course { //Reads the courses
    protected String ID; //represents the ID of a course
    protected String name; //represents the name of a course

    //FileReader reader = new FileReader("CourseList.txt");
    CourseInfo courses1 = new CourseInfo();

    public Course() throws IOException {

    }
}


// public class Course{
//     private String id; // format CSXXX
//     private String name;
//     private int registeredStudents; 
//     private int maxSeats;
//     private String[] prerequisites; // separated by comma 

//     // Constructor to initialize from file data 
//     public Course(String id, String name, int registered, int max, String[] prereqs) {
//         this.id = id;
//         this.name = name;
//         this.registeredStudents = registered;
//         this.maxSeats = max;
//         this.prerequisites = prereqs;
//     }

//     // sort by course ID method
//     public int compareTo(Course other) {
//         return this.id.compareTo(other.id);
//     }

//     // check for open seats helper method
//     public boolean hasOpenSeats() {
//         return registeredStudents < maxSeats;
//     }
// }