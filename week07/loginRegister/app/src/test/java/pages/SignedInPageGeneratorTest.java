package pages;

import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SignedInPageGeneratorTest {
  @Test
  void SignedContent() {
    PageGenerator pageGenerator = new SignedInPageGenerator(new Account("극대노승준","1234","노승준"));
    String content = pageGenerator.content();

    assertTrue(content.contains("<h1>마카오뱅크</h1>"),"제목 문제" + content);
    assertTrue(content.contains("행복을 적립하는 마카오 뱅크입니다.</p"),"컨텐츠 미기입 문제" + content);
  }

  @Test
  void nameMessage() {
    Account noseungJun;
    PageGenerator pageGenerator = new SignedInPageGenerator(noseungJun =
        new Account("극대노승준","1234","노승준"));
    String content = pageGenerator.content();

    assertEquals("노승준",noseungJun.name());
    assertTrue(content.contains("안녕하세요, 노승준님!"),"이름 문제" + content);
  }


}