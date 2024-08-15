public class Character {
  private String name;
  private bool ranged;
  private int atkDamage;
  private int health;
  private 


  public Enemy(String name, int difficulty, bool ranged, int atkDamage, int health) {
    this.name = name;
    this.difficulty = difficulty;
    this.ranged = ranged;
    this.atkDamage = atkDamage;
    this.health = health;
  }

  public getName() {
    return name;
  }

  public getDifficulty() {
    return difficulty;
  }

  public getRanged() {
    return ranged;
  }

  public getAtkDamage() {
    return atkDamage;
  }

  public getHealth() {
    return health;
  }

  
  public void attack(Character target, int atkDamage) {
    
  }
}