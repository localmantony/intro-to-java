public class Minion extends Enemy {

  // minion is low strength, low accuracy - can be killed in one hit with any weapon that deals damage
  public Minion (String name) {
    super(name, 30, 60, 5, 25); // (String name, int health, int accuracy, int atkDamage, int difficulty)
  }
}