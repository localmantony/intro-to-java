import java.util.Scanner;

class Loops {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("While loop runs if score is greater than 100");
    int score = 0;
    while (score < 100) {
      System.out.print("Enter a number to add to the score. ");
      score += input.nextInt();
      System.out.println("score = " + score);
    }
    System.out.println("loop exited");
    
    System.out.println("\nThis for loop counts to 5: ");
    for (int count = 1; count <=5; count++) {
      System.out.println(count);
    }
    System.out.println("for loop complete");

    String textToAdd = "";
    String text = "";

    while(!textToAdd.equalsIgnoreCase("quit")) {
      System.out.println("\nEnter words to add, more than 4 letters ignored, quit to stop");
      textToAdd = input.nextLine();
      if (textToAdd.length() > 4) {
        continue;
      }
      text += textToAdd + " ";
      
    }
    System.out.println("\n" + text);
  }
}