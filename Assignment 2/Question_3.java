// The following program runs as a simple calculator where the user inputs the expression to be evaluated
import java.util.Scanner;

public class Question_3 {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Hello to mini calculator program.");
		System.out.println("Please enter the numbers along operation (press q to exit):\n");
		String input = userInput.next(); // user inputs both operands and operation
		// Repeating user input after each evaluation
		while (!input.equals("q")) {
			int oper1 = input.indexOf('x'); // finding position of 'x'
			int oper2 = input.indexOf('+'); // finding position of '+'
			int oper3 = input.indexOf('/'); // finding position of '/'
			int oper4 = input.indexOf('-'); // finding position of '-'
			// declaring 'x', '+', '/' and '-' as operations
			int oper = 0;
			if (oper1 != -1) {
				oper = oper1;
			} else if (oper2 != -1) {
				oper = oper2;
			} else if (oper3 != -1) {
				oper = oper3;
			} else if (oper4 != -1) {
				oper = oper4;
			}
			int num1 = Integer.parseInt(input.substring(0, oper)); // extracting first operand
			int num2 = Integer.parseInt(input.substring(oper + 1, input.length())); // extracting second operand
			char operation = input.charAt(oper); // extracting operation
			// Multiplication of operands
			if (operation == 'x') {
				float ans = num1 * num2;
				System.out.println("The answer is: " + ans);
				System.out.println("Please enter the numbers along operation (press q to exit):\n");

			}
			// Addition of operands
			else if (operation == '+') {
				float ans = num1 + num2;
				System.out.println("\nThe answer is: " + ans);
				System.out.println("Please enter the numbers along operation (press q to exit):\n");

			}
			// Subtraction of operands
			else if (operation == '-') {
				float ans = num1 - num2;
				System.out.println("\nThe answer is: " + ans);
				System.out.println("Please enter the numbers along operation (press q to exit):\n");

			}
			// Division of operands
			else if (operation == '/') {
				float ans = num1 / num2;
				System.out.println("\nThe answer is: " + ans);
				System.out.println("Please enter the numbers along operation (press q to exit):\n");

			}
			input = userInput.next(); // user inputs another expression
		}
		// user presses q to exit
		if (input.equals("q")) {
			System.out.println("\nThanks for using mini calculator program.");
		}
		userInput.close(); // closing scanner
	}

}
