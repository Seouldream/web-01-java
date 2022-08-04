package models;

import java.util.*;

public class Account {

  private String identifier;
  private String name;
  private int amount;

  private List<Transaction> transactions = new ArrayList<>();

  public Account(String identifier, String name, int amount) {
    this.identifier = identifier;
    this.name = name;
    this.amount = amount;
  }

  public String identifier() {
    return identifier;
  }

  public String name() {
    return name;
  }

  public int amount() {
    return amount;
  }

  public void transfer(Account receiver, long amount) {

    this.amount -= amount;
    receiver.amount += amount;

    Transaction transaction = new Transaction(this, receiver, amount);
    transactions.add(transaction);
    receiver.transactions.add(transaction);
    //transactions <List>
  }

  public int transactionsCount() {
    return transactions.size();
  }

  public List<Transaction> transactions() {
    return new ArrayList<>(transactions);
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    Account otherAccount = (Account) other;
    return identifier.equals(otherAccount.identifier);
  }
}
