package utils;

import models.*;
import org.junit.jupiter.api.*;
import pages.*;
import repository.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainPageGeneratorTest {
  @Test
  void contents() throws FileNotFoundException {
    TaskRepository taskRepository = new TaskRepository();
    List<Task> tasks = taskRepository.loadTasks();
    PageGenerator pageGenerator = new MainPageGenerator(tasks);
    String html = pageGenerator.content();
    assertTrue(html.contains("Todo List"), "제목 문제" + html);
    assertTrue(html.contains("할 일:"), "할일 레이블 문제" + html);
    assertTrue(html.contains("<input type="), "할일 입력 문제" + html);
    assertTrue(html.contains("<button type="), "버튼 문제" + html);

  }
}
