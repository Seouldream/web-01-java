package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("1234","빨래널기");

    assertEquals("빨래널기", task.task());
    assertEquals("1234", task.identifier());
  }
}
