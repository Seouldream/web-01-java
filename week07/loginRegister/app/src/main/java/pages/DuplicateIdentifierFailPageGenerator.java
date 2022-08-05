package pages;

public class DuplicateIdentifierFailPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<p><h1>이미 등록된 아이디입니다.</p>\n" +
        "<button><a href=/createUser>돌아가기</a></button>\n";
  }
}
