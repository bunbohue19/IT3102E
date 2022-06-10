package lab01;

import java.util.Scanner;

public class Operators {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String strNum1, strNum2;
		System.out.println("Enter the first number:");
		strNum1 = scanner.nextLine();
		System.out.println("Enter the second number:");
		strNum2 = scanner.nextLine();
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		System.out.println("Sum: " + (num1 + num2));
		System.out.println("Difference: " + (num1 - num2));
		System.out.println("Product: " + (num1 * num2));
		System.out.println("Quotient: " + (num1 / num2));
	}
	
}
