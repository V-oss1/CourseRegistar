This program is a simple course registration system written in Java. It reads course information and student information from text files, lets the user interact with the program through a menu, and then updates the files when the program exits.

Optional Goals Implemented:

e. Binary Search
Binary search is used to find a course by its ID. Before using binary search, the course list is sorted by course ID. The program then checks the middle of the list and keeps narrowing it down until the course is found or determined to not exist.

f. Cancel a Registered Course
The program allows the user to cancel a course they are registered for. If the course is found in the student’s schedule, it is removed and the number of registered students in that course is decreased. If the student is not registered in that course, an error message is shown.

h. Handle Invalid Input
The program checks user input before using it. If the user enters something invalid in the menu, the program prints an error message and goes back to the menu instead of crashing.

The program uses arrays to store and manage course and student data.
