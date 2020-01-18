//This program defines a class named Dice for properties and methods related to rolling dice
public class Dice {
	// Declaring attributes
	private int die1;
	private int die2;

	// Accessor methods
	public int getDie1() {
		return die1;
	}

	public int getDie2() {
		return die2;
	}

	// Rolling 2 dice
	public int rollDice() {
		die1 = (int) (Math.random() * ((6 - 1) + 1)) + 1;
		die2 = (int) (Math.random() * ((6 - 1) + 1)) + 1;
		return (die1 + die2);

	}

	// Checking if dice are equal
	public boolean isDouble() {
		if (die1 == die2) {
			return true;
		} else {
			return false;
		}
	}

	// Displaying numbers of die1 and die2
	public String toString() {

		return "you rolled Die1: " + die1 + " Die2: " + die2;
	}

}
