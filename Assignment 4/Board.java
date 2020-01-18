//This program defines a class named Board for properties and methods related to a board game
public class Board {
	// Declaring attributes
	private int[][][] board;
	private static final int MIN_LEVEL = 3;
	private static final int MIN_SIZE = 3;
	private int level;
	private int size;

	// Accessor method
	public int getLevel() {
		return level;
	}

	public int getSize() {
		return size;
	}

	// 1st Constructor - Default
	public Board() {
		level = 3;
		size = 4;
		createBoard(level, size);
	}

	// 2nd Constructor
	public Board(int l, int x) {
		level = l;
		size = x;
		if (l < MIN_LEVEL && x < MIN_SIZE) {
			System.exit(0);
		} else {
			createBoard(l, x);
		}
	}

	// Creating 3D array board and initializing each location to the following
	// values
	public void createBoard(int l, int x) {
		int y = x;

		board = new int[l][x][y];
		for (int i = 0; i < l; i++) {

			for (int j = 0; j < x; j++) {

				for (int k = 0; k < x; k++) {
					if (i + j + k == 0) {
						board[i][j][k] = 0;
					} else if ((i + j + k) % 3 == 0) {
						board[i][j][k] = -3;
					} else if ((i + j + k) % 5 == 0) {
						board[i][j][k] = -2;
					} else if ((i + j + k) % 7 == 0) {
						board[i][j][k] = 2;
					} else {
						board[i][j][k] = 0;
					}
				}
			}
		}

	}

	// Energy adjustment value stored in specific locations in array board
	public int getEnergyAdj(int l, int x, int y) {
		return board[l][x][y];
	}

	// Displaying energy adjustments values for each board at each level
	public String toString() {
		String s = "Your 3D board has been set up and looks like this:\n";
		for (int i = 0; i < getLevel(); i++) {
			if (i == 0) {
				s += "\nLevel " + i + "\n--------";
			} else {
				s += "\n\nLevel " + i + "\n--------";
			}
			for (int j = 0; j < getSize(); j++) {
				s += "\n";
				s += "       ";
				for (int k = 0; k < getSize(); k++) {
					s += board[i][j][k] + "\t";

				}
			}
		}
		return s;
	}
}
