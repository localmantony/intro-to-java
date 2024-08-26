public class Enemy extends Character {
  protected int atkDamage;  // attack damage is an enemy trait, whereas players have weapons with attack damage
  protected int difficulty; // used when initializing game based on player chosen difficulty

  // parameterized constructor
  public Enemy(String name, int health, int accuracy, int atkDamage, int difficulty) {
    super(name, health, accuracy);  // from character class
    this.atkDamage = atkDamage;  
    this.difficulty = difficulty;
  }

  // getters for new attributes, no setters except for increaseAttack because no need for dynamic chagnge
  public int getDifficulty() {
    return difficulty;
  }

  public int getAtkDamage() {
    return atkDamage;
  }

  public void increaseAttack(int amount) {
    atkDamage += amount;
  }

  // display enemy traits in main menu when viewing enemies
  public void displayEnemy() {
    System.out.println("Name: " + name);
    System.out.println("Health: " + health);
    System.out.println("Attack Damage: " + atkDamage);
    System.out.println("Accuracy: " + accuracy);
    System.out.println("Difficulty: "  + difficulty);
    System.out.println("\n");
  }
}