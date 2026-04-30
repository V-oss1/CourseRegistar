Each team only needs to make one submission on Canvas. The submission should include three following items.  
1. A class diagram showing the design of your program. 
2. A zipped file containing the whole java project of your program.  
3. A short readme file explaining which of the optional goals are realized in the program and how they are 
realized.  

Optional goals: 
a. Use at least one user defined interface or at least one abstract class. 
b. Use a data structure that you implemented to handle data. (For example, an ArrayList-like data structure that’s used to handle courses) 

    The program uses an arrays to structure its data to be used in the program. One of the data structres for example is called, courses[] to structure its data. It takes information parsed from the input files and handles the input based on delimiters defined in the program. the client then operates using the parsed and sorted data.

c. Show polymorphism in your code.

d. Use Merge Sort algorithm while sorting.

e. Use Binary Search algorithm while searching.

f. Realize the “cancelling a registered course for the next semester” function.
    To add this function the course reads the current students registered courses then requests what course they want to remove. if the student is registered for this course the student file and courselist are both updated to remove the student from the class they are registered for.
    if not the program gives an error saying that the course is not one they are registered for.
g. Add two reasonable and useful functions to this program.
    1. Added a function to show the requirments for a specific course
    2. Aded a function to show currently registerd courses for the semsester.
h. Handle exceptions and invalid inputs without breaking the flow.
    The program impliments validation using switch statements for the main program. if a unexpected awnser occurs the program will print the error and return to the function. 
 
