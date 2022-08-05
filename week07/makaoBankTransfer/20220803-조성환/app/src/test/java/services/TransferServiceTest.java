package services;

import models.Account;
import org.junit.jupiter.api.Test;
import repositories.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {
  @Test
  void transfer() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");

    long oldSenderAmount = sender.amount();
    long oldReceiverAmount = receiver.amount();

    TransferService transferService = new TransferService(accountRepository);

    transferService.transfer("1234","2345",500);

    long newSenderAmount = sender.amount();
    long newReceiverAmount = receiver.amount();

    assertEquals(500, oldSenderAmount - newSenderAmount);
    assertEquals(500, newReceiverAmount - oldReceiverAmount);
  }
}
