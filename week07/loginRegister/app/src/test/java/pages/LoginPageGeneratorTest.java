package pages;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageGeneratorTest {
  @Test
  void creation() {
    PageGenerator pageGenerator = new LoginPageGenerator();
    String html = pageGenerator.html();
    assertTrue(html.contains("아이디"),"아이디 확인 문제" + html);
    assertTrue(html.contains("비밀번호"),"비밀번호 확인 문제" + html);
    assertTrue(html.contains("<input type"),"인풋 박스 확인 문제" + html);
  }

}