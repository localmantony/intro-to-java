   import java.util.Arrays;
  import java.util.Scanner;

  public class TicTacToe {

      public static void main(String[] args) {
          String[][] board = new String[3][3];

          // Initialize the board with dashes
          for (int i = 0; i < board.length; i++) {
              for (int j = 0; j < board[i].length; j++) {
                  board[i][j] = " - ";
              }
          }

          printBoard(board);

          Scanner input = new Scanner(System.in);
          int col;
          int row;

          // Loop for 5 rounds of turns (10 moves total)
          for (int turn = 0; turn < 9; turn++) {
              // X's turn
              while (true) {
                  System.out.print("X - Select column (1-3) & select row (1-3) ");
                  System.out.print("separated by a space: ");
                  if (input.hasNextInt()) {
                      col = input.nextInt();
                      if (input.hasNextInt()) {
                          row = input.nextInt();
                          if (col >= 1 && col <= 3 && row >= 1 && row <= 3 && board[row - 1][col - 1].equals(" - ")) {
                              board[row - 1][col - 1] = " X ";
                              break;
                          }
                      }
                  }
                  System.out.println("Invalid input or spot taken. Please try again.");
                  input.nextLine(); // Clear the invalid input
              }
              printBoard(board);

              // If 5th turn, end loop after X's turn - only 9 spaces to fill
              if (turn == 4) {
                  break;
              }

              // O's turn
              while (true) {
                  System.out.print("O - Select column (1-3) & select row (1-3) ");
                  System.out.print("separated by a space: ");
                  if (input.hasNextInt()) {
                      col = input.nextInt();
                      if (input.hasNextInt()) {
                          row = input.nextInt();
                          if (col >= 1 && col <= 3 && row >= 1 && row <= 3 && board[row - 1][col - 1].equals(" - ")) {
                              board[row - 1][col - 1] = " O ";
                              break;
                          }
                      }
                  }
                  System.out.println("Invalid input or spot taken. Please try again.");
                  input.nextLine(); // Clear the invalid input
              }
              printBoard(board);
          }
      }

      public static void printBoard(String[][] board) {
          for (int i = 0; i < 3; i++) {
              System.out.println("\t" + Arrays.toString(board[i]));
          }
          System.out.println("\n");
      }
  }
