package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234", "ashal", 3000);

    assertEquals("1234", account.identifier());
    assertEquals("ashal", account.name());
    assertEquals(3000, account.amount());
  }
}
