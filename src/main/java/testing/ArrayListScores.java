import java.util.ArrayList;

class ArrayListScores {
  public static void main(String[] args) {
    ArrayList<Integer> scores = new ArrayList<Integer>();
    scores.add(99);
    int listLength = scores.size();
    System.out.println("Last score: " + scores.get(listLength - 1));
  }
}
