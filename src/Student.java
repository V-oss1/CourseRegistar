public class Student {

    // stores full name of student from txt file
    private String name;

    // stores A-number of student
    private String aNumber;

    // Stores courses the student has completed
    private String[] previousCourses;

    // courses student is registering for. max of 5
    private String [] registeredNextSemester;

    // constructor
    // used when Client.java creates a Student object
    public Student(String name, String aNumber, String[] previousCourses) {
        this.name = name;
        this.aNumber = aNumber;
        this.previousCourses = previousCourses;

        // create empty array with 5 spots for future courses
        // each spot will hold one registered course ID
        registeredNextSemester = new String [5];
    }

    // getter method
    // returns student A-number
    public String getID() {
        return aNumber;
    }

    // getter method
    // returns student name
    public String getName() {
        return name;
    }
    // getter method
    // returns completed courses from previous semesters
    public String[] getPreviousCourses() {
        return previousCourses;
    }

    // getter method
    // returns courses student registered for next semester
    public String[] getRegisteredNextSemester() {
        return registeredNextSemester;
    }

    // loads registered courses from file into next semester array
    public void setRegisteredNextSemester(String[] courses) {
        for (int i = 0; i < courses.length && i < registeredNextSemester.length; i++) {
            registeredNextSemester[i] = courses[i].trim();
        }
    }


    // checks if student completed all prerequisites
    public boolean hasTakenPrereqs( String[] requiredPrereqs) {

        // if course doesn't have prereqs, student is allowed to register
        if (requiredPrereqs == null || requiredPrereqs.length == 0) {
            return true;
                }

        // check each required prereq
        for (int i = 0; i < requiredPrereqs.length; i++) {

            // start as fault only turns true if finding a matching completed class
            boolean found = false;

            // compare every prereq w courses student has already taken
            for (int j = 0; j < previousCourses.length; j++) {
                if (requiredPrereqs[i].trim().equals(previousCourses[j].trim())) {
                    found = true;
                    break;
                }
            }
            // if one pre req was not found then registration should fail asap
            if (found == false){
                return false;
            }
        }
            // if loop finishes all pre reqs were found
            return true;

        }

    // check if student has already completed course before
    public boolean alreadyTookCourse(String courseID) {
        // search thru completed course list
        for (int i = 0; i < previousCourses.length; i++) {

            if (previousCourses[i].trim().equals(courseID)) {
                return true;
            }
        }
        // if not found in completed list
        return false;
    }
        // check if student already registered this course
        public boolean alreadyRegistered(String courseID) {
            // search thru next semester array
            for (int i = 0; i < registeredNextSemester.length; i++) {
                // first check if spot is empty and then compare the course ID
            if (registeredNextSemester[i] != null && registeredNextSemester[i].equals(courseID)){

                    return true;
                }
        }
        // course was not found in register list
        return false;
        }

        // count how many classes student has registered for
        public int numberRegistered(){
            int count = 0;
            // every non-empty space means a register class
            for (int i = 0 ; i < registeredNextSemester.length; i++) {
                if (registeredNextSemester[i] != null){
                    count++;
                }
            }
            return count;
        }

        // checks all rules before registering
        public boolean canRegister(Course course) {
        // make sure that the course exists
            if (course == null) {
                return false;
        }

        // must have all Presser
        if (!hasTakenPrereqs(course.getPrerequisites())) {
            return false;
        }

        // must have seats available
        if (!course.hasOpenSeats()) {
            return false;
        }

        // cannot retake a completed course
        if (alreadyTookCourse(course.getId())) {
            return false;
        }

        // cannot register for same course twice
        if (alreadyRegistered(course.getId())) {
            return false;
        }

        // cannot take more than 5 courses
        if (numberRegistered() >= 5) {
            return false;
        }

        return true;
    }


    // adds course to next semester schedule if all checks pass
    public void register(Course course) {
        if (course == null) {
        System.out.println("Cannot register: course does not exist.");
        return;
    }
        if (!hasTakenPrereqs(course.getPrerequisites())) {
            System.out.println("Cannot register: missing prerequisites.");
            return;
        }

        if (!course.hasOpenSeats()) {
            System.out.println("Cannot register: course is full.");
            return;
        }
        if (alreadyTookCourse(course.getId())) {
            System.out.println("Cannot register: you already completed this course.");
            return;
        }
        if (alreadyRegistered(course.getId())) {
            System.out.println("Cannot register: you already registered for this course.");
            return;
        }
        if (numberRegistered() >= 5) {
            System.out.println("Cannot register: maximum of 5 courses reached.");
            return;
        }
        // if all checks passed, add to first empty spot
        for (int i = 0; i < registeredNextSemester.length; i++) {
            if (registeredNextSemester[i] == null) {
                registeredNextSemester[i] = course.getId();
                course.increaseRegisteredStudents();
                System.out.println("Successfully registered for " + course.getId());
                return;
            }
        }
    }

    public void cancelCourse(Course course) {
        // If the course DNE, canceling should not even start
        if (course == null) {
            System.out.println("Cannot cancel: course does not exist.");
            return;
        }

        for (int i = 0; i < registeredNextSemester.length; i++) {
            if (registeredNextSemester[i] != null &&
                registeredNextSemester[i].equalsIgnoreCase(course.getId())) {

                    registeredNextSemester[i] = null;
                    //course.decreaseRegisteredStudents(); work on later

                    System.out.println("Succesfully canceled " + course.getId());
                    return;
                }
            }
            System.out.println("Cannot cancel: you are not registered in this course.");
        }



    // prints basic student info
    public String toString() {
        return "Student{name='" + name + "', aNumber='" + aNumber + "'}";
    }
}
