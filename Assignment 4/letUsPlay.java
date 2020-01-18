// The following programs Nancy's 3D Warrior Game; a strategic board game where you'll need some luck with the dice

import java.util.Random;
import java.util.Scanner;

public class letUsPlay {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Random rand = new Random();
		Player p0 = new Player(); // Player 1
		Player p1 = new Player(); // Player 2
		// Creating array for player 1 and player 2
		Player[] player = new Player[2];
		Dice die = new Dice(); // Die object
		Board board = new Board(); // Game board
		int turn = 0; // counting number of turns

		// Displaying welcome banner
		for (int i = 0; i < 23; i++) {
			if (i == 0) {
				System.out.print("\t*");
			} else {
				System.out.print(" *");
			}
		}
		for (int i = 0; i < 22; i++) {
			if (i == 0) {
				System.out.print("\n\t -");
			} else {
				System.out.print(" -");
			}
		}
		System.out.print("\n\t*                                           *");
		System.out.print("\n\t*   WELCOME to Nancy's 3D Warrior Game!     *");
		System.out.print("\n\t*                                           *");
		for (int i = 0; i < 23; i++) {
			if (i == 0) {
				System.out.print("\n\t*");
			} else {
				System.out.print(" *");
			}
		}
		for (int i = 0; i < 22; i++) {
			if (i == 0) {
				System.out.print("\n\t -");
			} else {
				System.out.print(" -");
			}
		}

		// Determining and displaying game board size
		System.out.println(
				"\n\nThe default game board has 3 levels and each level has a 4x4 board.\nYou can use this default board size or change the size");
		System.out.println("\t0 to use the default board size\n\t-1 to enter your own size");
		System.out.print("==> What do you want to do? ");
		int l = userInput.nextInt();
		while (l != -1 && l != 0) {
			System.out.print("Sorry but " + l + " is not a legal choice.\n");
			l = userInput.nextInt();
		}
		if (l == 0) {
			System.out.println("\n" + board.toString());
		}
		if (l == -1) {
			System.out.print("How many level would you like? (minimum size 3, max 10) ");
			l = userInput.nextInt();
			while (l < 3 || l > 10) {
				System.out.print("Sorry but " + l + " is not a legal choice.\n");
				l = userInput.nextInt();
			}
			if (l >= 3 || l <= 10) {
				System.out.print(
						"\nWhat size do you want the nxn boards on each level to be? \nMinimum size is 3x3, max is 10x10.");
				System.out.print("\n==> Enter the value of n: ");
				int s = userInput.nextInt();
				while (s < 3 || s > 10) {
					System.out.print("Sorry but " + s + " is not a legal choice.\n");
					s = userInput.nextInt();
				}
				if (s >= 3 || s <= 10) {
					board = new Board(l, s);
					System.out.println("\n" + board.toString());
				}

			}
		}

		// Getting players' names
		System.out.print("\nWhat is player 0's name (one word only): ");
		String n0 = userInput.next();
		System.out.print("What is player 1's name (one word only): ");
		String n1 = userInput.next();
		// Storing player 0's and player 1's name in array
		p0 = new Player(n0);
		p1 = new Player(n1);
		player[0] = p0;
		player[1] = p1;
		Player cPlayer = p0;// Declaring current player
		Player oPlayer = p1;// Declaring other player
		// Randomly determining which player goes first
		int goFirst = rand.nextInt(2);
		if (goFirst == 0) {
			cPlayer = p0;
			oPlayer = p1;

		} else if (goFirst == 1) {
			cPlayer = p1;
			oPlayer = p0;

		}
		System.out.println("\nThe game has started " + cPlayer.getName() + " goes first");
		System.out.println("================================\n");

		// The game begins
		while (!cPlayer.won(board) && !oPlayer.won(board)) {
			System.out.println("It is " + cPlayer.getName() + "\'s turn");
			// When player whose turn has energy<=0, they toss the die 3 times
			while (cPlayer.getEnergy() <= 0) {
				System.out.println(
						"!!!Sorry you're too weak to move, toss the dice 3 times in an attempt to boost your energy.");
				for (int i = 0; i < 3; i++) {
					die.rollDice();
					System.out.println("\t" + cPlayer.getName() + " " + die.toString());
					// When player gets double, player's energy increases by 2 units
					if (die.isDouble()) {
						cPlayer.setEnergy(cPlayer.getEnergy() + 2);
						System.out.println("\tCongratulations you rolled double " + (die.getDie1())
								+ ". Your energy went up by 2 units");
					}

				}
				// if player's energy still <=0, next player's turn
				if (cPlayer.getEnergy() <= 0) {
					System.out.println(
							"!!!Sorry you're still too weak to move.\nIt is " + oPlayer.getName() + "\'s turn");
					turn++;
					if (cPlayer == p0) {
						cPlayer = p1;
						oPlayer = p0;
					} else if (cPlayer == p1) {
						cPlayer = p0;
						oPlayer = p1;
					}
					continue;
				} else {
					System.out.println("Bravo!! You now have " + cPlayer.getEnergy() + " units of energy.");
				}

			}
			// When player whose turn has energy > 0, they roll the dice
			die.rollDice();
			System.out.println("\t" + cPlayer.getName() + " " + die.toString());
			// When player gets double, player's energy increases by 2 units
			if (die.isDouble()) {
				cPlayer.setEnergy(cPlayer.getEnergy() + 2);
				System.out.println(
						"\tCongratulations you rolled double " + (die.getDie1()) + ". Your energy went up by 2 units");

			}

			// Calculating the new location
			int dieTotal = die.getDie1() + die.getDie2(); // Sum of die1 and die2
			int size = board.getSize(); // size of board
			int addToX = dieTotal / size; // by how many X player moves forward
			int addToY = dieTotal % size; // by how many Y player moves forward
			int oldX = cPlayer.getX(); // X position before moving
			int oldY = cPlayer.getY(); // Y position before moving
			int oldLevel = cPlayer.getLevel(); // Level before moving
			int newLevel = 0; // Level after moving
			int newX = oldX + addToX; // X position after moving
			int newY = oldY + addToY; // Y position after moving
			int new_X = 0; // Adjusted X position (when off board) after moving
			int new_Y = 0; // Adjusted Y position (when off board) after moving

			// When player is on second last square on top level, player moves backwards
			if ((cPlayer.getLevel() == board.getLevel() - 1) && (cPlayer.getX() == board.getSize() - 1)
					&& (cPlayer.getY() == board.getSize() - 2)) {
				cPlayer.setX(cPlayer.getX() - ((dieTotal + 1) / size)); // X position after moving backwards
				cPlayer.setY(cPlayer.getY() - addToY); // Y position after moving backwards
				// Adjusted Y position (when off board) after moving backwards
				if (cPlayer.getY() <= 0) {
					cPlayer.setY(board.getSize() - 1);
				}

			}
			// Positioning player's new location after rolling dice
			else {
				// New X position
				if (newX < size) {
					cPlayer.setX(newX);
				}
				// New Y position
				if (newY < size) {
					cPlayer.setY(newY);
				}
				// Adjusting Y when off board
				if (newY >= size) {
					new_Y = newY % size;
					new_X = (1 + newX) % size;
					if (new_X == 0) {
						cPlayer.setLevel(oldLevel + 1);
						newLevel = cPlayer.getLevel();
					}
					cPlayer.setX(new_X);
					cPlayer.setY(new_Y);
					// When player goes off board, stays in original position and loses 2 energy
					// units
					if (newLevel >= board.getLevel()) {
						cPlayer.setEnergy(cPlayer.getEnergy() - 2);
						System.out.println(
								"!!! Sorry you need to stay where you are - that throw takes you off the grid and you\nlose 2 units of energy.");
						cPlayer.setLevel(oldLevel);
						cPlayer.setX(oldX);
						cPlayer.setY(oldY);
					}

				}
				// Adjusting X when off board
				if (newX >= size) {
					new_X = newX % size;
					cPlayer.setLevel(oldLevel + 1);
					newLevel = cPlayer.getLevel();
					// When player goes off board, stays in original position and loses 2 energy
					// units
					if (newLevel >= board.getLevel()) {
						cPlayer.setEnergy(cPlayer.getEnergy() - 2);
						System.out.println(
								"!!! Sorry you need to stay where you are - that throw takes you off the grid and you\nlose 2 units of energy.");
						cPlayer.setLevel(oldLevel);
						cPlayer.setX(oldX);
						cPlayer.setY(oldY);

					} else {
						cPlayer.setX(new_X);
					}
				}
				// Adjusting X and Y when both off board
				if (newY >= size && newX >= size) {
					new_Y = newY % size;
					new_X = (1 + newX) % size;
					cPlayer.setLevel(oldLevel + 1);
					newLevel = cPlayer.getLevel();
					// When player goes off board, stays in original position and loses 2 energy
					// units
					if (newLevel >= board.getLevel()) {
						cPlayer.setEnergy(cPlayer.getEnergy() - 2);
						System.out.println(
								"!!! Sorry you need to stay where you are - that throw takes you off the grid and you\nlose 2 units of energy.");
						cPlayer.setLevel(oldLevel);
						cPlayer.setX(oldX);
						cPlayer.setY(oldY);

					} else {
						cPlayer.setY(new_Y);
						cPlayer.setX(new_X);
					}

				}
			}
			// When current player's new location is occupied by other player
			if (cPlayer.equals(oPlayer)) {
				System.out.println("Player " + oPlayer.getName()
						+ " is at your new location\nWhat do you want to do?\n\t0 - Challenge and risk loosing 50% of your energy units if you loose \n\t       or move to new location and get 50% of other players energy units\n\t1 - to move down one level or move to (o,o) if at level 0 and lose 2 energy\nunits");
				int a = userInput.nextInt();
				while (a != 0 && a != 1) {
					System.out.println("Sorry but " + a + " is not a legal choice.");
					a = userInput.nextInt();
				}
				// When current player forfeits
				if (a == 1) {
					// When current player is on level 0, moves back to square (0,0), other player
					// is not affected
					if (cPlayer.getLevel() == 0) {
						cPlayer.setX(0);
						cPlayer.setY(0);
					}
					// Current player goes one level down and lose 2 energy units, other player is
					// not affected
					else if (cPlayer.getLevel() > 0) {
						cPlayer.setLevel(cPlayer.getLevel() - 1);
						cPlayer.setEnergy(cPlayer.getEnergy() - 2);
						turn++;

					}
				}
				// When current player challenges
				if (a == 0) {
					int challenge = rand.nextInt(11);
					// When current player loses challenge, stays where he is originally and loses
					// half of his energy units
					if (challenge < 6) {
						cPlayer.setEnergy(cPlayer.getEnergy() - (cPlayer.getEnergy() / 2));
						System.out.println(
								"!!! Sorry you need to stay where you are - you lost the challenge and you lose half of your energy units.");
						cPlayer.setLevel(oldLevel);
						cPlayer.setX(oldX);
						cPlayer.setY(oldY);
						turn++;

					}
					// When current player wins challenge, current player takes over other player's
					// location and wins half of other player's energy, while other player takes
					// over current player's previous location and loses half of his energy units
					else {
						System.out.println("Bravo!! You won the challenge.");
						cPlayer.moveTo(oPlayer);
						oPlayer.setLevel(oldLevel);
						oPlayer.setX(oldX);
						oPlayer.setY(oldY);
						cPlayer.setEnergy(cPlayer.getEnergy() + (oPlayer.getEnergy() / 2));
						oPlayer.setEnergy(oPlayer.getEnergy() - (oPlayer.getEnergy() / 2));
						turn++;

					}
				}
			}
			// Displaying location details of current player including energy adjustment
			// values
			System.out.println("\tYour energy is adjusted by "
					+ board.getEnergyAdj(cPlayer.getLevel(), cPlayer.getX(), cPlayer.getY()) + " for landing at ("
					+ cPlayer.getX() + "," + cPlayer.getY() + ") at level " + cPlayer.getLevel());
			// Adjusting energy units of current player
			cPlayer.setEnergy(
					cPlayer.getEnergy() + (board.getEnergyAdj(cPlayer.getLevel(), cPlayer.getX(), cPlayer.getY())));

			turn++;
			// Other player's turn
			if (cPlayer == p0) {
				cPlayer = p1;
				oPlayer = p0;
			} else if (cPlayer == p1) {
				cPlayer = p0;
				oPlayer = p1;
			}

			// Displaying summary of each round
			if (turn >= 2) {

				System.out.print("\nAt the end of this round:\n\t" + oPlayer.toString() + "\n\t" + cPlayer.toString());
				turn = 0;
				if (!cPlayer.won(board) && !oPlayer.won(board)) {
					System.out.print("\nAny key to continue to next round ...");
					userInput.next();
					System.out.print("\n");
				}
			}

		}
		// Displaying winner of game
		if (cPlayer.won(board))

		{
			System.out.println(
					"\n\nThe winner is player " + cPlayer.getName() + ". Well done and good game!!! *applause*");
		} else if (oPlayer.won(board)) {
			System.out.println(
					"\n\nThe winner is player " + oPlayer.getName() + ". Well done and good game!!! *applause*");
		}
		System.out.println("");
		userInput.close();
	}

}
