// The following reads a 5-digit number representing a time in seconds and outputs the corresponding hours, minutes and seconds
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) {
		// declaring variables
		final int numberofmin = 60; // constant variable number of minutes in an hour
		final int numberofsec = 60; // constant variable number of seconds in a minute
		int hours; // time in hours
		int minutes; // time in minutes
		int seconds; // time in seconds
		int input; // 5-digit number which user inputs

		Scanner userInput = new Scanner(System.in); 

		System.out.println(
				"***********************************************\n   Welcome to Time Converter Program\n***********************************************");
		System.out.print("\n\nPlease enter the seconds which will be converted: ");
		input = userInput.nextInt();
		hours = (int) ((int) input / (numberofmin * numberofsec)); // converting seconds into hours
		minutes = (int) (((int) input % (numberofmin * numberofsec)) / numberofsec); // converting remaining seconds into minutes
		seconds = (int) (((int) input % (numberofmin * numberofsec)) % numberofsec); // remaining seconds
		// If converted time is not valid
		if (hours >= 24) {
			System.out.println("\nThe correspond hours, minutes, seconds is " + hours + " hrs, " + minutes + " mins, "
					+ seconds + " secs.");
			System.out.println("\nThere is no valid time of your input.");
			int n = input;
			int first = (n / 10000); // first digit of the 5-digit number which user inputs
			int last = n % 10; // last digit of the 5-digit number which user inputs
			n = n - (first * 10000); // removing first digit from 5-digit number
			n = n + (last * 10000); // adding last digit to first position of 5-digit number
			n = n - last; // removing last digit from 5-digit number
			n = n + first; // adding first digit to last position of 5-digit number
			System.out.println("\nThe swapped sequence of the input time is:" + n);
			hours = (int) ((int) n / (numberofmin * numberofsec)); // converting 5-digit from seconds into hours
			minutes = (int) (((int) n % (numberofmin * numberofsec)) / numberofsec); // converting remaining seconds into minutes
			seconds = (int) (((int) n % (numberofmin * numberofsec)) % numberofsec); // remaining seconds
			System.out.println("\nThe correspond hours, minutes, seconds is " + hours + " hrs, " + minutes + " mins, "
					+ seconds + " secs.");
		} else {
			// displaying 00 when hours, minutes or seconds are equal to 0
			if (minutes < 10 && seconds < 10) {
				System.out.println("\nThe correspond hours, minutes, seconds is " + hours + " hrs, " + minutes
						+ " mins, " + seconds + " secs.");
				System.out.println("\nThe valid time is: " + hours + ":0" + minutes + ":0" + seconds + ".");

			} else if (minutes < 10) {
				System.out.println("\nThe correspond hours, minutes, seconds is " + hours + " hrs, " + minutes
						+ " mins, " + seconds + " secs.");
				System.out.println("\nThe valid time is: " + hours + ":0" + minutes + ":" + seconds + ".");
			} else if (seconds < 10) {
				System.out.println("\nThe correspond hours, minutes, seconds is " + hours + " hrs, " + minutes
						+ " mins, " + seconds + " secs.");
				System.out.println("\nThe valid time is: " + hours + ":" + minutes + ":0" + seconds + ".");
			} else {
				System.out.println("\nThe correspond hours, minutes, seconds is " + hours + " hrs, " + minutes
						+ " mins, " + seconds + " secs.");
				System.out.println("\nThe valid time is: " + hours + ":" + minutes + ":" + seconds + ".");
			}
		}
		System.out.println("\nThank you for using the Time Converter Program!");
		userInput.close(); // closing the scanner
	}

}