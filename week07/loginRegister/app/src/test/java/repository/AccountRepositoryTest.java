package repository;

import models.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() throws IOException {
    AccountRepository accountRepository = new AccountRepository();
    List<Account> accounts = List.of(
        new Account("1234", "1234", "ashal")
    );

    assertEquals("1234", accountRepository.find("1234").identifier());
    assertEquals("1234", accountRepository.find("1234").password());
    assertEquals("ashal", accountRepository.find("1234").name());
  }

  @Test
  void accounts() throws IOException {
    AccountRepository accountRepository = new AccountRepository();

    assertEquals(2, accountRepository.accounts().size());
    Map<String, Account> accounts = accountRepository.accounts();

    accounts.put("new", new Account("new", "1234", "name"));
    assertEquals(3, accounts.size());
  }

  @Test
  void notFound() throws IOException {
    AccountRepository accountRepository = new AccountRepository();

    assertEquals(2, accountRepository.accounts().size());
    Map<String, Account> accounts = accountRepository.accounts();

    assertEquals("1234", accountRepository.find("5678","1234").identifier());
   // assertEquals("1234", accountRepository.find("5678").identifier());

  }
}
