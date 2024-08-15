import java.time.LocalDate;

//Subclass of Member for administrators
public class Admin extends Member{
  private int expiryDays = 100 * 365;
  private LocalDate expiryDate;
  
  public Admin(String firstName, String lastName) {
    super(firstName, lastName);
    expiryDate = LocalDate.now().plusDays(expiryDays);
    }

  @Override
  public LocalDate getExpiryDate() {
    return expiryDate;
  }
}