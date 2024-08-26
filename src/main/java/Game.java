import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Game {
  Scanner scanner = new Scanner(System.in);
  ConsoleMethods clean = new ConsoleMethods();  // new object from console methods to keep console clean

  public void play(Player player, int difficulty) {
    Scanner input = new Scanner(System.in);
    ArrayList<Enemy> inGameEnemies = initializeEnemies(difficulty); // enemies are picked randomly such that all enemy difficulties add up to the total difficulty

    System.out.println("\nWelcome to the battle arena, " + player.getName() + "!\n");

    boolean playing = true;  // game ends when this is false
    boolean playersTurn = true;  // start with player turn
    boolean enemyTurn = false;  // enemy turn will need to be enabled after player turn
    int turnAmount = 1;  //  default 1 turn, certain items can bring amount above one
    
    while (playing) {
      while (turnAmount > 0) {
        playersTurn = true;  // sets to false at end of loop, needs to be reset if turnAmount > 2
        while(playersTurn) { 
          // visual cue to the player if they're about to have multiple turns
          if (turnAmount > 1) {  
            System.out.println("The player will go "+ turnAmount +" times.\n");  
          }
          System.out.println("PLAYER TURN\n");
          System.out.println("Current Enemies: \n");
          showEnemyState(inGameEnemies);   // lists all the players still in the game
          showPlayerState(player);   // shows player name, health, weapons
          System.out.println("Choose your move: \n");
          System.out.println("1. Attack\n2. Attempt to talk it out with the enemies\n3. Do nothing\n");
          String playerMove = scanner.nextLine();  // strings easier to validate input 
          switch(playerMove) {   // combine with switches and cases to make for easy input validation
            case "1":  // attack - list weapons to attack with
              clean.clear();  // user input clears console for a clean interface
              boolean choosingWeapon = true;
              boolean weaponChosen = false;
              while(choosingWeapon) {
                // list player's weapons
                System.out.println("Which weapon would you like to attack with?\n");
                System.out.println("1. " + player.getWeapon1().getName());
                System.out.println("2. " + player.getWeapon2().getName());
                System.out.println("\n3. Return to previous page\n");
                String attackChoice = scanner.nextLine();

                // nested switch for deep menus
                switch(attackChoice) {
                  case "1": // primary weapon - set as active
                    clean.clear();  // user input clears console for a clean interface
                    player.setActiveWeapon(player.getWeapon1());
                    choosingWeapon = false;  // break current menu
                    weaponChosen = true;  // triggers if statement below to begin attacks
                    break;
                  case "2": // tactical weapon - set as active and reduce lifespan 
                    clean.clear();  // user input clears console for a clean interface
                    if (player.getWeapon2().getLifespan() > 0) {
                      player.setActiveWeapon(player.getWeapon2());
                      player.getWeapon2().reduceLifespan();  // tactical weapons have a lifespan
                      choosingWeapon = false;
                      weaponChosen = true;
                      break;
                    }
                    else {  // let the user know when their weapons lifespan is depleted
                      System.out.println("No more " + player.getWeapon2().getName() + "s to throw!\n");
                      clean.pressEnterTo("continue");
                      break;
                    }
                  case "3": //return to previous
                    clean.clear();           // clear console before returning to previous menu
                    choosingWeapon = false;  // exits current menu
                    break;
                  default: // all other inputs for ATTACK CHOICE lead to error message
                    clean.inputError(3);
                    break;
                }
                
              }

              // amount of enemies is dynamic, can't use switches and cases
              if (weaponChosen) {
                // attack for each amount of weapon speed
                for (int i = 0; i < player.getActiveWeapon().getSpeed(); i++) {
                  if (player.getActiveWeapon() == player.getWeapon1()) {  // if attacking with primary
                    int enemyIndex = -1;
                    boolean validEnemyChoice = false;  // initialize input validation for below loop
                    
                    // list all enemies, await a valid input
                    while (!validEnemyChoice) {
                      System.out.println("Attack number " + (i+1) + ":\n");
                      System.out.println("Which Enemy would you like to attack?\n");
                      showEnemyState(inGameEnemies);
                    
                      System.out.print("Choose a number: ");
                      
                      if (scanner.hasNextInt()) {  // Check if the input is an integer
                        enemyIndex = scanner.nextInt();
                        
                        // input is valid if within range of listed enemies
                          if (enemyIndex > 0 && enemyIndex <= inGameEnemies.size()) {
                              validEnemyChoice = true;
                          }
                          else {
                             clean.inputError(inGameEnemies.size());
                             scanner.next();
                          }
                        } 
                        else {
                          clean.inputError(inGameEnemies.size());
                          scanner.next(); // consume the invalid input
                        }
                    }
                    scanner.nextLine();  // consumes the new line created by nextInt()
                    clean.clear();       // once valid choice is true, clear console
                    Enemy chosenEnemy = inGameEnemies.get(enemyIndex - 1);  // actual index is one less than what's displayed to player

                    // uses player accuracy to attempt an attack and check for enemy deaths
                    tryPlayerAttack(player, chosenEnemy, inGameEnemies);
                    if (allEnemiesDead(inGameEnemies)) {
                      playersTurn = false;  // current turn ends
                      turnAmount = 0;       // prevent extra turn (smoke triggered)
                      i = player.getActiveWeapon().getSpeed();  // prevent getting stuck in loop if weapon speed allows for 2nd attack
                      playing = false;      // ends main game loop
                    }
                  clean.pressEnterTo("continue");  // pause after attack and death check
                  }
                  else if (player.getActiveWeapon().getName() == "bomb") {  // if current weapon is bomb
                    for (Enemy enemy : inGameEnemies) {  // for each enemy in the game
                      player.attack(enemy, player.getActiveWeapon().getAtkDamage()); // attack with current weapon attack damage
                    }
                    System.out.println(player.getName() + " threw a bomb. All enemies in the battlefield took " + player.getActiveWeapon().getAtkDamage() + " damage!\n"); // notify player what happened
                    // cannot iterate through a list that changes; create a copy to iterate through
                    ArrayList<Enemy> enemyCopy = new ArrayList<>(inGameEnemies);
                    // iterate through enemies and damage each one
                    for (Enemy enemy : enemyCopy) {
                      if (isDead(enemy)) {
                        enemyDie(enemy, inGameEnemies);
                        if (allEnemiesDead(inGameEnemies)) {
                          playersTurn = false;
                          turnAmount = 0;
                          playing = false;
                          i = player.getActiveWeapon().getSpeed();  // prevent from looping again so player isn't prompted for move after everyone's dead
                        }
                      }
                    }
                    clean.pressEnterTo("continue");
                  }
                  else if (player.getActiveWeapon().getName() == "smoke" ) {
                    System.out.println(player.getName() + " threw a smoke! The enemies are confused and " + player.getName() + " will go twice in a row!\n");
                    turnAmount = 2 + 1; // set to one above desired because turn amount will be reduced at end of current turn. 
                    clean.pressEnterTo("continue");
                  } 
                }
                // switch to enemy's turn as long as they're not all dead and player has no turns left after loop ends
                if (turnAmount <= 1 & !allEnemiesDead(inGameEnemies)) {
                  enemyTurn = true;
                }
                clean.clear();  // added to remove extra text from above check on allEnemiesDead
                playersTurn = false; // ends current turn, player may still go again if turnAmount > 2
              }
              break;
            case "2": // speak to the enemies
              clean.clear();  // user input clears console for a clean interface
              System.out.println("What would you like to say to the enemies?\n");
              String chat = scanner.nextLine();
              clean.clear();  // clear screen after user enters chat to enemies

              // humorous: player attempts to descalate situation but actually make things worse
              System.out.println("You take a deep breath and scream at the top of your lungs, \""+ chat.toUpperCase() + "!\"\n");
              System.out.println("The enemies don't appreciate your tone. They are angrier now and each enemy's attack damage has increased by 5.\n");

              // each enemy's attack increases by 5
              for (Enemy enemy : inGameEnemies) {
                enemy.increaseAttack(5);
              }
              clean.pressEnterTo("begin enemy turn");

              // enemy turn now, player turn ends
              enemyTurn = true;  
              playersTurn = false;
              break;

            case "3": // do nothing
              clean.clear();  // user input clears console for a clean interface
              System.out.println("You chose to... do nothing... interesting. Your turn is over now.\n");
              clean.pressEnterTo("continue");
              enemyTurn = true;
              playersTurn = false;
              break;
            default: // all other inputs for PLAYER MOVE lead to input error
              clean.inputError(3);  
            }
        }
      turnAmount -= 1; // reduce turnAmount after each turn, logic above ensures player goes again if above 0
      }
      
      while(enemyTurn) {
        clean.clear();  // user input clears console for a clean interface
        System.out.println("ENEMY TURN\n");

        // each enemy's accuracy tested on a player attack
        for (Enemy enemy : inGameEnemies) {
          tryEnemyAttack(enemy, player);
          if (isDead(player)) {  // put player isDead check inside loop to prevent multiple enemies attacking dead player
            break;
          }
        }
        if (isDead(player)) {
          System.out.println(player.getName() + " is dead! The game is over.\n");
          playing = false;    // end game prompts commence once enemyTurn loops breaks
          enemyTurn = false;  // breaks enemyTurn loop, prevents below code, 
          clean.pressEnterTo("continue");
        }
        // player's turn as long as player is not dead
        else {
          clean.pressEnterTo("continue");
          playersTurn = true;
          turnAmount = 1;
          enemyTurn = false;
        }
        
      }
    }
    boolean choosingEnd = true;
    while(choosingEnd) {
      System.out.println("GAME OVER\n\nPlay again with current character?\n");
      System.out.println("Choose a number: \n");
      System.out.println("1. Yes - Launch Main Menu");
      System.out.println("2. No - End Game\n");
      String endGameChoice = scanner.nextLine();
      switch(endGameChoice) {
        case "1": {  // yes - launch main menu
          clean.clear();  // user input clears console for a clean interface
          player.setHealth(100); // reset user health if game restarting
          MainMenu mainMenu = new MainMenu();  // gives ability to call main menu
          Weapons weapons = new Weapons();  // gives ability to get list of all weapons, not just player's current ones

          // callMainMenu takes lists of Weapons as arguments
          Weapons[] primaryWeapons = weapons.getPrimaryWeapons();
          Weapons[] tacticalWeapons = weapons.getTacticalWeapons();

          // reset lifespan back to 1 in case used in battle
          player.getWeapon2().setLifespan(1); 
            
          // launches main menu with current player name and weapons
          mainMenu.callMainMenu(player, primaryWeapons, tacticalWeapons);
          choosingEnd = false;  // break current menu
          break;
        }
        case "2": { // no - end game
          System.out.println("Goodbye.");
          clean.clear();
          choosingEnd = false;  // break current menu
          break;  // breaks current loop, code stops running
        }
        default:  // all other inputs for END GAME lead to input errors
          clean.inputError(2);
      }
    }
  }
  
  // print all currently alive enemies
  public void showEnemyState(ArrayList<Enemy> enemies) {
    int enemyCount = 0;
    // for each enemy - print "Enemy name - X Health"
    for (Enemy enemy : enemies) {
      System.out.println((enemyCount + 1) + ". " + enemy.getName() + " - " + enemy.getHealth() + " health");
      enemyCount ++;
    }
    System.out.print("\n");
  }

  // player accuracy tested against a random number, if it passes, attack is successful
  public void tryPlayerAttack(Player attacker, Enemy target, ArrayList<Enemy> inGameEnemies) {
    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;  // +1 shifts range from 0-99 to 1-100
    System.out.println(attacker.getName() + " tries to attack " + target.getName() + " with their " + attacker.getActiveWeapon().getName() + "...\n");

    // the higher the accuracy, the higher the likely hood this if statement will run
    if (attacker.accuracy > randomNumber) {
      
      // attack with current weapons attack damage
      attacker.attack(target, attacker.getActiveWeapon().getAtkDamage());

      // notify the player if attack hits or misses
      System.out.println("The attack hits! " + target.getName() + " lost " + attacker.getActiveWeapon().getAtkDamage() + " health.\n");  
    } else {
      System.out.println("The attack misses!\n");
    }
    if (isDead(target)) {
      enemyDie(target, inGameEnemies);
    }
  }

  // separate method for enemy attacks because they don't have weapons
  public void tryEnemyAttack(Enemy attacker, Player target) {
    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;
    System.out.print(attacker.getName() + " tries to attack " + target.getName() + "... ");

    // attack lands if accuracy check passes
    if (attacker.accuracy > randomNumber) {
      attacker.attack(target, attacker.getAtkDamage());
      System.out.println("The attack hits! " + target.getName() + " lost " + attacker.getAtkDamage() + " health. ");
    } else {
      System.out.println("The attack misses! ");
    }
   System.out.println(attacker.getName() + "'s turn is over.\n");
  }

  // simple check for death, works on players and enemies
  public boolean isDead(Character character) {
    if (character.getHealth() < 1) {  // character is dead when health is 0 or below
      return true;
    }
    else {
      return false;  // if character isn't dead, returns false
    }
  }

  // list player name, health, and weapons before every turn
  public void showPlayerState(Player player) {
    System.out.print(player.getName() + "'s health: " + player.getHealth());
    System.out.print("  |  Primary Weapon: " + player.getWeapon1().getName());
    System.out.println("  |  Tactical Weapon: " + player.getWeapon2().getName() + "\n");
  }

  // remove enemy from main arrayList of current enemies
  public void enemyDie(Enemy enemy, ArrayList<Enemy> inGameEnemies) {
    System.out.println(enemy.getName() + " is dead!\n");
    inGameEnemies.remove(enemy);
  }

  // when the last enemy is removed from arrayList, all enemies are dead
  // lists current enemies left as well
  public boolean allEnemiesDead(ArrayList<Enemy> inGameEnemies) {
    if (inGameEnemies.size() == 0) {
      System.out.println("All enemies are dead! You win!\n");
      return true;       
    }
    else if (inGameEnemies.size() > 1) {
      System.out.println(inGameEnemies.size() + " enemies remain\n");
      return false;
    }
    else {
      System.out.println("1 enemy remains!\n");  // grammar is different for a single remaining enemy
      return false;
    }
  }

  // randomize enemies based on passed difficulty
  public ArrayList<Enemy> initializeEnemies(int totalDifficulty) {
    Random random = new Random();  // access to random methods

    // reference enemies to build off of
    Minion baseMinion = new Minion("Minion"); 
    Striker baseStriker = new Striker("Striker");
    Warden baseWarden = new Warden("Warden");

    // will add enemies once initialized 
    ArrayList<Enemy> availableEnemies = new ArrayList<>(List.of(baseMinion, baseStriker, baseWarden));

    // keep lists separate initially to organize by subclass
    ArrayList<Enemy> minions = new ArrayList<>();
    ArrayList<Enemy> strikers = new ArrayList<>();
    ArrayList<Enemy> wardens = new ArrayList<>();

    while (totalDifficulty > 0) {
      switch (random.nextInt(availableEnemies.size())) { // picks a random number from 1 to (size of arrayList)
        case 0: 
          // as long as enemy difficulty can fit inside totalDifficulty, add em to the list
          if (totalDifficulty >= baseMinion.getDifficulty()) {
            Minion minion = new Minion("Minion " + (minions.size() + 1)); //names Minion 1, Minion 2...
            minions.add(minion);  // add to arraylist of minions
            totalDifficulty -= minion.getDifficulty();  // subtract enemy difficulty from total
            break;
          } else {
            totalDifficulty = 0;  // if total difficulty is smaller than the enemy with the least difficulty, no more enemies can be added, loop must end
            break;
          }
         case 1:
          // repeat above for strikers
          if (totalDifficulty >= baseStriker.getDifficulty()) {
            Striker striker = new Striker("Striker " + (strikers.size() + 1)); // names striker 1, striker 2 ...
            strikers.add(striker);
            totalDifficulty -= striker.getDifficulty();  // subtract enemy difficulty from total
            break;
          } else {
            availableEnemies.remove(baseStriker); // total difficulty too low for strikers now, remove from available enemies
            break;
          }
         case 2:
          if (totalDifficulty >= baseWarden.getDifficulty()) {
            Warden warden = new Warden("Warden " + (wardens.size() + 1)); // names warden 1, warden 2...
            wardens.add(warden);
            totalDifficulty -= warden.getDifficulty();  // subtract enemy difficulty from total
            break;
          } else {
            availableEnemies.remove(baseWarden);  // total difficulty too low for wardens now, remove from available enemies
            break;
          }
      }
    }
    ArrayList<Enemy> enemyList = new ArrayList<>();  // final list to be returned

    // combine all enemy lists into single list
    enemyList.addAll(minions);
    enemyList.addAll(strikers);
    enemyList.addAll(wardens);

    return enemyList;  // return combined list
  }
} 