import com.sun.net.httpserver.*;
import models.*;
import repositories.*;
import utils.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class TodoList {
  private TaskRepository taskRepository = new TaskRepository();
  public static void main(String[] args) throws IOException {
    TodoList application = new TodoList();
    application.run();
  }

  private void run() throws IOException {
    List<Task> tasks= new ArrayList<>();

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address,0);

    httpServer.createContext("/",exchange -> {

      String method = exchange.getRequestMethod();

      PageGenerator pageGenerator = new MainPageGenerator();

      if(method.equals("POST")) {
        String requestBody = new RequestBodyReader(exchange).body();

        String[] pair = requestBody.split("=");
        String todo = pair[1];
        Task task = new Task(todo);

        tasks.add(task);
        pageGenerator = new TaskPageGenerator(tasks);
      }

      String content = pageGenerator.html();
      PageWriter pageWriter = new PageWriter(exchange);
      pageWriter.write(content);

    });

    System.out.println("http://localhost:8000");
    httpServer.start();
  }
}
