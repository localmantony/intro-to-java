import java.util.Scanner;
import java.util.ArrayList;

class SayHello {
  
  static <T> String sayHello(ArrayList<T> names) {
    String greeting = "";
    for (T name : names) {
      greeting += "Hello, " + name + "\n";
    }
    return greeting;
  }

  public static double getAverage(double.. values) {
    double sum = 0;
    int count = 0;

    for (double number: values) {
      sum += number;
      count++;
    }
    return sum / count;
  }
  
  public static void main(String[] args) {
    ArrayList<String> userNames = new ArrayList<>();
    userNames.add("Sophia");
    userNames.add("Sophie");
    userNames.add("Sofia");

    String greetingOutput = sayHello(userNames);

    System.out.println(greetingOutput);

    

    
    }
  }
}