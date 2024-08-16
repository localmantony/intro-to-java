public class Character {
  private String name;
  private int atkDamage;
  private int health;
  private int accuracy;


  public Character(String name, int difficulty, int atkDamage, int health) {
    this.name = name;
    this.difficulty = difficulty;
    this.atkDamage = atkDamage;
    this.health = health;
    this.accuracy = accuracy;
  }

  public String getName() {
    return name;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public int getAtkDamage() {
    return atkDamage;
  }

  public int getHealth() {
    return health;
  }

  public int getAccuracy() {
    return accuracy;
  }

  public void loseHealth(int amount) {
    health -= amount;
  }

  
  public void attack(Character target, int atkDamage) {
    target.loseHealth(atkDamage);
  }
}