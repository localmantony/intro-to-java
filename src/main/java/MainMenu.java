import java.util.Scanner;

public class MainMenu {
  Scanner scanner = new Scanner(System.in);
  
  public void callMainMenu() {
    while(true) {
      System.out.println("\nBATTLE ARENA\n");
      System.out.println("Choose a number: \n");
      System.out.println("1. Start Game\n2. Edit Character\n3. View Enemies\n4. Quit");
      
      switch (scanner.nextInt()) {
        case 1: 
          Game newGame = new Game();
          newGame.play();
          break;
        case 2:
          break;// logic for character editor
        case 3:
          break;// logic for viewing enemies
        case 4:
          break;
      }
      scanner.nextLine();
    }
  }
}