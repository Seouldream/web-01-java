package pages;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class duplicatePasswordFailPageGeneratorTest {
  @Test
  void duplicatePassword() {
    PageGenerator pageGenerator = new PasswordMismatchFailPageGenerator();
    String content = pageGenerator.content();

    assertTrue(content.contains("<h1>입력하신 비밀번호가 서로 일치하지 않습니다."),"비밀번호 일치 메세지 문제" + content);
    assertTrue(content.contains("<button><a href=/createAccount>돌아가기</a></button>"),"돌아가기 버튼 문제" + content);
  }
}
