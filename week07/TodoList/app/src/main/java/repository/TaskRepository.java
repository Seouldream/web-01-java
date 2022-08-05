package repository;

import models.*;

import java.io.*;
import java.util.*;

public class TaskRepository {
  private List<Task> tasks = new ArrayList<>();

  public List<Task> loadTasks() throws FileNotFoundException {

    File file = new File("tasksData.csv");
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      Task task = parse(line);
      tasks.add(task);
    }
    return tasks;
  }

  public Task parse(String line) {
    String[] words = line.split(",");
    String identifier = words[0];
    String task = words[1];
    return new Task(identifier, task);
  }

  public static void save(List<Task> tasks) throws IOException {
    FileWriter fileWriter = new FileWriter("tasksData.csv");

    for (Task task : tasks) {
      String line = task.identifier() + "," + task.task();
      fileWriter.write(line +"\n");
    }
    fileWriter.close();
  }
}
