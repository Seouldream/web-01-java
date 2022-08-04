package pages;

public class PasswordMismatchFailPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<p><h1>입력하신 비밀번호가 서로 일치하지 않습니다.다시 확인해주세요.</p>\n" +
        "<button><a href=/createAccount>돌아가기</a></button>\n";
  }
}
