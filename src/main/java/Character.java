public class Character {

  // enemies and players will both have names, health, and accuracy
  protected String name;
  protected int health;
  protected int accuracy;

  // parameterized constructor
  public Character(String name, int health, int accuracy) {
    this.name = name;
    this.health = health;
    this.accuracy = accuracy;
  }

  //getters and setters

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


  // character attacks target, use weapon atkDamage or enemy atkDamage for atk
  public void attack(Character target, int atk) {
    target.setHealth(target.getHealth() - atk);
  }
}