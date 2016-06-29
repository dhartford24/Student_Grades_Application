//Derek Hartford
//Java Programming for Beginners
//11-22-15
//Instructor: Bineet Sharma

/*This program takes the names and test scores from an unknown number of students and displays the
 averages, maximums, and minimums of each test score in the console. It also sorts the students by name,
 calculates each student's letter grades, and outputs that data to an output file.
 
 It accomplishes this by first checking to see if there are a correct number of arguments passed into
 the main function via a call to processCLArguments. Then it checks to see if the files entered as 
 arguments in the main function exist so they may be read and written into.  If all of this checks out, 
 the program then reads the file via the readScore function, accesses its data and stores each student's 
 data into a Student class one student at a time.  Each Student class is also added into an Array List 
 one student at a time and is then is sorted by name.  Then via a call to calcLetterGrade, the data is 
 used to determine the letter grades of each student. The printGrade function is then called to print 
 the sorted names and respective grades to the output file.  Then displayAverages is called which 
 calculates the averages, maxes, and mins of all the tests. It then prints them out to the console with 
 proper headers for each category. Finally, once the user presses enter the program ends.
 */

import java.io.File;
import java.util.Scanner;

public class TestLetterGrader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myInput = new Scanner(System.in);
		
		processCLArguments(args);
		LetterGrader letterGrader = new LetterGrader(args);
		letterGrader.readScore();
		letterGrader.calcLetterGrade();
		letterGrader.printGrade();
		letterGrader.displayAverages();
		pressEnter(myInput);
		
	} //end main
	
	//check to see if there are a correct number of arguments in the main function
	//if so, check to see if the input and output file exist
	//print corresponding message to console
	public static void processCLArguments(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java TestLetterGrader inputFile outFile");
			System.exit(1);
		} //end if
		else {
			File inFile = new File(args[0]);
			if (!inFile.exists()) {
				System.out.println("Source file " + args[0] + " does not exist");
				System.exit(2);
			} //end if
		
			File outFile = new File(args[1]);
			if(!outFile.exists()) {
				System.out.println("No output file exists");
				System.exit(3);
			} //end if
			
		}//end else
		
	} //end processCLArguments
	
	//pressing enter to continue
		public static void pressEnter(Scanner press) {
			System.out.println("\nPress ENTER to continue. . . .");
			press.nextLine();
		} //end pressEnter

} //end TestLetterGrader class
