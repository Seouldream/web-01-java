package models;

public class Transaction {
  private Account sender;
  private Account receiver;
  private long amount;

  public Transaction(Account sender, Account receiver, long amount) {
    this.sender = sender;
    this.receiver = receiver;
    this.amount = amount;
  }

  public Account sender() {
    return sender;
  }

  public Account receiver() {
    return receiver;
  }

  public long amount() {
    return amount;
  }

  public String command(Account account) {
    if(account.identifier().equals(sender.identifier())) {
      return "송금";
    }
    return "입금";
  }

  public Account other(Account account) {
    if(account.identifier().equals(sender.identifier())) {
      return receiver;
    }
    return sender;
  }
}
