package repository;

import models.*;
import org.checkerframework.checker.units.qual.*;
import utils.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class AccountRepository extends java.awt.List {
  private final Map<String, Account> accounts;

  public AccountRepository() throws IOException {
    AccountsLoader accountsLoader = new AccountsLoader();
    accounts = accountsLoader.load();

  }

  public Account find(String identifier) {

    return accounts.get(identifier);
  }

  public Account find(String identifier, String nextIdentifier) {
    Account account = find(identifier);
    if (account == null) {
      account = find(nextIdentifier);
    }
    return account;
  }

  public Map<String, Account> accounts() {
    return this.accounts;
  }
}
