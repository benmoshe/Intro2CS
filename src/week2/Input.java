package week2;


import java.util.Scanner;

/**
 * A simple example of how to read an input from the command line
 * This example was taken from: https://alvinalexander.com/java/edu/pj/pj010005/
 * @author boaz.benmoshe
 *
 */
public class Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  {
			    // create a scanner so we can read the command-line input
			    Scanner sc = new Scanner(System.in);

			    //  prompt for the user's name
			    System.out.print("Enter your name: ");

			    // get their input as a String
			    String username = sc.next();

			    // prompt for their age
			    System.out.print("Enter your age: ");

			    // get the age as an int
			    String age_str = sc.next();
			    int age = Integer.parseInt(age_str); 

			    System.out.println(String.format("%s, your age is %d", username, age));
			    System.out.print("Enter double: ");

			    // get the age as an int
			   double d = sc.nextDouble();
			   
			  }
	}

}
