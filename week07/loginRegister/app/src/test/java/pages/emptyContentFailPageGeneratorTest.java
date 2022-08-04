package pages;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class emptyContentFailPageGeneratorTest {
  @Test
  void emptyContent() {
    PageGenerator pageGenerator = new EmptyContentFailPageGenerator();
    String content = pageGenerator.content();

    assertTrue(content.contains("입력되지 않은 정보가 있습니다."),"컨텐츠 미기입 문제" + content);
    assertTrue(content.contains("<a href=/createAccount>돌아가기"),"컨텐츠 미기입 문제" + content);
  }
}
