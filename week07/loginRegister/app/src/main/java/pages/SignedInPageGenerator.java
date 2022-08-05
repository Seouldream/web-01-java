package pages;

import models.*;

public class SignedInPageGenerator extends PageGenerator {
  private User account;

  public SignedInPageGenerator(User account) {

    this.account = account;
  }

  @Override
  public String content() {
    return "<p><h1>마카오뱅크</h1></p>\n" +
        "<p>안녕하세요, "+ account.name() +"님!"
        + " 행복을 적립하는 마카오 뱅크입니다.</p>\n";
  }
}
