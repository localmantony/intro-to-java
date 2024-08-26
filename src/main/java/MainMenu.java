import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
  

public class MainMenu {
  Scanner scanner = new Scanner(System.in);
  ConsoleMethods clean = new ConsoleMethods();

  public void callMainMenu(Player player, Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {

    boolean inMainMenu = true;
    while(inMainMenu) {
      
      // display main menu options to player
      System.out.println("MAIN MENU\n");
      System.out.println("Hello, " + player.getName() + "\n");
      System.out.println("Choose a number: \n");
      System.out.println("1. Start Game\n2. Edit Character\n3. View Enemies \n\n4. Quit\n");

      // switch cases for easy readability on menu options
      String mainMenuChoice = scanner.nextLine();
      switch (mainMenuChoice) {
        
        case "1": // (Start Game) display difficulty options
          clean.clear();
          boolean choosingDifficulty = true;
          while (choosingDifficulty) {
            System.out.println("Choose a difficulty: \n");
            System.out.println("1. Easy\n2. Medium \n3. Hard\n\n4. Return to Main Menu\n");

            Game newGame = new Game();  // instantiate Game object in order to call play() method
            switch (scanner.nextLine()) {
                
              // each choice breaks out of main menu and starts new game with corresponding difficulty  
              case "1":  // easy
                clean.clear();  // clear console after user input
                inMainMenu = false;  // break out of main menu when game starts
                choosingDifficulty = false;
                newGame.play(player, 50); // pass player object, which has weapons as attributes, along with difficulty
                break;  // prevent fall through to next options
              case "2":  // medium
                clean.clear();
                inMainMenu = false;
                choosingDifficulty = false;
                newGame.play(player, 100); // medium corresponds to 100 difficulty
                break;
              case "3":  // hard
                clean.clear();
                inMainMenu = false;
                choosingDifficulty = false;
                newGame.play(player, 150); // hard corresponds to 150 difficulty
                break;
              case "4":  // return to main menu
                clean.clear();
                choosingDifficulty = false; // break current menu but dont break main menu, return to main menu
                break;
              default:  // all other inputs for DIFFICULTY CHOOSER lead to error message
                clean.inputError(4);
                break;
            }
          }
          break;

 
        case "2": //(edit character) launch character editor
          clean.clear();
          editCharacter(player, primaryWeapons, tacticalWeapons);
          break;

        
        case "3":  // (view enemies) launch enemy viewer
          clean.clear();
          viewEnemies();
          break;

        case "4": // (quit) launch quitting dialogue
          clean.clear();

          // offer the option to quit but warn that character info is erased
          boolean quitting = true;
          while (quitting) {
            System.out.println("Are you sure you want to quit? All character data will be lost.\n");
            System.out.println("1. Yes - Quit Game");
            System.out.println("2. No - Return to Main Menu\n");
            switch(scanner.nextLine()) {
              case "1":  // yes, quit
                clean.clear();
                System.out.println("Goodbye.");
                quitting = false;  // break current menu
                inMainMenu = false;  // break main menu and end code 
                break;
              case "2":  // no, return to MM
                clean.clear();
                quitting = false;
                break;
              default:  // all other inputs for QUITTING DIALOG produce error message
                clean.inputError(2);
                break;
            }
          }
          break;
          
        default: // all other inputs for MAIN MENU produce error
          clean.inputError(4);
          break;
      }
    }
  }

  // allows player to edit name, view health and accuracy, edit and view weapons
  public void editCharacter(Player player, Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {
    boolean inCharacterEditor = true;
    while(inCharacterEditor) {
      // display title and options for character editor
      System.out.println("CHARACTER EDITOR\n");
      System.out.println("Current Character Configuration: \n");
      player.displayPlayer();
      
      System.out.println("\n\nChoose a number: \n");
      System.out.println("1. Edit Name\n2. Edit Weapons\n\n3. Return to Main Menu\n");

      switch (scanner.nextLine()) {
        case "1": // (edit name) ask to enter new name
          clean.clear();
          System.out.println("\nEnter your character's new name\n");
          String newName = scanner.nextLine();
          player.setName(newName);
          clean.clear();
          System.out.println("\nCharacter name set to: " + player.getName() + "\n");
          break;
        case "2": // (edit weapons) launch weapon editor
          clean.clear();
          editWeapons(player, primaryWeapons, tacticalWeapons);
          break;
        case "3": // (return to MM) 
          clean.clear();
          inCharacterEditor = false; // break current menu
          break;
        default: // all other inputs for CHARACTER EDITOR lead to error message, menu re-displays
          clean.inputError(3);
          break;
      }
    }
  }
  
  // allows player to enter the game with their choice of primary and tactical weapons
  // pass the player because weapons are a player attribute, and pass lists of primary and tactical weapons
  public void editWeapons(Player player, Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {
    boolean inWeaponEditor = true;
    while(inWeaponEditor) {
      
      // display title and options for weapon editor
      System.out.println("WEAPON EDITOR\n");
      System.out.println("Current Primary Weapon: " + player.getWeapon1().getName());
      System.out.println("Current Tactical Weapon: " + player.getWeapon2().getName());
      System.out.println("\n\nChoose a number: \n");
      System.out.println("1. Change Primary\n2. Change Tactical\n3. View Weapon Details\n\n4. Return to Character Editor\n");

      String weaponMenuChoice = scanner.nextLine();
      switch (weaponMenuChoice) {
        case "1": // (change primary) display primary weapon options
          clean.clear();
          boolean choosingPrimary = true;
          boolean priChanged = false;  // if primary is selected, user notified
          while(choosingPrimary) {
            // display primary weapons to user
            System.out.println("\n\nChoosing primary weapon. Choose a number: \n");
            System.out.println("1. Sword\n2. Bow\n\n3. Return to Previous Screen\n");
            String primaryChoice = scanner.nextLine();
            switch(primaryChoice) {
              case "1": // (sword) set primary to sword
                clean.clear();
                player.setWeapon1(primaryWeapons[0]); // sword is index 0 in primaryWeapons
                choosingPrimary = false;              // break current menu
                priChanged = true;
                break;
              case "2":  // (bow) set primary to bow
                clean.clear();  
                player.setWeapon1(primaryWeapons[1]); // bow is index 1 in primaryWeapons
                choosingPrimary = false;              // break current menu
                priChanged = true;
                break;
              case "3":  // (return to previous)
                clean.clear();
                choosingPrimary = false;              // break current menu, dont set priChanged to true
                break;
              default:  // all other inputs for PRIMARY WEAPON CHOOSER lead to error message
                clean.inputError(3);
                break;  
              }
            }
          clean.clear();
          // lets the user know at the top of the weapon editor that change was made
          if (priChanged) {
            System.out.println("Primary weapon set to: " + player.getWeapon1().getName() + "\n");
          }
          break;

        case "2":  // change tactical - same logic as above
          clean.clear();
          boolean choosingTactical = true;
          boolean tacChanged = false;
          while(choosingTactical) {
            System.out.println("\n\nChoosing tactical weapon. Choose a number: \n");
            System.out.println("1. Bomb\n2. Smoke\n\n3. Return to Previous Screen \n");
            switch(scanner.nextLine()) {
                case "1": // bomb - set tac weapon to bomb
                  clean.clear();
                  player.setWeapon2(tacticalWeapons[0]);  // bomb is index 0 on tacticalWeapons
                  choosingTactical = false; // break current menu
                  tacChanged = true;  // to trigger if statement below
                  break;
                case "2":  // smoke- set tac weapon to smoke
                  clean.clear();
                  player.setWeapon2(tacticalWeapons[1]); // smoke is index 1 on tacticalWeapons
                  choosingTactical = false;
                  tacChanged = true;
                  break;
                case "3": // return to previous
                  clean.clear();
                  choosingTactical = false;
                  break;
                default:  // all other inputs for TACTICAL WEAPON CHOOSER lead to error message
                  clean.inputError(3);
                  break;  
            }
          }
          clean.clear();
          // let user know at top of weapon menu that change was made
          if (tacChanged) {
            System.out.println("Tactical Weapon set to: " + player.getWeapon2().getName() + "\n");
          }
          break;
        case "3":  // (view weapon details) launch weapon viewer 
          clean.clear();
          viewWeapons(primaryWeapons, tacticalWeapons);
          break;
        case "4": // return to previous
          clean.clear();
          inWeaponEditor = false;
          break;
        default:  // all other inputs for WEAPON EDITOR lead to error message
          clean.inputError(4);
          break;
      }
    }
    
  }

  // allows the user to view all weapons available and make an informed decision on what to pick 
  public void viewWeapons(Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {
    boolean viewingWeapons = true;
    while(viewingWeapons) {
      System.out.println("\nWEAPONS\n");
      System.out.println("Choose a number to view weapon details:\n");
      System.out.println("Primary Weapons\n1. Sword\n2. Bow\n");
      System.out.println("Tactical Weapons\n3. Bomb\n4. Smoke");
      System.out.println("\n5. Return to Weapon Editor\n");
      
      switch(scanner.nextLine()) {
        // case for each choice, puts name in all caps at the top, displayWeapon() gets weapon stats
        case "1":  // sword
          clean.clear();
          System.out.println(primaryWeapons[0].getName().toUpperCase() + "\n");  // for consistency with other menus
          primaryWeapons[0].displayWeapon();
          clean.pressEnterTo("return to weapons list");
          break;
        case "2":  // bow
          clean.clear();
          System.out.println(primaryWeapons[1].getName().toUpperCase() + "\n");
          primaryWeapons[1].displayWeapon();
          clean.pressEnterTo("return to weapons list");
          break;
        case "3":  // bomb
          clean.clear();
          System.out.println(tacticalWeapons[0].getName().toUpperCase() + "\n");
          tacticalWeapons[0].displayWeapon();
          clean.pressEnterTo("return to weapons list");
          break;
        case "4":  // smoke
          clean.clear();
          System.out.println(tacticalWeapons[1].getName().toUpperCase() + "\n");
          tacticalWeapons[1].displayWeapon();
          clean.pressEnterTo("return to weapons list");
          break;
        case "5":  // return to weapon editor
          clean.clear();
          viewingWeapons = false;
          break;
        default: // all other inputs for WEAPON VIEWER lead to error message
          clean.inputError(5);
          break;
      }               
    }
    
  }

  // view details of all enemies
  public void viewEnemies() {
    boolean viewingEnemies = true;
    while(viewingEnemies) {
      System.out.println("\nLIST OF ENEMIES\n");
      System.out.println("Select a number to learn more about the Enemy:\n\n1. Minion\n2. Striker \n3. Warden\n\n4. Return to Main Menu\n");
      switch (scanner.nextLine()) {
        case "1": // minion
          clean.clear();
          System.out.println("MINION\n");
          Minion displayMinion = new Minion("Minion");
          displayMinion.displayEnemy();
          System.out.println("Minimal threat - Minions can be killed in one hit with any weapon.\n");
          clean.pressEnterTo("return to list of enemies");
          break;
        case "2": // striker
          clean.clear();
          System.out.println("STRIKER\n");
          Striker displayStriker = new Striker("Striker");
          displayStriker.displayEnemy();
          System.out.println("Medium strength enemy - Greater health, accuracy and attack damage than minions.\n");
          clean.pressEnterTo("return to list of enemies");
          break;
        case "3":  // warden
          clean.clear();
          System.out.println("WARDEN\n");
          Warden displayWarden = new Warden("Warden");
          displayWarden.displayEnemy();
          System.out.println("Formiddable foe - highly accurate. Not accesible on easy mode.\n");
          clean.pressEnterTo("return to list of enemies");
          break;
        case "4":  // return to previous
          clean.clear();
          viewingEnemies = false;
          break;
        default:  // all other inputs for ENEMY VIEWER lead to error message
          clean.inputError(4);
          break;
      }
    }  
  }
}
