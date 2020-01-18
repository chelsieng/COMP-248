// The following program calculates the circumference of a square and show its shape using "X" and main diagonal "\" from the length which user inputs
import java.util.Scanner;

public class Question_2 {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println(
				"---------------------------------------------------------\n            Circumference Calculator\n---------------------------------------------------------");
		System.out.println("\nPlease enter the length of the side!");
		int len = userInput.nextInt(); // user inputs length
		int cir = len * 4; // Circumference of square
		System.out.println("The Circumference of the Square is " + cir);
		int i; // vertical X
		int j; // horizontal X
		// repeating vertical 'X'
		for (i = 1; i <= len; i++) {
			System.out.print("                                     "); // positioning shape of square
			// repeating horizontal 'X'
			for (j = 1; j <= len; j++) {
				// shaping main diagonal
				if (i == j) {
					System.out.print("\\ ");
				} else
					System.out.print("X ");
			}
			System.out.println("");

		}
		userInput.close(); // closing scanner
	}

}
