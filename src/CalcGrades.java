/*
 * Name: Adam Wilson
 * Project: 1
 * Class: COSC 600
 * 
 * This program reads in a series of integers as grades and puts them into 
 * an array list.  Once they're in the array list it calulates the mean of 
 * all the grades and then determines the students final grade and writes it
 * to the file output.txt.
 */

import java.util.ArrayList;
import java.lang.Integer;


public class CalcGrades {

  public static void main(String[] args) {
	  
	  //declare a new instance of the Drivers class
	  Drivers d = new Drivers();
	  
	  //read the grades into and array list from the input.txt file
	  ArrayList < Integer > examGrades = d.getGrades();
	  //get the mean and assign the grade based on the deviation
	  String ex = d.assignGrade(examGrades, d.calculateAverage(examGrades));
	  //if the output file doesn't exist print out the exception returned
	  if( ex != null){
		  System.out.println(ex);
	  }
  }

  
}
