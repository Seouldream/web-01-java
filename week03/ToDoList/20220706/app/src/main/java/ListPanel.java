import javax.swing.*;
import java.awt.*;

public class ListPanel extends JPanel {
private ListPanel listPanel;
  ListPanel(Task task) {
    this.setBackground(Color.BLUE);


    JCheckBox checkBox = new JCheckBox(task.getTaskText());
    this.add(checkBox);

    JButton deleteButton = new JButton(" X ");
    this.add(deleteButton);



    }












}


