public class Enemy extends Character {
  protected int atkDamage;
  protected int difficulty;

  public Enemy(String name, int health, int accuracy, int atkDamage, int difficulty) {
    super(name, health, accuracy);
    this.atkDamage = atkDamage;
    this.difficulty = difficulty;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public int getAtkDamage() {
    return atkDamage;
  }

  public void increaseAttack(int amount) {
    atkDamage += amount;
  }

  public void displayEnemy() {
    System.out.println("Name: " + name);
    System.out.println("Health: " + health);
    System.out.println("Attack Damage: " + atkDamage);
    System.out.println("Accuracy: " + accuracy);
    System.out.println("Difficulty: "  + difficulty);
    System.out.println("\n");
  }
}