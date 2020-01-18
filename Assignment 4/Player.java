//This program defines a class named Player for properties and methods related to players in a board game
public class Player {
	// Declaring attributes
	private String name;
	private int level;
	private int x;
	private int y;
	private int energy;

	// 1st constructor - Default
	public Player() {
		name = "";
		energy = 10;
		level = 0;
		x = 0;
		y = 0;
	}

	// 2nd constructor - representing a player's name
	public Player(String playerName) {
		name = playerName;
		energy = 10;
		level = 0;
		x = 0;
		y = 0;
	}

	// 3rd constructor - representing a location
	public Player(int newLevel, int newX, int newY) {
		level = newLevel;
		x = newX;
		y = newY;
		energy = 10;
		name = "";

	}

	// Copy constructor
	public Player(Player player) {
		this.name = player.name;
		this.level = player.level;
		this.x = player.x;
		this.y = player.y;
		this.energy = player.energy;
	}

	// Mutator methods
	public void setName(String newName) {
		name = newName;
	}

	public void setLevel(int newLevel) {
		level = newLevel;
	}

	public void setX(int newX) {
		x = newX;
	}

	public void setY(int newY) {
		y = newY;
	}

	public void setEnergy(int newEnergy) {
		energy = newEnergy;
	}

	// Accessor methods
	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getEnergy() {
		return energy;
	}

	// Moving calling player to passed player object's location
	public void moveTo(Player p) {
		setLevel(p.getLevel());
		setX(p.getX());
		setY(p.getY());
	}

	// When player is at last location of board
	public boolean won(Board b) {
		int l = b.getLevel();
		int x = b.getSize();
		b = new Board(l, x);

		if (this.level == (b.getLevel() - 1) && this.x == (b.getSize() - 1) && this.y == (b.getSize() - 1)) {
			return true;

		} else {
			return false;
		}

	}

	// when both players' locations are the same
	public boolean equals(Player p) {
		return this.level == p.getLevel() && this.x == p.getX() && this.y == p.getY();
	}

	// Displaying player's values of all attributes
	public String toString() {
		return name + " is on level " + level + " at location (" + x + "," + y + ")" + " and has " + energy
				+ " units of energy.";
	}

}
