public class PeopleCounter {
  
  private long count = 0;


  //default parameterless, count will have value above
  public PeopleCounter() {}


  //parameterized, count will have value passed
  public PeopleCounter(long count) {
    this.count = count;
  }

  public void anotherOne {
    count++;
    System.out.println("So far: " + count);
  }
}