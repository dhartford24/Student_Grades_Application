
public class Student implements Comparable<Student>{
	//package friendly variables
	String name;
	String quiz1;
	String quiz2;
	String quiz3;
	String quiz4;
	String midterm1;
	String midterm2;
	String finalScore;
	double total = 0;
	
	//constructor
	Student() {
	} //end constructor
	
	//second constructor
	Student(String[] studentArray) {
		
		this.name = studentArray[0].trim();
		this.quiz1 = studentArray[1].trim();
		this.quiz2 = studentArray[2].trim();
		this.quiz3 = studentArray[3].trim();
		this.quiz4 = studentArray[4].trim();
		this.midterm1 = studentArray[5].trim();
		this.midterm2 = studentArray[6].trim();
		this.finalScore = studentArray[7].trim();
	}
	
	public String getName() {
		return name;
	}
	
	public int quiz1Score() {
		return Integer.parseInt(this.quiz1);
	}
	
	public int quiz2Score() {
		return Integer.parseInt(this.quiz2);
	}
	
	public int quiz3Score() {
		return Integer.parseInt(this.quiz3);
	}
	
	public int quiz4Score() {
		return Integer.parseInt(this.quiz4);
	}
	
	public int midterm1Score() {
		return Integer.parseInt(this.midterm1);
	}
	
	public int midterm2Score() {
		return Integer.parseInt(this.midterm2);
	}
	
	public int myFinalScore() {
		return Integer.parseInt(this.finalScore);
	}
	
	public double totalPercent() {
		total = quiz1Score() * .10 + quiz2Score() * .10 + quiz3Score() * .10 + quiz4Score() * .10 +
				midterm1Score() * .20 + midterm2Score() * .15 + myFinalScore() * .25;
		return total;
	}
	
	//override the compareTo function by implementing the Comparable interface
	//used to compare Student Objects by name
	@Override
	public int compareTo(Student o) {
		String compareName = ((Student)o).getName();
		
		String currentName = this.name;
		
		if(compareName.compareTo(currentName) < 0)
			return 1;
		else if(compareName.compareTo(currentName) > 0)
			return -1;
		else
			return 0;
	} //end compareTo override

} //end Student class
