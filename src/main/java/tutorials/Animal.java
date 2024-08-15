 public class Animal {

   private int noOfLegs;
   private String name;

   public Animal(){}

   public Animal(int legs, String name) {
     this.noOfLegs = legs;
     this.name = name;
   }

   public int getNoOfLegs() {
     return noOfLegs;
   }

   public void setNoOfLegs(int noOfLegs) {
     this.noOfLegs = noOfLegs;
   }

   public String getName() {
     return name;
   }

   public void setName(String name) {
     this.name = name;
   }

 }