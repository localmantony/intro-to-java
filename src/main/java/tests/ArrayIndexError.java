import java.util.ArrayList;
import java.util.Scanner;

class ArrayIndexError {
  public static void main(String[] args) {
    ArrayList<String> choices = new ArrayList<>();
    choices.add("coffee");
    choices.add("tea");
    choices.add("water");
    System.out.println("1. " + choices.get(0));
    System.out.println("2. " + choices.get(1));
    System.out.println("3. " + choices.get(2));

    Scanner input = new Scanner(System.in);
    System.out.print("Enter a selection #: ");
    int selection = input.nextInt();
    int index = selection - 1;
    if(index >= 0 && index < choices.size()) {
      System.out.println("You selected " + choices.get(selection -1) + ".");
    }
    else {
      System.out.println("Not valid");
    }
  }
}