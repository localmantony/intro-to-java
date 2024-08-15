import java.util.Arrays;

public class GenericMethod {
  public static <T> T getMidPointItem(T[] array) {
    return array[array.length / 2];
  }

  public static void main(String[] args) {
    String[] names = {"Ann", "George", "Kim", "Pat", "Steve", "One"};
    String midPointName = getMidPointItem(names);
    System.out.println(Arrays.toString(names) + midPointName);
  }
}