public class Weapons {
  private String name;        // name of weapon
  private int atkDamage;      // atkDamage is subtracted from enemy health if attack lands
  private int speed;          // speed is the amount of times a weapon can attack per turn
  private int lifespan;       // amount of times a weapon can be used, -1 = infinite
  private String description; // description of how each weapon is used

  // parameterized constructor
  public Weapons(String name, int atkDamage, int speed, int lifespan, String description) {
    this.name = name;
    this.atkDamage = atkDamage;
    this.speed = speed;
    this.lifespan = lifespan;
    this.description = description;
  }
  
  // Default constructor for access to get primary/tactical weapons without actually creating a weapon
  public Weapons() {}


  // getters and setters
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

  public void setLifespan(int num) {
    lifespan = num;
  }
  public void reduceLifespan() {
      lifespan -= 1;
  }

  // list of primary weapons to choose from
  public Weapons[] getPrimaryWeapons() {
    Weapons[] primaryWeapons = new Weapons[2];
    primaryWeapons[0] = new Weapons("sword", 50, 1, -1, "Primary Weapon - Heavy hitter");
    primaryWeapons[1] = new Weapons("bow", 30, 2, -1, "Primary Weapon - Lighter attack damage, but quick. Allows for two attacks in a single turn.");
    return primaryWeapons;
  }

  // list of tactical weapons to choose from
  public Weapons[] getTacticalWeapons() {
    Weapons[] tacticalWeapons = new Weapons[2];
    tacticalWeapons[0] = new Weapons("bomb", 30, 1, 1, "Tactical - Deals damage to all enemies in the arena. One time use.");
    tacticalWeapons[1] = new Weapons("smoke", 0, 1, 1, "Tactical - Provides a smoke screen and allows the player to go twice in a row. One time use.");
    return tacticalWeapons;
  }

  // displays all weapon info at once for use in the weapon viewer
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
    System.out.println("Description: " + description + "\n");
  }

}