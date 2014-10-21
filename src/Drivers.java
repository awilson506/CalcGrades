import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Drivers {
	
	public String assignGrade(ArrayList < Integer > grades, int mean) {
		//set output to write to output.txt file
	    try {
	    	PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
	    	System.setOut(out);
	    } catch (FileNotFoundException ex) {
	    	return "output.txt file not found";
	    }

	    if (!grades.isEmpty()) {
	    	//loop through all the grades in the array list and determine the grade
	    	char finalGrade;
	      	System.out.format("%-10.30s  %-10.30s%n", "Exam Grade", "Final Grade");
	      	for (Integer grade: grades) {
	      		float gradeDiff = (float)(grade - mean);
	      		gradeDiff = gradeDiff / mean * 100;
	      		if (gradeDiff > 10) {
	      			finalGrade = 'O';
	      		} else if (gradeDiff <= 10 && gradeDiff >= -10) {
	      			finalGrade = 'S';
	      		} else {
	      			finalGrade = 'U';
	      		}
	      		System.out.format("%-10.30s  %-10.30s%n", grade, finalGrade);
	      	}
	    }
	    return null;
	}
	
	//read in grades as integers from input.txt
	public ArrayList < Integer > getGrades() {
		ArrayList < Integer > grades = new ArrayList < Integer > ();
		try {
			Scanner scanner = new Scanner(new File("input.txt"));
			while (scanner.hasNextInt()) {
				grades.add(scanner.nextInt());
			}
				scanner.close();
				return grades;
		} catch (FileNotFoundException ex) {
			System.out.println("Data file not found");
		}
		return null;
	}

	//calculate the mean of all the grades
	public int calculateAverage(ArrayList < Integer > grades) {
		Integer sum = 0;
		if (!grades.isEmpty()) {
			for (Integer grade: grades) {
				sum += grade;
			}
			return sum / grades.size();
		}
		return sum;
	}
}
