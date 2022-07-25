import models.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TaskWriter {
  public void writeTask(List<Task> tasks) throws IOException {
    FileWriter fileWriter = new FileWriter("TaskList.csv");
    for (Task task : tasks) {
      String line = task.toCsvRow();

      fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }
}
