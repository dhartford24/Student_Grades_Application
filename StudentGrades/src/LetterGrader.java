import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LetterGrader extends Student {
	
	//lists and private variables
	private String args0;
	private String args1;
	private int numStudents = 0;
	
	ArrayList<Student> listOfStudents = new ArrayList<>();
	ArrayList<Object> sortedStudents = new ArrayList<>();
	ArrayList<Character> gradeLetters = new ArrayList<>();
	
	ArrayList<Integer> q1 = new ArrayList<>();
	int q1Min;
	int q1Max;
	private int sumq1 = 0;
	private double q1Average;
	
	ArrayList<Integer> q2 = new ArrayList<>();
	private int q2Min;
	private int q2Max;
	private int sumq2 = 0;
	private double q2Average;
	
	ArrayList<Integer> q3 = new ArrayList<>();
	private int q3Min;
	private int q3Max;
	private int sumq3 = 0;
	private double q3Average;
	
	ArrayList<Integer> q4 = new ArrayList<>();
	private int q4Min;
	private int q4Max;
	private int sumq4 = 0;
	private double q4Average;
	
	ArrayList<Integer> mid1 = new ArrayList<>();
	private int mid1Min;
	private int mid1Max;
	private int sumMid1 = 0;
	private double mid1Average;
	
	ArrayList<Integer> mid2 = new ArrayList<>();
	private int mid2Min;
	private int mid2Max;
	private int sumMid2 = 0;
	private double mid2Average;
	
	ArrayList<Integer> myFinal = new ArrayList<>();
	private int myFinalMin;
	private int myFinalMax;
	private int sumMyFinal = 0;
	private double myFinalAverage;
	
	
	//Letter Grader constructor
	LetterGrader() {
	} //end LetterGrader constructor
	
	//Second constructor
	LetterGrader(String[] args) {
		this.args0 = args[0];
		this.args1 = args[1];
	} //end second constructor
	
	//reads the input file
	public void readScore() {
		
		File inFile = new File(args0);
		
		try {
			Scanner input = new Scanner(inFile);
			
			while(input.hasNextLine()) {
				String line = input.nextLine();
				//this line has one students data,
				//use split to separate data
				String[] studentInfo = line.split(",");
				//create new Student Object, store in a list
				listOfStudents.add(new Student(studentInfo));
				//increment number of students
				++numStudents;
				
				} //end while
			
			//create an array to hold Student Objects so they can be sorted by name
			Object[] arrayOfStudentObj = new Object[listOfStudents.size()];
			listOfStudents.toArray(arrayOfStudentObj);
			Arrays.sort(arrayOfStudentObj);
			
			//transfer sorted array into a sorted list
			for (int i = 0; i < numStudents; i++) {
				sortedStudents.add(arrayOfStudentObj[i]);
			} //end for
			
			input.close(); //done with input, close it
		} //end try
		catch (IOException e) {
			System.out.println("Error reading from input file: " + args0);
		} //end catch
	} //end readScore
	
	//calculate the letter grades of each student
	public void calcLetterGrade() {
		
		double totalScore = 0;
		char grade = 0;
		
		for (int i = 0; i < numStudents; i++) {
			totalScore = ((Student) sortedStudents.get(i)).totalPercent();
			if (totalScore >= 90)
				grade = 'A';
			else if (totalScore >= 80)
				grade = 'B';
			else if (totalScore >= 70)
				grade = 'C';
			else if(totalScore >= 60)
				grade = 'D';
			else
				grade = 'F';
			
			//add each letter grade to an array list
			gradeLetters.add(grade);
		} //end for
		
	} //end calcLetterGrade
	
	//print the sorted student's names and their letter grades to the output file
	public void printGrade() {
		File outFile = new File(args1);
		
		try {
			PrintWriter output = new PrintWriter(outFile);
			output.printf("Letter grade for %d students given in %s file is:\n\n", numStudents, args0);
			for(int i = 0; i < numStudents; i++) {
				output.printf("%-25s%s\n", ((Student) sortedStudents.get(i)).getName() + ":",
					gradeLetters.get(i));	
			} //end for
			output.close(); //done with output, close it
		} //end try
		catch (IOException e) {
			System.out.println("Error writing to output file: " + args1);
		} //end catch
		
	} //end printGrade
	
	//calculate averages, minimums, and maximums of each quiz, midterm, and final. Print result to the console
	public void displayAverages() {
		
		//add all scores of a certain category (quiz1, quiz2, quiz3, etc...) to a separate list
		for (int i = 0; i < numStudents; i++) {
			q1.add(((Student) sortedStudents.get(i)).quiz1Score());
			q2.add(((Student) sortedStudents.get(i)).quiz2Score());
			q3.add(((Student) sortedStudents.get(i)).quiz3Score());
			q4.add(((Student) sortedStudents.get(i)).quiz4Score());
			mid1.add(((Student) sortedStudents.get(i)).midterm1Score());
			mid2.add(((Student) sortedStudents.get(i)).midterm2Score());
			myFinal.add(((Student) sortedStudents.get(i)).myFinalScore());
		} //end for
		
		//obtain mins and maxes for each quiz, midterm, and final
		q1Min = (java.util.Collections.min(q1));
		q1Max = (java.util.Collections.max(q1));
		
		q2Min = (java.util.Collections.min(q2));
		q2Max = (java.util.Collections.max(q2));
		
		q3Min = (java.util.Collections.min(q3));
		q3Max = (java.util.Collections.max(q3));
		
		q4Min = (java.util.Collections.min(q4));
		q4Max = (java.util.Collections.max(q4));
		
		mid1Min = (java.util.Collections.min(mid1));
		mid1Max = (java.util.Collections.max(mid1));
		
		mid2Min = (java.util.Collections.min(mid2));
		mid2Max = (java.util.Collections.max(mid2));
		
		myFinalMin = (java.util.Collections.min(myFinal));
		myFinalMax = (java.util.Collections.max(myFinal));
		
		//calculate the averages of each quiz, midterm, and final
		for (int j = 0; j < numStudents; j++) {
			sumq1 += (q1.get(j));
			q1Average = sumq1 / (double)numStudents;
			sumq2 += (q2.get(j));
			q2Average = sumq2 / (double)numStudents;
			sumq3 += (q3.get(j));
			q3Average = sumq3 / (double)numStudents;
			sumq4 += (q4.get(j));
			q4Average = sumq4 / (double)numStudents;
			sumMid1 += (mid1.get(j));
			mid1Average = sumMid1 / (double)numStudents;
			sumMid2 += (mid2.get(j));
			mid2Average = sumMid2 / (double)numStudents;
			sumMyFinal += (myFinal.get(j));
			myFinalAverage = sumMyFinal / (double)numStudents;
		}
		
		//print results to the console
		System.out.printf("Letter grade has been calculated for students listed in input " +
				"file %s and written to %s\n\n", args0, args1);
		System.out.println("Here is the class averages:");
		
		System.out.printf("%15s%8s%8s%8s%8s%8s%8s\n", "Q1", "Q2", "Q3", "Q4",
				"Mid1", "Mid2", "Final");
		System.out.printf("%s%8.2f%8.2f%8.2f%8.2f%8.2f%8.2f%8.2f\n", "Average:", q1Average,
				q2Average, q3Average, q4Average, mid1Average, mid2Average, myFinalAverage);
		System.out.printf("%s%8d%8d%8d%8d%8d%8d%8d\n", "Minimum:", q1Min, q2Min, q3Min, q4Min,
				mid1Min, mid2Min, myFinalMin);
		System.out.printf("%s%8d%8d%8d%8d%8d%8d%8d\n", "Maximum:", q1Max, q2Max, q3Max, q4Max,
				mid1Max, mid2Max, myFinalMax);
		
	} //end displayAverages
	
} //end LetterGrader class
