import javax.swing.*;

public class AmountPanel extends JPanel {
  private Account account;
  AmountPanel(Account account) {
    this.account = account;

    JLabel label = new JLabel(amount());
    this.add(label);
  }

  private String amount() {
    return "잔액: " + account.getAmount() + "원";
  }

}
