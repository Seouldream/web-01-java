package utils;

public class MainPageGenerator extends PageGenerator{

  public String content() {
    return "<h1>Todo List<h1>\n" +
        "<form method=\"POST\" enctype=\"text/plain\">\n" +
        "<label for=\"things\">할 일:</label>\n" +
        "<input type=\"text\" name=\"task\">\n" +
        "<button type=\"submit\">확인</button>\n" +
        "</form>\n";
  }
}
