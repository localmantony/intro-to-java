import java.util.Scanner;
import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    String[] cheeseTypes = {"Cheddar", "Swiss", "Gouda", "American", "Mozzarella"};
    int[] cheeseScores = new int[5];
    Scanner input = new Scanner(System.in);
    System.out.println("In a moment you'll give scores out of 10 to 5 different types of cheeses. Here are your candidates " + Arrays.toString(cheeseTypes));
    Arrays.sort(cheeseTypes);
    System.out.println("Sorted: " + Arrays.toString(cheeseTypes));
    System.out.println("Don't mind me just doing some testing.");
    int[] numbas = {39, 130, 49, 41, 20};
    
    System.out.println("Initial numbas: " + Arrays.toString(numbas));
    int loc20 = Arrays.binarySearch(numbas, 20);
    System.out.println("Index of 20 before the sort: " + loc20);
    Arrays.sort(numbas);
    System.out.println("Sorted scores: " + Arrays.toString(numbas));
    System.out.println("Index of 20 after the sort: " + loc20);
    int numbaSize = numbas.length;
    System.out.println("Array size: " + numbaSize);
    System.out.println("Lowest in the numbas: " + numbas[0]);
    System.out.println("Highest in the numbas: " + numbas[numbaSize -1]);   
    int[] topThree = Arrays.copyOfRange(numbas, numbas.length - 3, numbas.length);
    System.out.println("Top 3 numbas: " + Arrays.toString(topThree));
    
      
    }
}