package models;

import java.util.*;

public class Task {

  private String identifier;
  private String task;

  public Task(String identifier ,String task) {
    this.identifier = identifier;
    this.task = task;
  }

  public String task() {
    return task;
  }

  public String identifier() {
    return identifier;
  }
}
