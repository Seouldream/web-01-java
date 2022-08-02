package utils;

import models.*;

import java.util.*;

public class TaskPageGenerator extends PageGenerator {

  private List<Task> tasks;

  public TaskPageGenerator(List<Task> tasks) {

    this.tasks = tasks;
  }

  @Override
  public String content() {
    return "<h1>Todo List<h1>\n" +
        "<form method=\"POST\">\n" +
        "<label for=\"things\">할 일:</label>\n" +
        "<input type=\"text\" name=\"task\">\n" +
        "<button type=\"submit\">확인</button>\n" +
        "</form>\n" +
        "<ul>\n" +
        task() +
        "</ul>\n";
  }

  private String task() {
    String anything = "";
    for (Task task : tasks) {
      anything += "<li>" + task.task() + "</li>\n";
    }
    return anything;
  }
}

