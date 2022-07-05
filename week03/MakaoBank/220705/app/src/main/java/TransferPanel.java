import javax.swing.*;
import java.awt.*;

public class TransferPanel extends JPanel {

  private final JTextField textField;

  TransferPanel(Account account) {


    this.setLayout(new GridLayout(3, 1));
    JLabel label = new JLabel("송금하기");
    label.setHorizontalAlignment(JLabel.CENTER);
    this.add(label);

    textField = new JTextField(10);
    this.add(textField);

    JButton button = new JButton("송금");
    button.addActionListener(event -> {
      int transferAmount = Integer.parseInt(textField.getText());
      account.transfer(transferAmount);
      textField.setText("");
    });
    this.add(button);
  }
}



