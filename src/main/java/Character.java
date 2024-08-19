public class Character {
  protected String name;
  protected int health;
  protected int accuracy;
  
  public Character(String name, int health, int accuracy) {
    this.name = name;
    this.health = health;
    this.accuracy = accuracy;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public int getAccuracy() {
    return accuracy;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setAccuracy(int accuracy) {
    this.accuracy = accuracy;
  }
  
  public void loseHealth(int amount) {
    health -= amount;
  }

  
  public void attack(Character target, int atkDamage) {
    target.loseHealth(atkDamage);
  }
}