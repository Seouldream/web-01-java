import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {
  TransferPanel(Account account) {
    this.setLayout(new GridLayout(3, 1));

    JLabel label = new JLabel("송금");
    this.add(label);

    JTextField textField = new JTextField(10);
    this.add(textField);

    JButton button = new JButton("송금하기");
    button.addActionListener(event -> {
      long transferAmount = Long.parseLong(textField.getText());
      account.transfer(transferAmount);
    });
    this.add(button);
  }
}

