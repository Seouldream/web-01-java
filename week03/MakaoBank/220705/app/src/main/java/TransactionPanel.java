import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {


  public TransactionPanel(Account account) {
    this.setLayout(new GridLayout(account.transactions().size() + 1,1));

    this.add(new JLabel("거래내역"));

    for(String transaction : account.transactions() ) {
      JLabel label = new JLabel(transaction);
      this.add(label);
    }
  }
}
