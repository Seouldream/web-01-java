package pages;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserPageGeneratorTest {
  @Test
  void creation() {
    PageGenerator pageGenerator = new CreateUserPageGenerator();
    String html = pageGenerator.html();
    assertTrue(html.contains("이름"), "이름 확인 문제" + html);
    assertTrue(html.contains("아이디"), "아이디 확인 문제" + html);
    assertTrue(html.contains("비밀번호"), "비밀번호 확인 문제" + html);
    assertTrue(html.contains("비밀번호 재확인"), "비밀번호 재확인 확인 문제" + html);
    assertTrue(html.contains("<button type"), "버튼 확인 문제" + html);
    assertTrue(html.contains("<input type"), "비밀번호 재확인 확인 문제" + html);

  }

}