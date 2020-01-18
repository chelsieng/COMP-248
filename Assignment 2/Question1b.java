// The following program outputs the corresponding month and season from a given number from 1 to 12 which the user inputs using switch statement
import java.util.Scanner;

public class Question1b {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter the Month as a number 1-12: ");
		int num = userInput.nextInt(); // user inputs integer number
		// using switch statement
		switch (num) {
		case 1:
			System.out.println("We are in Farvardin, Happy Spring");
			break;
		case 2:
			System.out.println("We are in Ordibehesht, Happy Spring");
			break;
		case 3:
			System.out.println("We are in Khordad, Happy Spring");
			break;
		case 4:
			System.out.println("We are in Tir. Have Fun in summer");
			break;
		case 5:
			System.out.println("We are in Mordad. Have Fun in summer");
			break;
		case 6:
			System.out.println("We are in Shahrivar. Have Fun in summer");
			break;
		case 7:
			System.out.println("We are in Mehr, Ready For Fall");
			break;
		case 8:
			System.out.println("We are in Aban, Ready For Fall");
			break;
		case 9:
			System.out.println("We are in Azar, Ready For Fall");
			break;
		case 10:
			System.out.println("We are in Dey, Keep warm Yourself in Winter");
			break;
		case 11:
			System.out.println("We are in Bahman, Keep warm Yourself in Winter");
			break;
		case 12:
			System.out.println("We are in Esfand, Keep warm Yourself in Winter");
			break;
		default:
			System.out.println("This is not a valid month"); // if input is not between 1 and 12 inclusive
		}
		userInput.close(); // closing scanner
	}
}