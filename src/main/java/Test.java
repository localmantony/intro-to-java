import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int anger = 5;
		while (anger < 10) {
			System.out.println("Simple test. Please ignore and do not type any numbers");
			try {
				int mult = userInput.nextInt();
				System.out.println("I'm getting angrier. Please STOP typing numbers.");
				anger++;

			}
			catch (Exception ex) {
				System.out.println("You sure you don't want to type any numbers?");
				int mult = userInput.nextInt();
			}
		}		
	}
}
