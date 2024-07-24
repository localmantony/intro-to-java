import java.util.Arrays;

public class TicTacToe {
  public static void main(String[] args) {
    String[][] board = {
    {" - ", " - ", " - "},
    {" - ", " - ", " - "},
    {" - ", " - ", " - "}
    }; 

    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]));
  }
}