import java.util.Arrays;

class score2DArray {
  public static void main(String[] args) {
    int[][] scores = {
      {348, 235, 453, 621},
      {354, 234, 235, 123},
      {93, 123, 265, 134}
    };
    System.out.println("Array with Arrays.toString: " + Arrays.toString(scores));
    System.out.println("Array with Arrays.deeptoString: " + Arrays.deepToString(scores));
  }
}