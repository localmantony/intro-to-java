public class Striker extends Enemy {

  // striker is a medium strength enemy with medium difficulty and decent accuracy 
  public Striker(String name) {
    super(name, 50, 70, 10, 50); // (String name, int health, int accuracy, int atkDamage, int difficulty)
  }
}