package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void simple() {
    Task task = new Task("todo");
  }

  @Test
  void equals() {
    Task task1 = new Task("과제하기");
    Task task2 = new Task("과제하기");

    assertEquals(task1,task2);
  }

  @Test
  void showErrors() {
    Task task1 = new Task("빨래하기");
    Task task2 = new Task("과제하기");

    assertEquals(task1,task2);
  }
}