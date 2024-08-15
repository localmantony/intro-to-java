public class DogExample {
  public static void main(String[] args) {
    // constructur from class Dog is called with "new"
    // Dog object is assigned to variable myDog
    // Class names start with capital letter
    // variable name start lowercase
    Dog myDog = new Dog("Toffee", "Bassett", 16, "Brown");

    System.out.println("\nName: " + myDog.getName());
    System.out.println("Breed: " + myDog.getBreed());
    System.out.println("Age: " + myDog.getAge());
    System.out.println("Color: " + myDog.getColor());

    System.out.println("\n" + myDog.getName() + " loves you. ");
  }
}