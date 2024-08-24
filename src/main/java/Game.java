import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Game {
  Scanner scanner = new Scanner(System.in);
  ConsoleMethods clean = new ConsoleMethods();

  public void play(Player player, int difficulty) {
    Scanner input = new Scanner(System.in);
    ArrayList<Enemy> inGameEnemies = initializeEnemies(difficulty);

    System.out.println("\nWelcome to the battle arena, " + player.getName() + "!\n");
    System.out.println("Current Enemies: \n");
    
    boolean playerTurn = true;
    boolean enemyTurn = false;
    
    while(playerTurn) {
      showEnemyState(inGameEnemies);
      System.out.println("Choose your move: \n");
      System.out.println("1. Attack\n2. Attempt to talk it out with the enemies\n3. Do nothing\n");
      switch(scanner.nextLine()) {
        case "1":
          clean.clear();
          boolean choosingWeapon = true;
          while(choosingWeapon) {
              System.out.println("Which weapon would you like to attack with?\n");
              System.out.println("1. " + player.getWeapon1().getName());
              System.out.println("2. " + player.getWeapon2().getName());
              System.out.println("\n3. Return to previous page");
              switch(scanner.nextLine()) {
                case "1":
                  clean.clear();
                  player.setActiveWeapon(player.getWeapon1());
                  choosingWeapon = false;
                  break;
                case "2":
                  clean.clear();
                  player.setActiveWeapon(player.getWeapon2());
                  choosingWeapon = false;
                  break;
                case "3":
                  clean.clear();
                  choosingWeapon = false;
                  break;
              }
            }
          for (int i = 0; i < player.getActiveWeapon().getSpeed(); i++) {
            System.out.println("Attack number " + (i+1) + ":");
            System.out.println("Which Enemy would you like to attack?\n");
            showEnemyState(inGameEnemies);
            int enemyIndex = scanner.nextInt();
            Enemy chosenEnemy = inGameEnemies.get(enemyIndex - 1);
            clean.clear();
              
            if (player.getActiveWeapon() == player.getWeapon1()) {  // if attacking with primary
              System.out.println("Attacking with Primary");
              tryPlayerAttack(player, chosenEnemy);
              if (isDead(chosenEnemy)) {
                enemyDie(chosenEnemy, inGameEnemies);
                if (allEnemiesDead(inGameEnemies)) {
                  playerTurn = false;
                }
              }
            } else if (player.getActiveWeapon().getName() == "bomb") {  // if current weapon is bomb
              for (Enemy enemy : inGameEnemies) {  // for each enemy in the game
                player.attack(enemy, player.getActiveWeapon().getAtkDamage()); // attack with current weapon attack damage
              }
              System.out.println(player.getName() + " threw a bomb. All enemies in the battlefield took " + player.getActiveWeapon().getAtkDamage() + " damage!");
              for (Enemy enemy : inGameEnemies) {
                if (isDead(enemy)) {
                  System.out.println(enemy.getName() + "is dead!");
                  inGameEnemies.remove(enemy);
                }
              }
            } else if (player.getActiveWeapon().getName() == "smoke" ) {
              System.out.println("Turns out " + player.getName() + " is a total wimp. They threw a smoke and fled from the arena. Great job everyone, you can all go home.");
            }
          }
            System.out.println("Press Enter to continue: ");
            scanner.nextLine();
            clean.clear();
            playerTurn = false;
            enemyTurn = true;
            break;
          case "2":
            clean.clear();
            System.out.println("What would you like to say to the enemies?");
            String chat = scanner.nextLine();
            clean.clear();
            System.out.println("You take a deep breath and scream at the top of your lungs, \""+ chat.toUpperCase() + "!\"\n");
            System.out.println("The enemies don't appreciate your tone. They are angrier now and each enemy's attack damage has increased by 5.\n");
            for (Enemy enemy : inGameEnemies) {
              enemy.increaseAttack(5);
            }
            System.out.println("Press Enter to continue");
            scanner.nextLine();
            clean.clear();
            playerTurn = false;
            enemyTurn = true;
            break;

          case "3":
            clean.clear();
            System.out.println("You chose to... do nothing... interesting. Your turn is over now.\n");
            System.out.println("Press Enter to continue");
            scanner.nextLine();
            clean.clear();
            playerTurn = false;
            enemyTurn = true;
            break;
        }
    }
    
    while(enemyTurn) {
      for (Enemy enemy : inGameEnemies) {
        tryEnemyAttack(enemy, player);
        if (isDead(player)) {
          break;
        }
      }
      if (isDead(player)) {
        System.out.println(player.getName() + " is dead! The game is over.");
        break;
      }
      enemyTurn = false;
      playerTurn = true;
    }
  }

  
  public void showEnemyState(ArrayList<Enemy> enemies) {
    int enemyCount = 0;
    for (Enemy enemy : enemies) {
      System.out.println((enemyCount + 1) + ". " + enemy.getName() + " - " + enemy.getHealth() + " health");
      enemyCount ++;
    }
    System.out.print("\n");
  }

  public void tryPlayerAttack(Player attacker, Enemy target) {
    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;
    System.out.println(attacker.getName() + " tries to attack " + target.getName() + " with their " + attacker.getActiveWeapon());
    if (attacker.accuracy > randomNumber) {
      attacker.attack(target, attacker.getActiveWeapon().getAtkDamage());
      System.out.println("The attack hits! " + target.getName() + " lost " + attacker.getActiveWeapon().getAtkDamage() + " health.");
    } else {
      System.out.println("The attack misses! ");
    }
  }
  
 public void tryEnemyAttack(Enemy attacker, Player target) {
    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;
    System.out.println(attacker.getName() + " tries to attack " + target.getName() + ".");
    
    if (attacker.accuracy > randomNumber) {
      attacker.attack(target, attacker.getAtkDamage());
      System.out.println("The attack hits! " + target.getName() + " lost " + attacker.getAtkDamage() + " health. ");
    } else {
      System.out.println("The attack misses! ");
    }
   System.out.println(attacker.getName() + "'s turn is over.");
  }

  public boolean isDead(Character character) {
    if (character.getHealth() < 1) {
      return true;
    }
    else {
      return false;
    }
  }

  public void enemyDie(Enemy enemy, ArrayList<Enemy> inGameEnemies) {
    System.out.println(enemy.getName() + " is dead!");
    inGameEnemies.remove(enemy);
  }

  public boolean allEnemiesDead(ArrayList<Enemy> inGameEnemies) {
    if (inGameEnemies.size() == 0) {
      System.out.println("All enemies are dead!");
      return true;       
    }
    else if (inGameEnemies.size() > 1) {
      System.out.println(inGameEnemies.size() + " enemies remain!");
      return false;
    }
    else {
      System.out.println("1 enemy remains!");
      return false;
    }
  }
  
  public ArrayList<Enemy> initializeEnemies(int totalDifficulty) {
    Random random = new Random();
    
    Minion baseMinion = new Minion("Minion");
    Striker baseStriker = new Striker("Striker");
    Warden baseWarden = new Warden("Warden");

    ArrayList<Enemy> availableEnemies = new ArrayList<>(List.of(baseMinion, baseStriker, baseWarden));
    
    ArrayList<Enemy> minions = new ArrayList<>();
    ArrayList<Enemy> strikers = new ArrayList<>();
    ArrayList<Enemy> wardens = new ArrayList<>();

    while (totalDifficulty > 0) {
      switch (random.nextInt(availableEnemies.size())) {
        case 0:
          if (totalDifficulty >= baseMinion.getDifficulty()) {
            Minion minion = new Minion("Minion " + (minions.size() + 1));
            minions.add(minion);
            totalDifficulty -= minion.getDifficulty();
            break;
          } else {
            totalDifficulty = 0;
            break;
          }
         case 1:
          if (totalDifficulty >= baseStriker.getDifficulty()) {
            Striker striker = new Striker("Striker " + (strikers.size() + 1));
            strikers.add(striker);
            totalDifficulty -= striker.getDifficulty();
            break;
          } else {
            break;
          }
         case 2:
          if (totalDifficulty >= baseWarden.getDifficulty()) {
            Warden warden = new Warden("Warden " + (wardens.size() + 1));
            wardens.add(warden);
            totalDifficulty -= warden.getDifficulty();
            break;
          } else {
            break;
          }
      }
    }
    ArrayList<Enemy> enemyList = new ArrayList<>();
    enemyList.addAll(minions);
    enemyList.addAll(strikers);
    enemyList.addAll(wardens);

    return enemyList;
  }
  
}