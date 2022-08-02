package pages;

import models.Account;
import pages.PageGenerator;

public class TransferSucessPageGenerator extends PageGenerator {
  private Account account;

  public TransferSucessPageGenerator(Account account) {
    super();

    this.account = account;
  }

  @Override
  public String content() {
    return "계좌 이체 성공!";
  }
}
