public class Coffee implements Beverage {
  private String roastType;
  private int size;
  private boolean decaf;
  private double price;

  public Coffee(String roastType, int size, boolean decaf, double price) {
    this.roastType = roastType;
    this.size = size;
    this.decaf = decaf;
    this.price = price;
  }

  //methods are required by the beverage interface

  public String getName() {
    return "coffee";
  }

  public int getSize() {
    return size;
  }

  public boolean isDecaf() {
    return decaf;
  }

  @Override //overridng toString from java base class
  public String toString() {
    String item = roastType + " coffee (" + size + " oz.) " + PriceFormat.format(price);
    if(decaf) {
      return "decaf " + item;
    }
    else {
      return item;
    }
  }
}