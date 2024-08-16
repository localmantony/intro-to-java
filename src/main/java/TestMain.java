import java.util.Scanner; // needed for user input

public class TestMain {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);   // initialize scanner object named input

    int playerHealth = 100;
    int enemyHealth = 100;
    int playerAtkDamage = 20;
    int enemyAtkDamage = 15;
    
    System.out.println("\nWelcome to the battle arena!\n");

    while(true) {
      if (playerHealth > 0) {  //code will execute as long as player is alive
        System.out.println("Your turn.");
        System.out.println("The enemy's health is at " + enemyHealth + ". \n\nChoose a number for your move. \n\n1. Attack"); // show enemy status then user moves
        if(input.nextInt() == 1){ 
          System.out.println("\nAttacking the enemy!\n");
          enemyHealth -= playerAtkDamage;   // enemy health is lowered by the players AtkDamage
          System.out.println("Success! The enemy's health is now at " + enemyHealth + ".\n");  // show status of enemy after attack
          System.out.println("Press Enter to end your turn.");
          input.nextLine();
          input.nextLine();
        }
        
      } else {
        System.out.println("You are dead. Game over.");
        break;
      }
      
      if (enemyHealth > 0) {  // code will execute as long as enemy is alive
        System.out.println("\n\n------------------------------------\n\n");
        System.out.println("Enemy turn.");
        System.out.println("The enemy has chosen to attack!\n");
        playerHealth -= enemyAtkDamage;
        System.out.println("Your health is now at " + playerHealth + ".\n\n"); 
        System.out.println("--------------------------------------\n\n");
      }
      else {
        System.out.println("The enemy is dead! You win!");
        break;
      }
    }
  }
}