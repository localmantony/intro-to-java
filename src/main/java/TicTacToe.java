import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {


  public static void main(String[] args) {
    
    String[][] board = new String[3][3];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = " - ";
      }
    }

    printBoard(board);
    
  Scanner input = new Scanner(System.in);
      int col;
      int row;

      // for loop to provide 5 rounds of turns
      for(int turn = 0; turn < 5; turn++) {
        // X's turn
        System.out.print("X - Select column (1 - 3) & select row (1 - 3) ");
        System.out.print("separated by a space: ");
        col = input.nextInt();
        row = input.nextInt();
        if(board[row - 1][col - 1].equals(" - ")) {
          board[row - 1][col - 1] = " X ";
        }
        else {
          System.out.println("Sorry, that spot is taken.");
        }
        printBoard(board);
        // If 5th turn, end loop after X's turn - only 9 spaces to fill 
        if(turn == 4) {
          break;
        }

        // O's turn
        System.out.print("O - Select column (1-3) & select row (1-3) ");
        System.out.print("separated by a space: ");
        col = input.nextInt();
        row = input.nextInt();
        if(board[row - 1][col - 1].equals(" - ")) {
          board[row - 1][col - 1] = " O ";
        }
        else {
          System.out.println("Sorry, that spot is taken.");
        }
        printBoard(board);
      }
    }
  public static void printBoard(String[][] board) {
    for (int i=0; i < 3; i++) {
      System.out.println("\t" + Arrays.toString(board[i]));
    }
    System.out.println("\n");
  }
}