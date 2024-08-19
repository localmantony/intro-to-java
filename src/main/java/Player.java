public class Player extends Character {
  protected Weapons[] weapons = new Weapons[2];
  
  public Player(String name, Weapons[] weapons) {
    super(name, 100, 90);  // health and accuracy set to 100 and 90
    this.weapons = weapons;
  }

  public void setWeapon1(Weapons weapon1) {
    this.weapons[0] = weapon1;
  }
  
  public void setWeapon2(Weapons weapon2) {
    this.weapons[1] = weapon2;
  }

  public Weapons getWeapon1() {
    return weapons[0];
  }

  public Weapons getWeapon2() {
    return weapons[1];
  }

  public void displayPlayer() {
    System.out.println("Name: " + name);
    System.out.println("Health: " + health);
    System.out.println("Accuracy: " + accuracy);
    System.out.println("Primary Weapon: " + weapons[0].getName());
    System.out.println("Tactical Weapon: " + weapons[1].getName());
  }
}