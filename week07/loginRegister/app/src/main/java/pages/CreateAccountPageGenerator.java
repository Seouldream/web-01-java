package pages;

public class CreateAccountPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<form method=\"POST\" enctype=\"text/plain\">\n" +
        "<p>이름</p>\n" +
        "<input type=\"text\" name=\"name\">\n" +
        "<p>아이디</p>\n" +
        "<input type=\"text\" name=\"account\">\n" +
        "<p>비밀번호</p>\n" +
        "<input type=\"text\" name=\"password\">\n" +
        "<p>비밀번호 재확인</p>\n" +
        "<input type=\"text\" name=\"passwordDoubleCheck\">\n" +
        "<p>이메일</p>\n" +
        "<input type=\"text\" name=\"email\"><br>\n" +
        "<button type=\"submit\">회원가입</button>\n" +
        "</form>";
  }
}
