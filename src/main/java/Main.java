import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    Weapons[] primaryWeapons = new Weapons[2];
    Weapons[] tacticalWeapons = new Weapons[2];
    
    String swordInfo = "Primary Weapon - Heavy hitter";
    String bowInfo = "Primary Weapon - Lighter attack damage, but quick. Allows for two attacks in a single turn.";
    String bombInfo = "Tactical - Deals damage to all enemies on the board. One time use.";
    String smokeInfo = "Tactical - Confuses enemies and grants an additional turn to the player. Deals no damage. One time use.";
    
    primaryWeapons[0] = new Weapons("sword", 50, 1, -1, swordInfo);
    primaryWeapons[1] = new Weapons("bow", 25, 2, -1, bowInfo);
    tacticalWeapons[0] = new Weapons("bomb", 30, 1, 1, bombInfo);
    tacticalWeapons[1] = new Weapons("smoke", 50, 1, 1, smokeInfo);

    Weapons[] defaultWeapons = {primaryWeapons[0], tacticalWeapons[0]};

    Player player1 = new Player("Player 1", defaultWeapons);
    
    MainMenu mainMenu = new MainMenu();
    MainMenu.clear();
    System.out.println("\nWelcome to the Battle Arena");
    System.out.println("\nPress Enter to Launch the Main Menu.\n");
    scanner.nextLine();
    MainMenu.clear();
      
    mainMenu.callMainMenu(player1, primaryWeapons, tacticalWeapons);
    
  }

}