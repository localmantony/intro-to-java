public class Weapons {
  private String name;
  private int atkDamage;
  private int speed;  // speed is the amount of times a weapon can attack per turn
  private int lifespan; // amount of time a weapon can be used, -1 = infinite
  private String description; // description of how each weapon is used
  
  public Weapons(String name, int atkDamage, int speed, int lifespan, String description) {
    this.name = name;
    this.atkDamage = atkDamage;
    this.speed = speed;
    this.lifespan = lifespan;
    this.description = description;
  }
  
  public String getName() {
    return name;
  }

  public int getAtkDamage() {
    return atkDamage;
  }

  public int getSpeed() {
    return speed;
  }

  public int getLifespan() {
    return lifespan;
  }

  public String getDescription() {
    return description;
  }

  public void reduceLifespan() {
      lifespan -= 1;
  }
  
  public void displayWeapon() {
    System.out.println("Name: " + name);
    System.out.println("Attack Damage: " + atkDamage);
    System.out.println("Speed (Uses per turn): " + speed);
    if (lifespan > 0) {
      System.out.println("Total Uses: " + lifespan);
    }
    else {
      System.out.println("Total Uses: unlimited");
    }
    System.out.println("Description: " + description);
  }
}