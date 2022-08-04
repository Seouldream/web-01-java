package utils;

import models.*;
import org.junit.jupiter.api.*;
import repository.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountTesterTest {
  @Test
  void duplicateID() throws IOException {
    AccountRepository accountRepository = new AccountRepository();

    String id1 = "1234";
    String id2 = "5678";

    for(Map.Entry<String,Account> account : accountRepository.accounts().entrySet()) {
      if(account.getKey().equals(id1)) {
        break;
      }
      accountRepository.accounts().put(id1,new Account(id1,"password","name"));
    }

    assertEquals(2,accountRepository.accounts().size());
  }

  @Test
  void mismatchPassword() throws IOException {
    AccountRepository accountRepository = new AccountRepository();
    List<Account> accounts = new ArrayList<>();
    accounts.add(new Account("1234","abc","ashal"));
    accounts.add(new Account("2345","def","joker"));

    String identifier = "test";
    String password = "test";
    String passwordDoubleCheck = "mismatch";
    String name = "jun";

    if(password.equals(passwordDoubleCheck)) {
      accounts.add(new Account(identifier,password,name));
    }

    assertNull(accountRepository.find("test"));
  }

  @Test
  void emptyForm() throws IOException {
    AccountRepository accountRepository = new AccountRepository();
    List<Account> accounts = new ArrayList<>();
    accounts.add(new Account("1234","abc","ashal"));
    accounts.add(new Account("2345","def","joker"));

    String identifier = "test";
    String password = "test";
    String passwordDoubleCheck = "mismatch";
    String email = "";
    String name = "jun";

    if(!identifier.isBlank() && !password.isBlank() && !passwordDoubleCheck.isBlank()
    && !email.isBlank() && !name.isBlank()) {
      accounts.add(new Account(identifier,password,name));
    }

    assertEquals(2,accounts.size());
  }
}
