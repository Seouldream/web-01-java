package pages;

public class EmptyContentFailPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<p><h1>입력되지 않은 정보가 있습니다.다시 확인해주세요.</p>\n" +
        "<button><a href=/createUser>돌아가기</a></button>\n";
  }
}
