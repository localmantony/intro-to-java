public class Warden extends Enemy {

  // warden is a strong enemy with high difficulty and accuracy - cannot be played against on Easy mode
  public Warden(String name) {
    super(name, 90, 85, 20, 75); // (String name, int health, int accuracy, int atkDamage, int difficulty)
  }
}