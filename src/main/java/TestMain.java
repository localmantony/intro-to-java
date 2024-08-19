public class TestMain{
  public static void inputError(int options) {
    System.out.print("Incorrect input. Please enter ");
    for (int i = 1; i < options; i++) {
     System.out.print(i + ", ");
    }
    System.out.println("or " + options + "." );   
  }

  public static void main(String[] args) {
    inputError(3);
  }
}