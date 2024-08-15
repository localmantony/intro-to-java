import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
  public static void main(String[] args){
    int col;
    int row;
    Scanner input = new Scanner(System.in);

    String[][] board = {{" - ", " - ", " - "},
                        {" - ", " - ", " - "},
                        {" - ", " - ", " - "}};  
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");
    System.out.print("X - Select row (0 - 2) & select column (0 - 2) ");
    System.out.print("separated by a space: "); 
    row = input.nextInt();
    col = input.nextInt();
    board[row][col] = " X ";
    System.out.println("\t" + Arrays.toString(board[0]));
    System.out.println("\t" + Arrays.toString(board[1]));
    System.out.println("\t" + Arrays.toString(board[2]) + "\n");
    }
  }
