import java.util.HashMap;
import java.util.Scanner;

public class ScoresHashMap {
  public static void main(String[] args) {
    HashMap<String, Integer> scores = new HashMap<>();
    scores.put("Steve", 90);
    scores.put("Tom", 70);
    scores.put("Mike", 40);
    System.out.println("Scores: " + scores.toString());

    Scanner input = new Scanner(System.in);

    System.out.print("Enter a player: ");
    String playerChosen = input.nextLine();
    if (scores.containsKey(playerChosen)) {
      System.out.println(playerChosen + "'s score was " + scores.get(playerChosen));
      
    }
    else {
      System.out.println("Player doesn't exist.");
    }
  }
}