package utils;

import com.sun.net.httpserver.*;

import java.io.*;

public class PageWriter {
  private HttpExchange exchange;

  public PageWriter(HttpExchange exchange) {

    this.exchange = exchange;
  }

  public void write(String content) throws IOException {
    exchange.sendResponseHeaders(200,content.getBytes().length);
    OutputStream outputStream = exchange.getResponseBody();
    outputStream.write(content.getBytes());
    outputStream.flush();
    outputStream.close();
  }
}
