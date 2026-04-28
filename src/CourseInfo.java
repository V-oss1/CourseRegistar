import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CourseInfo implements CollegeCourses { //File 1, writes course page
    //String fileName; For simplicity, the admin will not be able to create a custom course
    //registration file, as well as input values for now (Scanner)

    File newFileCourse = new File("CourseList.txt");
    FileWriter writer = new FileWriter(newFileCourse);

    final int AMOUNT_CSC = 25; //Amount of CS classes offered
    String[] ID = new String[AMOUNT_CSC];
    String[] courseNames = new String[AMOUNT_CSC];
    String[] status = new String[AMOUNT_CSC];
    String[] prereqs = new String[AMOUNT_CSC];

    public CourseInfo() throws IOException {
        System.out.println("HERE");
        writeFile();
        System.out.println("Print");
        }

    public void writeFile() throws IOException {

        String p1 = "ID"; //p# is part
        String p2 = "Name";
        String p3 = "Status";
        String p4 = "Prerequisite";
        createList();

        //l# is formatted string for writing
        String l1 = String.format("%-4s %5s %35s %15s%n", p1, p2, p3, p4);
        String l2 = String.format("%-4s %5s %10s %15s%n", ID[0], courseNames[0], status[0], prereqs[0]);
        String l3 = String.format("%-4s %5s %10s %15s%n", ID[1], courseNames[1], status[1], prereqs[1]);
        String l4 = String.format("%-4s %5s %10s %15s%n", ID[2], courseNames[2], status[2], prereqs[2]);

        writer.write(l1);
        writer.write(l2);
        writer.write(l3);
        writer.write(l4);
        writer.close();
        }
        // public void createList() {
        // //Set manually for quick testing, far less than array capacity/size
        //     String none = ""; //No prereqs

        // ID[0] = "CS115";
        // ID[1] = "CS116";
        // ID[2] = "CS117";

        // courseNames[0] = "Object-Oriented Programming I";
        // courseNames[1] = "Object-Oriented Programming II";
        // courseNames[2] = "Recursion and Algorithms";

        // status[0] = "98/100";
        // status[1] = "45/50";
        // status[2] = "40/50";

        // prereqs[0] = none;
        // prereqs[1] = "CS115";
        // prereqs[2] = "CS116";
        // }
    }
