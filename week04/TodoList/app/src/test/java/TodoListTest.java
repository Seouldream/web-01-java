import models.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {
  @Test
  void loadTasks() throws FileNotFoundException {
    TodoList todoList = new TodoList();

    List<Task> tasks = todoList.loadTasks();
    assertNotNull(tasks);
  }

  @Test
  void loadOneTask() throws FileNotFoundException {
    TodoList todoList = new TodoList();

    Task task1 = new Task("과제하기");

    List<Task> tasks = todoList.loadTasks();

    tasks.add(task1);

    assertEquals(task1,tasks.get(0));
  }

  @Test
  void loadMultipleTasks() throws FileNotFoundException {
    TodoList todoList = new TodoList();

    Task task1 = new Task("과제하기");
    Task task2 = new Task("잠자기");
    Task task3 = new Task("TIL쓰기");

    List<Task> tasks = todoList.loadTasks();

    tasks.add(task1);
    tasks.add(task2);
    tasks.add(task3);

    assertEquals(task1,tasks.get(0));
    assertEquals(task2,tasks.get(1));
    assertEquals(task3,tasks.get(2));
  }


}