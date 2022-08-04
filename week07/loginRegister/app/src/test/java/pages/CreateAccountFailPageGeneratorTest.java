package pages;

import models.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CreateAccountFailPageGeneratorTest {
  @Test
  void duplicateID() {

    PageGenerator pageGenerator = new CreateAccountSuccessPageGenerator();
    String content = pageGenerator.content();

    assertTrue(content.contains("회원가입이 완료되었습니다."),"아이디 등록 메세지 문제" + content);
    assertTrue(content.contains("<button><a href=/login"),"로그인 버튼 문제" + content);
  }
}
