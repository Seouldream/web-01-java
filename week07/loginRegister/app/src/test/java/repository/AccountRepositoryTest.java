package repository;

import models.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void accounts() {
    AccountRepository accountRepository = new AccountRepository();
    accountRepository.accounts().add(
        new Account("123","345","hoon")
    );


   // assertEquals("123",accountRepository.accounts().get(0).identifier());
  }

}