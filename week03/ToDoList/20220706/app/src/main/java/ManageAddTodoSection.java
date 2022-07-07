import javax.swing.*;

public class ManageAddTodoSection {
  private JTextField todoTextField;
  private JPanel menuPanel;
  private JPanel contentPanel;
  private Task task;
  private String todoContent;

  ManageAddTodoSection(JPanel menuPanel,JPanel contentPanel,Task task) {
    this.menuPanel = menuPanel;
    this.contentPanel = contentPanel;
    this.task = task;

    todoTextField = new JTextField(10);

    JLabel todoLabel = new JLabel("할 일: ");


    menuPanel.add(todoLabel);

    menuPanel.add(todoTextField);

    createAddButton();
  }

  private void createAddButton() {
    JButton addButton = new JButton("추가");
    menuPanel.add(addButton);
    addButton.addActionListener(event -> {
      todoContent = todoTextField.getText();
      task.getTaskText(todoContent);

      JPanel listPanel = new ListPanel(task);
      contentPanel.add(listPanel);
      contentPanel.setVisible(false);
      contentPanel.setVisible(true);


    });
  }


}
