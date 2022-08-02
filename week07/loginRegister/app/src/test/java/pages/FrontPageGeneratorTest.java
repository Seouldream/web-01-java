package pages;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class FrontPageGeneratorTest {
  @Test
  void creation() {
    PageGenerator pageGenerator = new FrontPageGenerator();
    String html = pageGenerator.html();
    assertTrue(html.contains("안녕하세요!"),"헤드 문제" + html);
    assertTrue(html.contains("href=/login>로그인"),"로그인 버튼 문제" + html);
    assertTrue(html.contains("href=/createAccount>회원가입"),"회원가입 버튼 문제" + html);
  }

}