public class CompanyEmployee {
  private String lastName;
  private String firstName;
  int id;
  int salary;

  public CompanyEmployee(String lastNmae, String firstName, int id, int salary) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.id = id;
    this.salary = salary;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public int getId() {
    return id;
  }

  public int getSalary() {
    return salary;
  }

  public String toString() {
    return lastName + ", " + firstName + " ID: " + id + " ($" + salary + ")";
  }
}