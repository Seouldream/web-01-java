package services;

import models.*;
import repository.*;

import java.util.*;

public class UserCreationTester {
  private List<User> users = new ArrayList<>();
  private UsersRepository usersRepository;


  public UserCreationTester(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public boolean identifierTester(String identifier) {

    for (Map.Entry<String, User> accountSet : usersRepository.users().entrySet()) {
      if (accountSet.getKey().equals(identifier)) {
        return false;
      }
    }
    return true;
  }

  public boolean passwordTester(String password, String passwordDoubleCheck) {
    if (password.equals(passwordDoubleCheck)) {
      return true;
    }
    return false;
  }

  public boolean emptyTester(String identifier
      , String password
      , String passwordDoubleCheck
      , String name
      , String email) {
    if ((identifier == null)
        || (password == null)
        || (passwordDoubleCheck == null)
        || (email == null)
        || (name == null)) {
      return false;
    }
    return true;
  }
}
