public class Driver{
  public static void main(String[] args) {
    Bird anthony = new Bird("anthony", 2);

    System.out.println("The bird you created is named " + anthony.getName() + " and it has " + anthony.getNoOfLegs() + " legs.");
  }
}