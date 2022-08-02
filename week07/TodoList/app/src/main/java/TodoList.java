import com.sun.net.httpserver.*;
import utils.*;

import java.io.*;
import java.net.*;

public class TodoList {
  public static void main(String[] args) throws IOException {
    TodoList application = new TodoList();
    application.run();
  }

  private void run() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address,0);

    httpServer.createContext("/",exchange -> {

      PageGenerator pageGenerator = new PageGenerator();

      String content = pageGenerator.html();

      exchange.sendResponseHeaders(200,content.getBytes().length);
      OutputStream outputStream = exchange.getResponseBody();
      outputStream.write(content.getBytes());
      outputStream.flush();
      outputStream.close();
    });

    System.out.println("http://localhost:8000");
    httpServer.start();
  }
}
