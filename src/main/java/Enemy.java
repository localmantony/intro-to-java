public class Enemy extends Character {
  protected int atkDamage;
  protected int difficulty;

  public Enemy(String name, int health, int accuracy, int atkDamage, int difficulty) {
    super(name, health, accuracy);
    this.atkDamage = atkDamage;
    this.accuracy = accuracy;
    this.difficulty = difficulty;
  }

  public int getAtkDamage() {
    return atkDamage;
  }

  public int getDifficulty() {
    return difficulty;
  }
}