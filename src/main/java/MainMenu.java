import java.util.Scanner;
  

public class MainMenu {
  Scanner scanner = new Scanner(System.in);

  public void callMainMenu(Player player, Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {

    boolean inMainMenu = true;
    while(inMainMenu) {
      System.out.println("\nMAIN MENU\n");
      System.out.println("Choose a number: \n");
      System.out.println("1. Start Game\n2. Edit Character\n3. View Enemies \n4. View Weapons\n5. Quit\n");
      
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
          clear()
          editCharacter(player, primaryWeapons, tacticalWeapons);
          break;
        case "3":
          break;// logic for viewing enemies
        case "4":
          break;// logic for viewing weapons
        case "5":
          clear()
          inMainMenu = false;
          break;
        default:
          inputError(5);
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

          System.out.println("\nCharacter name set to : " + player.getName());
          break;
        case "2":
          clear()
          editWeapons(player, primaryWeapons, tacticalWeapons);
          break;
        case "3":
          clear()
          inCharacterEditor = false;
          break;
        default:
          clear()
          inputError(3);
          break;
      }
      continue;
    }
  }
  public void editWeapons(Player player, Weapons[] primaryWeapons, Weapons[] tacticalWeapons) {
    boolean inWeaponEditor = true;
    while(inWeaponEditor) {
      System.out.println("WEAPON EDITOR");
      System.out.println("Current Primary Weapon: " + player.getWeapon1().getName());
      System.out.println("Current Tactical Weapon: " + player.getWeapon2().getName());
      System.out.println("\n\nChoose a number: \n");
      System.out.println("1. Change Primary\n2. Change Tactical\n3. Return to Previous Screen\n");

      switch (scanner.nextLine()) {
        case "1":
          clear();
          boolean choosingPrimary = true;
          while(choosingPrimary) {
            System.out.println("\n\nChoosing primary weapon. Choose a number: \n");
            System.out.println("1. Sword\n2. Bow\n\n3. Return to Previous Screen\n");
            switch(scanner.nextLine()) {
                case "1":
                  player.setWeapon1(primaryWeapons[0]);
                  choosingPrimary = false;
                  break;
                case "2":
                  player.setWeapon1(primaryWeapons[1]);
                  choosingPrimary = false;
                  break;
                case "3":
                  clear();
                  choosingPrimary = false;
                  break;
                default:
                  inputError(3);
                  break;  
              }
            clear();
            System.out.println("Primary weapon set to: " + player.Weapon1().getName());
            }

        case "2":
          clear();
          boolean choosingTactical = true;
          while(choosingTactical) {
            System.out.println("\n\nChoosing tactical weapon. Choose a number: \n");
            System.out.println("1. Bomb\n2. Smoke\n\n3. Return to Previous Screen \n");
            switch(scanner.nextLine()) {
                case "1":
                  player.setWeapon2(tacticalWeapons[0]);
                  choosingTactical = false;
                  break;
                case "2":
                  player.setWeapon2(tacticalWeapons[1]);
                  choosingTactical = false;
                  break;
                case "3":
                  choosingTactical = false;
                  break;
                default:
                  inputError(3);
                  break;  
            }
          }
          break;
        case "3":
          inWeaponEditor = false;
          break;
        default:
          inputError(3);
      }
    }
  }

  public void inputError(int options) {
    System.out.print("Incorrect input. Please enter ");
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