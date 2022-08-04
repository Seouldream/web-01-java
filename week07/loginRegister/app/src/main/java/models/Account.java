package models;

public class Account {
  private String email;
  private String identifier;
  private String password;
  private String name;

  public Account(String identifier, String password, String name) {

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
}
