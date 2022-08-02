package utils;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainPageGeneratorTest {
  @Test
  void contents() {
    PageGenerator pageGenerator = new MainPageGenerator();
    String html = pageGenerator.content();
    assertTrue(html.contains("Todo List"),"제목 문제" + html);
    assertTrue(html.contains("할 일:"),"할일 레이블 문제" + html);
    assertTrue(html.contains("<input type="),"할일 입력 문제" + html);
    assertTrue(html.contains("<button type="),"버튼 문제" + html);

  }

}