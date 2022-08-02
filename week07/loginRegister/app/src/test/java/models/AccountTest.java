package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234","456","hoon");

    assertEquals("1234",account.identifier());
    assertEquals("456",account.password());
    assertEquals("hoon",account.name());
  }

}