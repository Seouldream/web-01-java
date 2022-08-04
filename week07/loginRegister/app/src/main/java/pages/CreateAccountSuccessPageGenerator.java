package pages;

public class CreateAccountSuccessPageGenerator extends PageGenerator{
  @Override
  public String content() {
    return "<p><h1>회원가입이 완료되었습니다.</p>\n" +
        "<button><a href=/login>로그인하기</a></button>\n";
  }
}
