// The following program outputs the corresponding month and season from a given number from 1 to 12 which the user inputs using if/else statement
import java.util.Scanner;

public class Question1a {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter the Month as a number 1-12: ");
		int num = userInput.nextInt(); // user inputs integer number
		// using if/else statement
		if (num == 1) {
			System.out.println("We are in Farvardin, Happy Spring");
		} else if (num == 2) {
			System.out.println("We are in Ordibehesht, Happy Spring");
		} else if (num == 3) {
			System.out.println("We are in Khordad, Happy Spring");
		} else if (num == 4) {
			System.out.println("We are in Tir. Have Fun in summer");
		} else if (num == 5) {
			System.out.println("We are in Mordad. Have Fun in summer");
		} else if (num == 6) {
			System.out.println("We are in Shahrivar. Have Fun in summer");
		} else if (num == 7) {
			System.out.println("We are in Mehr, Ready For Fall");
		} else if (num == 8) {
			System.out.println("We are in Aban, Ready For Fall");
		} else if (num == 9) {
			System.out.println("We are in Azar, Ready For Fall");
		} else if (num == 10) {
			System.out.println("We are in Dey, Keep warm Yourself in Winter");
		} else if (num == 11) {
			System.out.println("We are in Bahman, Keep warm Yourself in Winter");
		} else if (num == 12) {
			System.out.println("We are in Esfand, Keep warm Yourself in Winter");
		} else
			System.out.println("This is not a valid month"); // if input is not between 1 and 12 inclusive

		userInput.close(); // closing scanner
	}

}