import java.util.*;

public class Account {

  private int amount = 1000;
  private List<String> transactions = new ArrayList<>();

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public int getAmount() {
    return this.amount;
  }


  public void transfer(int transferAmount) {
    this.amount -= transferAmount;


    transactions.add("송금:" + amount + "원");
      }
}
