package costa_p2;

import java.util.Scanner;

public class BMICalculator {
	
	private float weight;
	private float height;
	private float bmi;
	private String bmi_category;
	private int formula_choice; // 1 or 2.

	public void readUserData() {
		// Reads user data.
		
		Scanner input = new Scanner(System.in);
		
		readUnitType(input);
		readMeasurementData(this.formula_choice, input);
	}
	
	private void readUnitType(Scanner input) {
		// Asks the user which formula he'd like to use.
		
		do {
			System.out.println("Choose which formula metrics to use:");
			System.out.println("[1] Pounds and Inches.");
			System.out.println("[2] Kilograms and Meters.");
			System.out.print("Type 1 or 2: ");
			this.formula_choice = input.nextInt();
			
			if (this.formula_choice != 1 && this.formula_choice != 2) {
				System.out.print("\nPlease, enter a valid choice. Try again.\n\n");
			}
			
		}while (this.formula_choice != 1 && this.formula_choice != 2);
	}
	
	private void readMeasurementData(int choice, Scanner input) {
		// Reads the user's measurement data based on the formula choice.
		if(choice == 1) {
			readImperialData(input);
		}else {
			readMetricData(input);
		}
	}
	
	private void readMetricData(Scanner input) {
		// Gets information in kilograms and meters.
		
		System.out.print("Enter your weight (kilograms): ");
		float weight = input.nextFloat();
		
		if (weight < 0) {
			System.out.println("Negative weight entered. Exiting the program...");
			setWeight(0);
			return;
		}else {
			setWeight(weight);
		}
		
		System.out.print("Enter your height (meters): ");
		float height = input.nextFloat();
		
		
		if(height < 0) {
			System.out.println("Negative height entered. Exiting the program...");
			setHeight(0);
			return;
		}else {
			setHeight(height);
		}
	}
	
	private void readImperialData(Scanner input) {
		// Gets information in pounds and inches.
	
		System.out.print("Enter your weight (pounds): ");
		float weight = input.nextFloat();
		
		if (weight < 0) {
			System.out.println("Negative weight entered. Exiting the program...");
			setWeight(0);
			return;
		}else {
			setWeight(weight);
		}
		
		System.out.print("Enter your height (inches): ");
		float height = input.nextFloat();
		
		if(height < 0) {
			System.out.println("Negative height entered. Exiting the program...");
			setHeight(0);
			return;
		}else {
			setHeight(height);
		}
	}
	
	public void calculateBmi() {
		// Calculates the user's BMI and BMI category. 
		
		if (this.getWeight() == 0 || this.getHeight() == 0) {
			// Exit the program. The user entered negative values for either or both.
			System.out.println("A negative height or/and weight was/were entered. "
					+ "'calculateBmi()' cannot be used right now. Exiting the program...");
			return;
		}else {
		
			if (this.formula_choice == 1) {
				// Use the imperial formula.
				this.bmi = (703 * this.weight) / (this.height * this.height);
			}else {
				// Use the metric formula.
				this.bmi = this.weight / (this.height * this.height);
			}
			
			// Calculating the BMI category.
			calculateBmiCategory();
		}
	}
	
	private void calculateBmiCategory() {
		// Determines the user's BMI category.
		if(this.bmi < 18.5) {
			this.bmi_category = "Underweight";
			
		}else if ( (this.bmi >= 18.5) && (this.bmi <= 24.9) ) {
			this.bmi_category = "Normal weight";
			
		}else if ( (this.bmi >= 25) && (this.bmi <= 29.9) ) {
			this.bmi_category = "Overweight";
			
		}else {
			this.bmi_category = "Obesity";
		}
	}
	
	public void displayBmi() {
		if (this.getWeight() == 0 || this.getHeight() == 0) {
			// Exit the program. The user entered negative values for either or both.
			System.out.println("A negative height or/and weight was/were entered. "
					+ "'displayBmi()' cannot be used right now. Exiting the program...");
			return;
		}else {
			// Prints the BMI value and category to standard output.
			System.out.println("|---------------------------|");
			System.out.printf("Your BMI: %.2f\n", this.bmi);
			System.out.printf("Your BMI category: %s\n", this.bmi_category);
			System.out.println("|---------------------------|");
			System.out.println("BMI CATEGORIES FOR YOU TO COMPARE:");
			System.out.println("Underweight = <18.5");
			System.out.println("Normal weight = 18.5–24.9");
			System.out.println("Overweight = 25–29.9");
			System.out.println("Obesity = BMI of 30 or greater");
			System.out.println("|---------------------------|");
		}
	}
	
	// Getters and Setters.
	public float getWeight() {
		return this.weight;
	}
	
	private void setWeight(float weight) {
		this.weight = weight;
	}
	
	public float getHeight() {
		return this.height;
	}
	
	private void setHeight(float height) {
		this.height = height;
	}
	
	public float getBmi() {
		return this.bmi;
	}
	
	public String getBmiCategory() {
		return this.bmi_category;
	}
}

// -- PSEUDOCODE --
/*
 * readUserData()
 * 		readUnitType()
 * 			Prompt the user about his/her choice of formula.
 * 			(Keep asking until a valid choice is entered).		
 * 
 * 		readMeasurementData()
 * 			readImperialData() OR readMetricData() based on the user's choice of formula.
 * 				Set the user's weight and height with their respective setters.
 * 
 * 
 * calculateBmi() // Will calculate BMI based on the user's choice of formula.
 * 		calculateBmiCategory()
 * 
 * 
 * displayBmi() 
 * 		// Displays the user's BMI and BMI category + all the categories.
 * */

