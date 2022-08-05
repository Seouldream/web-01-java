package pages;

import org.junit.jupiter.api.Test;
import pages.PageGenerator;

import static org.junit.jupiter.api.Assertions.*;

class PageGeneratorTest {
  @Test
  void navigation() {
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return null;
      }
    };
    String html = pageGenerator.html();

    assertTrue(html.contains("홈으로"), "홈 메뉴 문제 " + html);
    assertTrue(html.contains("잔액 조회"), "잔액 조회 메뉴 문제 " + html);
    assertTrue(html.contains("송금"), "송금 메뉴 문제 " + html);
    assertTrue(html.contains("거래 내역"), "거래 내역 메뉴 문제 " + html);
  }
}
