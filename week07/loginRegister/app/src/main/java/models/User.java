package models;

public class User {
  private String email;
  private String identifier;
  private String password;
  private String name;

  public User(String identifier, String password, String name) {

    this.identifier = identifier;
    this.password = password;
    this.name = name;
    this.email = email;
  }

  public String identifier() {
    return identifier;
  }

  public String password() {
    return password;
  }

  public String name() {
    return name;
  }

  public String toCsvRow() {
    return String.join(",", identifier, password, name, email);
  }
}
