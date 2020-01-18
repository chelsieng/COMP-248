//This program defines a class named CPU for properties and methods related to an Intel CPU
public class CPU {
	private int generation; // CPU generation
	private String series; // CPU series
	private double price; // suggested price in USD
	private double speed; // CPU speed in GHz
	private String launchDate; // launch date of CPU with quarter and year
	private boolean software; // if CPU supports Intel Software Guard Extension (SGX)

	// 1st constructor
	public CPU() {
		generation = 1;
		series = "i3";
		price = 117.00;
		speed = 2.93;
		launchDate = "Q1'10";
		software = false;
	}

	// 2nd constructor
	public CPU(int newGeneration, String newSeries, double newPrice, double newSpeed, String newLaunchDate,
			boolean newSoftware) {
		generation = newGeneration;
		series = newSeries;
		price = newPrice;
		speed = newSpeed;
		launchDate = newLaunchDate;
		software = newSoftware;
	}

	// Accessor methods to return value of each variable
	public int getGeneration() {
		return generation;
	}

	public String getSeries() {
		return series;
	}

	public double getPrice() {
		return price;
	}

	public double getSpeed() {
		return speed;
	}

	public String getLaunchDate() {
		return launchDate;
	}

	public boolean getSoftware() {
		return software;
	}

	// Mutator method to set suggested price
	public void setPrice(int newPrice) {
		price = newPrice;
	}

	// estimating price of CPU based on supplied quarter/year
	public double priceNow(String sQuarterYear) {
		int quarter = Integer.parseInt(sQuarterYear.charAt(1) + ""); // extracting quarter from supplied quarter/year
		int year = Integer.parseInt(sQuarterYear.substring(3, sQuarterYear.length())); // extracting year from supplied
																						// quarter/year

		int launchQuarter = Integer.parseInt(launchDate.charAt(1) + ""); // extracting quarter from launch date
		int launchYear = Integer.parseInt(launchDate.substring(3, launchDate.length())); // extracting year from launch
																							// date

		int numberOfQuarter = quarter - launchQuarter; // calculating number of quarters
		int numberOfYear = year - launchYear; // calculating number of years

		// price when supplied quarter/year is before the launch date of CPU
		if (year < launchYear || year == launchYear && quarter <= launchQuarter) {
			return price;
		}

		// price after launch date
		return price * Math.pow(0.98, numberOfYear * 4 + numberOfQuarter);

	}

	// toString() method returning all the values of CPU object
	public String toString() {
		if (software == true) {
			return "This CPU is " + generation + "th generation " + series + " (" + speed + "GHz), launched: "
					+ launchDate + " with price: " + String.format("%.2f", price) + " USD. SGX is supported.";
		} else {
			return "This CPU is " + generation + "th generation " + series + " (" + speed + "GHz), launched: "
					+ launchDate + " with price: " + String.format("%.2f", price) + " USD. SGX is not supported.";
		}

	}

	// equals() method testing for equality of two CPU objects based on generation,
	// series and SGX support
	public boolean equals(CPU anotherCPU) {
		return this.generation == anotherCPU.getGeneration() && this.series == anotherCPU.getSeries()
				&& this.software == anotherCPU.getSoftware();

	}

	// isHigherGeneration() method comparing two CPU objects based on their
	// generations
	public boolean isHigherGeneration(CPU anotherCPU) {
		return this.generation > anotherCPU.getGeneration();
	}

	// Manipulating constructors, accessors, mutators and methods
	public static void main(String[] args) {
		CPU cpu1 = new CPU(); // using first constructor
		CPU cpu2 = new CPU(10, "i9", 449.00, 3.1, "Q2'19", true); // using second constructor

		System.out.println("Welcome to the simple class example! \n");

		// Testing toString() method
		System.out.println("CPU 1: " + cpu1);
		System.out.println("CPU 2: " + cpu2);

		// Testing accessor method
		System.out.println("CPU 1 Series: " + cpu1.getSeries());
		System.out.println("CPU 1 Suggested price: " + String.format("%.2f", cpu1.getPrice()) + " USD");

		// Testing mutator method
		cpu1.setPrice(110);
		System.out.println(
				"CPU 1 Suggested price (after mutator call): " + String.format("%.02f", cpu1.getPrice()) + " USD");

		// Testing equals() method
		System.out.print("Are CPU 1 and CPU 2 equal? ");
		if (cpu1.equals(cpu2)) {
			System.out.println("YES");
		} else
			System.out.println("NO");

		// Testing isHigherGeneration() method
		System.out.print("Is CPU 1 of higher generation than CPU 2? ");
		if (cpu1.isHigherGeneration(cpu2)) {
			System.out.println("YES");
		} else
			System.out.println("NO");

		// Calculating current price for both objects
		System.out.println("CPU 1 Price at Q3'19 :" + String.format("%.2f", cpu1.priceNow("Q3'19")) + " USD");
		System.out.println("CPU 2 Price at Q3'19 :" + String.format("%.2f", cpu2.priceNow("Q3'19")) + " USD");

		System.out.println("\nThank you for testing the simple class example!");
	}
}
