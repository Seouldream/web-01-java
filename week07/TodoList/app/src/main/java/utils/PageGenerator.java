package utils;

public class PageGenerator {
  public String html() {
    return "<!DOCTYPE html>" +
           "<html>" +
           "<head>" +
            "<meta charset=\"UTF-8\">" +
            "<title>Todo List</title>" +
            "</head>" +
            "<body>" +
             content() +
            "</body>" +
            "<html>";

  }

  public String content() {
    return "<h1>Todo List<h1>" +
          "<form method=\"POST\">" +
         "<label for=\"things\">할 일:</label>" +
          "<input type=\"text\" name=\"task\">" +
          "<button type=\"submit\">확인</button>" +
          "</form>";
  }
}
