package pages;

public class DoubleCheckIdentifierPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<p><h1>등록되지 않은 사용자입니다.다시 확인해주세요.</p>\n" +
        "<button><a href=/login>돌아가기</a></button>\n";
  }
}
