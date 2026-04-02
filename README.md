# CS-116 Project: Java Course Registration System

<<<<<<< HEAD
This project is a simplified course-registration program implemented in Java. It simulates a scenario where a student accesses a school's database to register for Computer Science (CS) courses for the upcoming semester.
=======
This project is a simplified course-registration program implemented in Java. It simulates a scenario where a student accesses a school's database to register for Computer Science (CS) courses for the upcoming semester. The system reads input files containing course and student data, allows users to interact via the console, and updates the database files upon exiting.
>>>>>>> origin/main

## Table of Contents
* [Installation](#installation)
* [Usage](#usage)
* [Features](#features)
* [Project Structure](#project-structure)
* [Contributing](#contributing)
* [License](#license)
* [Optional Goals](#optional-goals)

## Installation

<<<<<<< HEAD
* The program must be implemented as a new Java project.
* Ensure that the input data files, referred to as `file1` (e.g., "CS-26F.txt") and `file2` (e.g., "A20123456.txt"), are placed within the same Java project directory.

## Usage

* Run the client class to start the application.
* Follow the console prompts, which provide clear and accurate guides to input files and choose functions.
* The program will continue to run and will only terminate if you explicitly choose the exit function.
* After a course is registered or rejected, the program will give clear responses in the console.
* Upon exiting, the program updates the data files, allowing you to use the updated `file1` and `file2` to run the program again in subsequent sessions.

## Features

* **View Available Courses:** Print in the console all the courses provided in the following semester, sorted by course ID.
* **View Course History:** Print all the courses that the user has taken before.
* **Search:** Search for specific courses by their course ID.
* **Register for Courses:** Register for a next-semester course, subject to the following rules:
    * The student must have taken all prerequisites.
    * The course must still have open seats.
    * A student can register for a maximum of 5 courses per semester.
    * A student cannot register for a course they have already taken.
    * A student cannot register for the same course multiple times.
* **Cancel Registration:** Cancel a course that was successfully registered for the coming semester, including courses registered in previous runs of the program.
* **Data Persistence:** Exit the program and write the updated registration information directly back into `file1` (updating the Status columns) and `file2`.

## Project Structure

* **`Course` Class**: Stores course information including a String ID, a String name, the number of total seats, the number of registered seats, and course prerequisites.
* **`Student` Class**: Stores student information including a String ID (A-number), a String name, previously taken courses, and courses the student is about to take next semester.
* **Client Class**: Acts as the main entry point and driver for the program.

## Contributing

* This is a team project; each team can be formed by at most three students.
* Only one team member needs to fill out the "CS-116 Project Teams" form and make the final submission on Canvas.
* The final submission must include three items: a class diagram showing the program's design, a zipped file of the entire Java project, and a short readme file explaining which optional goals were realized and how.

## License

This project is licensed under the MIT License.

## Optional Goals

* Use at least one user-defined interface or abstract class.
* Implement a custom data structure (e.g., an ArrayList-like structure) to handle data.
* Demonstrate polymorphism in the code.
* Use the Merge Sort algorithm for sorting operations.
* Use the Binary Search algorithm for searching operations.
* Successfully realize the "canceling a registered course" function.
* Add two additional reasonable and useful functions.
* Handle exceptions and invalid inputs gracefully without breaking the program's flow.
=======
* The program must be implemented as a new Java project.
* Ensure that the input data files, referred to as `file1` (e.g., "CS-26F.txt") and `file2` (e.g., "A20123456.txt"), are placed within the same Java project directory.

## Usage

* Run the client class to start the application.
* Follow the console prompts, which provide clear and accurate guides to input files and choose functions.
* The program will continue to run and will only terminate if you explicitly choose the exit function.
* After a course is registered or rejected, the program will give clear responses in the console.
* Upon exiting, the program updates the data files, allowing you to use the updated `file1` and `file2` to run the program again in subsequent sessions.

## Features

* **View Available Courses:** Print in the console all the courses provided in the following semester, sorted by course ID.
* **View Course History:** Print all the courses that the user has taken before.
* **Search:** Search for specific courses by their course ID.
* **Register for Courses:** Register for a next-semester course, subject to the following rules:
    * The student must have taken all prerequisites
    * The course must still have open seats.
    * A student can register for a maximum of 5 courses per semester.
    * A student cannot register for a course they have already taken.
    * A student cannot register for the same course multiple times.
* **Cancel Registration:** Cancel a course that was successfully registered for the coming semester, including courses registered in previous runs of the program.
* **Data Persistence:** Exit the program and write the updated registration information directly back into `file1` (updating the Status columns) and `file2` (appending newly registered courses).

## Project Structure

* **`Course` Class**: Stores course information including a String ID, a String name, the number of total seats, the number of registered seats, and course prerequisites.
* **`Student` Class**: Stores student information including a String ID (A-number), a String name, previously taken courses, and courses the student is about to take next semester.
* **Client Class**: Acts as the main entry point and driver for the program.

## Contributing

* This is a team project; each team can be formed by at most three students.
* Only one team member needs to fill out the "CS-116 Project Teams" form and make the final submission on Canvas.
* The final submission must include three items: a class diagram showing the program's design, a zipped file of the entire Java project, and a short README file explaining which optional goals were realized and how.

## License

All Rights Reserved.

## Optional Goals

* Use at least one user-defined interface or abstract class.
* Implement a custom data structure (e.g., an ArrayList-like structure) to handle data.
* Demonstrate polymorphism in the code.
* Use the Merge Sort algorithm for sorting operations.
* Use the Binary Search algorithm for searching operations.
* Successfully realize the "canceling a registered course" function.
* Add two additional reasonable and useful functions.
* Handle exceptions and invalid inputs gracefully without breaking the program's flow.
>>>>>>> origin/main
