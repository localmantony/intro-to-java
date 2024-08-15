//public class
public class Dog {
  //private attributes
  private String name;
  private String breed;
  private int age;
  private String color;
//Constructor with parameters
  public Dog(String name, String breed, int age, String color) {
    this.name = name;
    this.breed = breed;
    this.age = age;
    this.color = color;
  }

  //public methods provide read access to the attributes
  public String getName() {
    return name;
  }

  public String getBreed() {
    return breed;
  }

  public int getAge() {
    return age;
  }

  public String getColor() {
    return color;
  }

  //methods for behaviors
  public void bark() {
    System.out.println("Woof!");
  }

  public void fetch() {
    System.out.println(name + " went to fetch.");
  }
}