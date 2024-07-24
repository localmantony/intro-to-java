import java.util.ArrayList;
import java.util.Scanner;

class ForCountEven {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    Scanner input = new Scanner(System.in);
    int evenCount = 0;

    System.out.println("Enter numbers separated by commas. I'll tell you how many even numbers you enter. ");
    String userInput = input.nextLine();

    String[] numberStrings = userInput.split(",");

    for (String numberString : numberStrings) {
      int number = Integer.parseInt(numberString.trim());
      numbers.add(number);
    }
    
    for(int index = 0; index < numbers.size(); index++){
      if (numbers.get(index) % 2 ==0) {
        evenCount++;
      }
    }
    System.out.print("The array " + numbers.toString() + " ");
    System.out.println("contains " + evenCount + " even values.");
  }
}