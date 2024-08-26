import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);      // initialize user input object 
    ConsoleMethods clean = new ConsoleMethods();  // initialize object for clean user interface
    Weapons weapons = new Weapons();             // initialize weapons to pass into main menu

    // get primary and tactical weapons as lists to pass into main menu method
    Weapons[] primaryWeapons = weapons.getPrimaryWeapons();
    Weapons[] tacticalWeapons = weapons.getTacticalWeapons();

    // player is initialize with sword and bomb by default
    Weapons[] defaultWeapons = {primaryWeapons[0], tacticalWeapons[0]};

    //player name is Player 1, option to change in main menu
    Player player1 = new Player("Player 1", defaultWeapons);

    
    MainMenu mainMenu = new MainMenu();  // instantiate in order to use callMainMenu()
    clean.clear();  // clear any existing console text
    System.out.println("\nWelcome to the Battle Arena\n");
    System.out.println("For the best experience, maximize your console window\n");
    clean.pressEnterTo("Launch Main Menu");
    mainMenu.callMainMenu(player1, primaryWeapons, tacticalWeapons);
    
  }

}