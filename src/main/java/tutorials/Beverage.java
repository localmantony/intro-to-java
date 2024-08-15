import java.text.DecimalFormat;

public class Beverage {
  private String name;
  private int size;
  private double price;
  public final DecimalFormat PriceFormat = new DecimalFormat("0.00");

  Beverage(String name, int size, double price) {
    this.name = name;
    this.size = size;
    this.price = price;
  }

  
}
