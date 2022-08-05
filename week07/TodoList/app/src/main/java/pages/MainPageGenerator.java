package pages;

import models.*;
import pages.*;

import java.util.*;

public class MainPageGenerator extends PageGenerator {

  private List<Task> tasks;

  public MainPageGenerator(List<Task> tasks) {

    this.tasks = tasks;
  }

  public String content() {
    return "<h1>Todo List<h1>\n" +
        "<form method=\"POST\" enctype=\"text/plain\">\n" +
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
