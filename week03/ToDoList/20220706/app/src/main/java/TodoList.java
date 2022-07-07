import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class TodoList {
  private JFrame frame;
  private JPanel backgroundPanel;
  private JPanel menuPanel;
  private JPanel contentPanel;

  private Task task;
  private TaskRepository taskRepository;
  private JTextField textField;


  public static void main(String[] args) {
    TodoList application = new TodoList();
    application.run();
  }


  public void run() {
    task = new Task();
    taskRepository = new TaskRepository();
      SetUpFrame();
      //프레임에 바탕 패널 깔아주기
      createBackgroundPanel();
      //메인 제목 레이블
      createTitleLabel();
      //메뉴 패널
      initMenuPanel();
      //컨텐츠 패널
      initContentPanel();

      frame.setVisible(true);
    }



  public void SetUpFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);

    frame.getContentPane().setBackground(Color.YELLOW);
  }

  public void createTitleLabel() {
    JLabel titleLabel = new JLabel("할 일 목록");
    frame.add(titleLabel, BorderLayout.PAGE_START);
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
  }

  public void createBackgroundPanel() {
    backgroundPanel = new JPanel();
    backgroundPanel.setLayout(new BorderLayout());
    frame.add(backgroundPanel);
  }


  public void initMenuPanel() {
    menuPanel = new JPanel();
    backgroundPanel.add(menuPanel, BorderLayout.NORTH);

    textField = new JTextField(10);

    JLabel todoLabel = new JLabel("할 일");
    menuPanel.add(todoLabel);

    menuPanel.add(textField);

    createAddButton();
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setLayout(new GridLayout(10,1));
    backgroundPanel.add(contentPanel, BorderLayout.CENTER);

  }

  private void createAddButton() {
    JButton addButton = new JButton("추가");
    menuPanel.add(addButton);
    addButton.addActionListener(event -> {

      JPanel listPanel = new ListPanel(task,taskRepository);
      contentPanel.setBackground(Color.DARK_GRAY);

      contentPanel.add(listPanel);
      contentPanel.setVisible(false);
      contentPanel.setVisible(true);
      frame.setVisible(true);
    });
  }
}
