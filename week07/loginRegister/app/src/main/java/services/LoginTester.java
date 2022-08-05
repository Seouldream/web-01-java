package services;

import models.*;
import pages.*;
import repository.*;

import java.util.*;

public class LoginTester {
  private User user;
  private Map<String, String> formData;

  public LoginTester(UsersRepository usersRepository,Map<String,String> formData) {
    this.formData = formData;
    user = usersRepository.find(formData.get("identifier"), "test");
  }

  public boolean UserIdTester() {

    if (!formData.get("identifier").equals(user.identifier())) {
      return false;
    }
    return true;
  }

  public boolean UserPasswordTester() {
    if(!formData.get("password").equals(user.password())) {
      return false;
    }
    return true;
  }
}
