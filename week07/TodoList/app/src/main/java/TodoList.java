
import com.sun.net.httpserver.*;
import models.*;
import pages.*;
import repository.*;
import utils.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class TodoList {
  private FormParser formParser;
  private TaskRepository taskRepository;

  public TodoList() {
    formParser = new FormParser();
    taskRepository = new TaskRepository();
  }

  public static void main(String[] args) throws IOException {
    TodoList application = new TodoList();
    application.run();
  }

  private void run() throws IOException {

    List<Task> tasks = new ArrayList<>(taskRepository.loadTasks());

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {

      String method = exchange.getRequestMethod();
      String requestBody = new RequestBodyReader(exchange).body();
      System.out.println("RequestBody: " + requestBody);
      String todo = formParser.parse(requestBody);

      PageGenerator pageGenerator = process(method, todo, tasks);

      String content = pageGenerator.html();
      PageWriter pageWriter = new PageWriter(exchange);
      pageWriter.write(content);

    });

    System.out.println("http://localhost:8000");
    httpServer.start();
  }

  private PageGenerator process(String method, String todo, List<Task> tasks) throws IOException {
    if (method.equals("GET")) {
      return new MainPageGenerator(tasks);
    }
    return processPOST(todo, tasks);
  }

  private PageGenerator processPOST(String todo, List<Task> tasks) throws IOException {
    if (!todo.isBlank()) {
      String identifier = UUID.randomUUID().toString();
      Task task = new Task(identifier,todo);
      tasks.add(task);
      TaskRepository.save(tasks);
    }
    return new TaskPageGenerator(tasks);
  }
