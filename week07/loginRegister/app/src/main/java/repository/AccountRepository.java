package repository;

import models.*;
import org.checkerframework.checker.units.qual.*;

import java.util.*;
import java.util.stream.*;

public class AccountRepository extends java.awt.List {
  private final Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    Arrays.stream()(
        new Account("1234", "1234", "ashal"),
        new Account("2345", "2345", "joker")
    ).forEach(account -> {
      accounts.put(account.identifier(), account);
    });
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
