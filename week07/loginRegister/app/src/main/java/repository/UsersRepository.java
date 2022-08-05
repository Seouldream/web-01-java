package repository;

import models.*;
import utils.*;

import java.io.*;
import java.util.*;

public class UsersRepository extends java.awt.List {
  private Map<String, User> users;

  public UsersRepository() throws IOException {
    UsersLoader usersLoader = new UsersLoader();
    users = new HashMap<>(usersLoader.load());

  }

  public User find(String identifier) {

    return users.get(identifier);
  }

  public User find(String identifier, String nextIdentifier) {
    User user = find(identifier);
    if (user == null) {
      user = find(nextIdentifier);
    }
    return user;
  }

  public Map<String, User> users() {
    return this.users;
  }
}
