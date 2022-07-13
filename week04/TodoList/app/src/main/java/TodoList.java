//상위 젤 위 레이블 하나 -> 보더레이아웃 페이지 스타트 ok
// 다시 전체 패널 하나 생성 (백그라운드 패널) ok
// 할일 레이블 , 텍스트필드, 추가 버턴 -> 플로레이아웃(기본 디폴트) -> 담을 패널 필요(메뉴패널) 에서
// 페이지 스타트
// 컨텐츠 패널 생성 -> 백그라운드위에 얹힘 그리고 센터 위치

//컨텐트 패널위에서 의 작업
//추가 버튼을 누를때 마다
// 1체크 박스 텍스트 레이블 삭제버튼 을 담은 패널이 생성됨 (패널의 방향은 위에서 아래로 차례)
//컨텐트 패널이 그리드레이아웃으로 되어야함. -> 세팅 완료

//버튼 액션 리스너 정의
//삭제버튼 구현




import javax.swing.*;
import java.awt.*;

public class TodoList {
  private JFrame frame;
  private JPanel backgroundPanel;
  private JPanel contentPanel;

  public static void main(String[] args) {
    TodoList application = new TodoList();
    application.run();
  }

  public void run() {
    createMainFrame();

    createTitleLabel();

    createBackgroundPanel();

    createMenuPanel();

    createContentPanel();



    frame.setVisible(true);
  }

  private void createContentPanel() {
    contentPanel = new JPanel();
    backgroundPanel.add(contentPanel);
    contentPanel.setBackground(Color.ORANGE);
    contentPanel.setLayout(new GridLayout(5,1));
  }

  private void createMainFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,500);
  }

  private void createTitleLabel() {
    JLabel label = new JLabel("할 일 목록");
    frame.add(label, BorderLayout.PAGE_START);
    label.setHorizontalAlignment(JLabel.CENTER);
  }

  private void createBackgroundPanel() {
    backgroundPanel = new JPanel();
    frame.add(backgroundPanel,BorderLayout.CENTER);
    backgroundPanel.setBackground(Color.CYAN);
    backgroundPanel.setLayout(new BorderLayout());
  }

  private void createMenuPanel() {
    JPanel panel = new JPanel();
    backgroundPanel.add(panel,BorderLayout.PAGE_START);
    panel.setBackground(Color.BLUE);


    JLabel label = new JLabel("할 일: ");
    panel.add(label);

    JTextField todoTextField = new JTextField(13);
    panel.add(todoTextField);

    JButton button = new JButton(" 추가 ");
    panel.add(button);
    button.addActionListener(event -> {

      createIndividualTodoPanel(todoTextField);

    });
  }

  private void createIndividualTodoPanel(JTextField textField) {
    JPanel individualTodoPanel = new JPanel();

    JCheckBox checkBox = new JCheckBox(textField.getText());
    individualTodoPanel.add(checkBox);

    JButton deleteButton = new JButton("  X  ");
    deleteButton.addActionListener(event-> {
      contentPanel.remove(individualTodoPanel);
      contentPanel.setVisible(false);
      contentPanel.setVisible(true);
    });

    individualTodoPanel.add(deleteButton);


    contentPanel.add(individualTodoPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }
}
