package utils;

import models.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskPageGeneratorTest {
  @Test
  void taskContent() {
    List<Task> tasks = List.of(
        new Task("빨래널기"),
        new Task("밥하기")
    );
    PageGenerator pageGenerator = new TaskPageGenerator(tasks);
    String html = pageGenerator.content();
    assertTrue(html.contains("빨래널기"),"할일 목록 업로드 문제" + html);
  }

}