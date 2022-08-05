package pages;

public class FrontPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<p><h1>안녕하세요!</h1></p>" +
        "<button><a href=/login>로그인</a></button>" +
        "<button><a href=/createUser>회원가입</a></button>";
  }
}
