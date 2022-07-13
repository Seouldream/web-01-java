package models;

public class Task {
  private String todo;

  public Task(String todo) {

    this.todo = todo;
  }

  @Override
  public boolean equals(Object other) {
    Task otherTask = (Task) other;
    return this.todo.equals(((Task) other).todo);
  }

  @Override
  public String toString() {
    return this.todo;
  }

  public String task() {
    return this.todo;
  }
}
