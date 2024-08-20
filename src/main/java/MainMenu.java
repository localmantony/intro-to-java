import java.util.Scanner;
  

public class MainMenu {
  Scanner scanner = new Scanner(System.in);

  public void callMainMenu(Player player, Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {

    boolean inMainMenu = true;
    while(inMainMenu) {
      System.out.println("\nMAIN MENU\n");
      System.out.println("Choose a number: \n");
      System.out.println("1. Start Game\n2. Edit Character\n3. View Enemies \n4. Quit\n");
      
      switch (scanner.nextLine()) {
        case "1": 
          clear();
          Game newGame = new Game();
          System.out.println("Choose a difficulty: ");
          System.out.println("1. Easy\n2. Medium \n3. Hard");
          
          switch (scanner.nextLine()) {
            case "1":
              System.out.println("Beginning game on easy mode");
              newGame.play(player, 50);
              break;
            case "2":
              System.out.println("Beginning game on medium mode");
              newGame.play(player, 100);
              break;
            case "3":
              System.out.println("Beginning game on hard mode");
              newGame.play(player, 150);
              break;
            default:
              inputError(3);
              break;
          }
        case "2":
          clear();
          editCharacter(player, primaryWeapons, tacticalWeapons);
          break;
        case "3":
          clear();
          viewEnemies();
          break;
        case "4":
          clear();
          inMainMenu = false;
          break;
        default:
          clear();
          inputError(4);
          break;
      }
    }
    System.out.println("\nGoodbye.\n");
  }

  public void editCharacter(Player player, Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {
    boolean inCharacterEditor = true;
    while(inCharacterEditor) {
      System.out.println("\nCHARACTER EDITOR\n");
      System.out.println("Current Character Configuration: \n");
      player.displayPlayer();
      
      System.out.println("\n\nChoose a number: \n");
      System.out.println("1. Edit Name\n2. Edit Weapons\n3. Return to Main Menu\n");

      switch (scanner.nextLine()) {
        case "1":
          clear();
          System.out.println("\nEnter your character's new name\n");
          String newName = scanner.nextLine();
          player.setName(newName);
          clear();
          System.out.println("\nCharacter name set to : " + player.getName());
          break;
        case "2":
          clear();
          editWeapons(player, primaryWeapons, tacticalWeapons);
          break;
        case "3":
          clear();
          inCharacterEditor = false;
          break;
        default:
          clear();
          inputError(3);
          break;
      }
    }
  }
  
  public void editWeapons(Player player, Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {
    boolean inWeaponEditor = true;
    while(inWeaponEditor) {
      System.out.println("\nWEAPON EDITOR\n");
      System.out.println("Current Primary Weapon: " + player.getWeapon1().getName());
      System.out.println("Current Tactical Weapon: " + player.getWeapon2().getName());
      System.out.println("\n\nChoose a number: \n");
      System.out.println("1. Change Primary\n2. Change Tactical\n3. View Weapon Details\n4. Return to Character Editor\n");

      switch (scanner.nextLine()) {
        case "1":
          clear();
          boolean choosingPrimary = true;
          boolean priChanged = false;
          while(choosingPrimary) {
            System.out.println("\n\nChoosing primary weapon. Choose a number: \n");
            System.out.println("1. Sword\n2. Bow\n3. Return to Previous Screen\n");
            switch(scanner.nextLine()) {
              case "1":
                clear();
                player.setWeapon1(primaryWeapons[0]);
                choosingPrimary = false;
                priChanged = true;
                break;
              case "2":
                clear();
                player.setWeapon1(primaryWeapons[1]);
                choosingPrimary = false;
                priChanged = true;
                break;
              case "3":
                clear();
                choosingPrimary = false;
                break;
              default:
                clear();
                inputError(3);
                break;  
              }
            }
          clear();
          if (priChanged) {
            System.out.println("Primary weapon set to: " + player.getWeapon1().getName());
          }
          break;

        case "2":
          clear();
          boolean choosingTactical = true;
          boolean tacChanged = false;
          while(choosingTactical) {
            System.out.println("\n\nChoosing tactical weapon. Choose a number: \n");
            System.out.println("1. Bomb\n2. Smoke\n3. Return to Previous Screen \n");
            switch(scanner.nextLine()) {
                case "1":
                  clear();
                  player.setWeapon2(tacticalWeapons[0]);
                  choosingTactical = false;
                  tacChanged = true;
                  break;
                case "2":
                  clear();
                  player.setWeapon2(tacticalWeapons[1]);
                  choosingTactical = false;
                  tacChanged = true;
                  break;
                case "3":
                  clear();
                  choosingTactical = false;
                  break;
                default:
                  clear();
                  inputError(3);
                  break;  
            }
          }
          clear();
          if (tacChanged) {
            System.out.println("Tactical Weapon set to: " + player.getWeapon2().getName());
          }
          break;
        case "3":
          clear();
          viewWeapons(primaryWeapons, tacticalWeapons);
          break;
        case "4":
          clear();
          inWeaponEditor = false;
          break;
        default:
          clear();
          inputError(4);
          break;
      }
    }
    
  }
  
  public void viewWeapons(Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {
    boolean viewingWeapons = true;
    while(viewingWeapons) {
      System.out.println("\nWEAPONS\n");
      System.out.println("Choose a number to view weapon details:\n");
      System.out.println("Primary Weapons\n1. Sword\n2. Bow\n");
      System.out.println("Tactical Weapons\n3.Bomb\n4.Smoke");
      System.out.println("\n5. Return to Weapon Editor\n");
      switch(scanner.nextLine()) {
        case "1":
          clear();
          System.out.println(primaryWeapons[0].getName().toUpperCase() + "\n");
          primaryWeapons[0].displayWeapon();
          System.out.println("\nPress Enter to Return to Weapons Viewer");
          scanner.nextLine();
          clear();
          break;
        case "2":
          clear();
          System.out.println(primaryWeapons[1].getName().toUpperCase() + "\n");
          primaryWeapons[1].displayWeapon();
          System.out.println("\nPress Enter to Return to Weapons Viewer");
          scanner.nextLine();
          clear();
          break;
        case "3":
          clear();
          System.out.println(tacticalWeapons[0].getName().toUpperCase() + "\n");
          tacticalWeapons[0].displayWeapon();
          System.out.println("\nPress Enter to Return to Weapons Viewer");
          scanner.nextLine();
          clear();
          break;
        case "4":
          clear();
          System.out.println(tacticalWeapons[1].getName().toUpperCase() + "\n");
          tacticalWeapons[1].displayWeapon();
          System.out.println("\nPress Enter to Return to Weapons Viewer");
          scanner.nextLine();
          clear();
          break;
        case "5":
          clear();
          viewingWeapons = false;
          break;
        default:
          clear();
          inputError(5);
          break;
      }               
    }
    
  }
  
  public void viewEnemies() {
    boolean viewingEnemies = true;
    while(viewingEnemies) {
      System.out.println("\nLIST OF ENEMIES\n");
      System.out.println("Select a number to learn more about the Enemy:\n\n1. Minion\n2. Striker \n3. Warden\n\n4. Return to Main Menu\n");
      switch (scanner.nextLine()) {
        case "1":
          clear();
          System.out.println("MINION\n");
          Minion displayMinion = new Minion("Minion");
          displayMinion.displayEnemy();
          System.out.println("Press Enter to return to List of Enemies");
          scanner.nextLine();
          clear();
          break;
        case "2":
          clear();
          System.out.println("STRIKER\n");
          Striker displayStriker = new Striker("Striker");
          displayStriker.displayEnemy();
          System.out.println("Press Enter to return to List of Enemies");
          scanner.nextLine();
          clear();
          break;
        case "3":
          clear();
          System.out.println("WARDEN\n");
          Warden displayWarden = new Warden("Warden");
          displayWarden.displayEnemy();
          System.out.println("Press Enter to return to List of Enemies");
          scanner.nextLine();
          clear();
          break;
        case "4":
          clear();
          viewingEnemies = false;
          break;
        default:
          clear();
          inputError(4);
          break;
      }
    }  
  }
  
  public void inputError(int options) {
    System.out.print("Invalid input. Please enter ");
    for (int i = 1; i < options; i++) {
     System.out.print(i + ", ");
    }
    System.out.println("or " + options + "." );   
    }

  // clears the shell to make viewing Menus cleaner and easier
  public static void clear() {
      try {
          // Execute the 'clear' command on Linux/Unix/MacOS
          new ProcessBuilder("clear").inheritIO().start().waitFor();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}