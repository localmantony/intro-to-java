public class User {
  private String userName;
  private String password;

  //constructor with userName, and password parameters)
  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  //allow read only access to user name
  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }
}