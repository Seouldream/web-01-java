package models;

import java.util.*;

public class Transaction {
  private String type;
  private int amount;

  public Transaction(String type, int amount) {
    this.type= type;
    this.amount = amount;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public boolean equals(Object other) {
    Transaction otherTransaction = (Transaction) other;
    return (Objects.equals(this.type, otherTransaction.type)
      && this.amount == otherTransaction.amount);

    }

    @Override
  public String toString() {
    return "Transaction(" + type + ": " + amount + ")";
    }

  public String type() {
    return type;
  }

  public Integer amount() {
    return amount;
  }

  public int process(int i) {
    return this.amount;
  }
}

