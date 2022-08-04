package pages;

public class LoginPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<form method=\"POST\" enctype=\"text/plain\">\n" +
        "<p>아이디</p>\n" +
        "<input type=\"text\" name=\"identifier\">\n" +
        "<p>비밀번호</p>\n" +
        "<input type=\"text\" name=\"password\"><br>\n" +
        "<button type=\"submit\">로그인</button>" +
        "</form>";
  }
}
