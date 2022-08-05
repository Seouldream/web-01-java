package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
  @Test
  void creation() {
    User account = new User("1234","456","hoon");

    assertEquals("1234",account.identifier());
    assertEquals("456",account.password());
    assertEquals("hoon",account.name());
  }

}