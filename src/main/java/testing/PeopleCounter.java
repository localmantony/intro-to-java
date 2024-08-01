public class PeopleCounter {
  private long count = 0;

  //default constructor with no parameters
  public PeopleCounter() {}
  
  //constructor with parameters, passing variables will override initial value of count. Constructors may look similar to methods, but constructors do not have a return type.
  public PeopleCounter(long count) {
    this.count = count;
  }

  public void anotherOne() {
    count++;
    System.out.println("So far " + count);
  }
  
}