public class MemberInheritance {
  public static void main(String[] args) {
    Member testMember = new Member("John", "Tully");
    System.out.println("Member: \nFirst Name: " + testMember.getFirstName());
    System.out.println("Last Name: " + testMember.getLastName());
    System.out.println("Expiry Date: " + testMember.getExpiryDate());

    Member testAdmin = new Admin("AdminJohn", "Tully");
    System.out.println("\nAdmin: \nFirst Name: " + testAdmin.getFirstName());
    System.out.println("Last Name: " + testAdmin.getLastName());
    System.out.println("Expiry Date: " + testAdmin.getExpiryDate());

    User testUser = new User("userJohn", "Tully");
    System.out.println("\nUser: \nFirst Name: " + testUser.getFirstName());
    System.out.println("Last Name: " + testUser.getLastName());
    System.out.println("Expiry Date: " + testUser.getExpiryDate());
  }
}