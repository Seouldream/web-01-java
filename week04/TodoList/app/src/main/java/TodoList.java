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
//삭제버튼 구현 완료
//텍스트 클릭시 체크 완료(? 구동한적없는데 아하 체크 박스가 자체 텍스트니까)
//사용자는 프로그램을 종료했다가 실해시켜도 이전 저장..불러올수있다
//1.csv 에서 파일을 한줄씩 일어온다
//2.파싱을 할필요가없네 암튼 가져온걸 한줄씩 넣어준다 -> 리스트 개념필요 todos or tasks
//3.어떻게 넣을거냐 ? 체크박스에  있는 텍스트들을 리스트화 시킨다
//어떻게 가져올거냐? 한줄씩 읽어온 리스트들이 패널을 구성하게 만든다 1번

//정리 -> 임의로 csv 파일에 할일을 입력후 가져오는 기능 먼저 구현 1.-> 완료
// 버튼으로 추가 삭제 되는지 , 가져온 텍스트들을 버튼패널로 만들기 -> 기존 버튼 추가와 가져온파일은
// 혼선도 많고 처리해야할 변수도 많아서 일단은 따로 분리시킴(빠른 결과물을 낼 수 있음)

//다음스텝 쓴 기록 가져와 파일로 만들기
//파일라이터 준비


import models.*;
import org.checkerframework.checker.units.qual.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class TodoList {
  private JFrame frame;
  private JPanel backgroundPanel;
  private JPanel contentPanel;
  private static List<Task> tasksForSaving = new ArrayList<>();


  public static void main(String[] args) throws IOException {
    TodoList application = new TodoList();
    application.run();
  }

  public void run() throws IOException {
    createMainFrame();

    createTitleLabel();

    createBackgroundPanel();

    createMenuPanel();

    createContentPanel();

    List<Task> tasks = loadTasks();

    uploadTasks(tasks);

    frame.setVisible(true);

    SaveFile saveFile = new SaveFile();
  }

  /*public List<Task> saveTodosAsFile() throws IOException {

    FileWriter fileWriter = new FileWriter("output.csv");

    for(Task task : tasksForSaving) {
      String line = task.task();
      fileWriter.write(line + "\n");
    }

    fileWriter.close();
  }*/

  private void uploadTasks(List<Task> tasks) {
    for(Task task : tasks) {
      createIndividualTodoPanel(task);
    }
  }

  public List<Task> loadTasks() throws FileNotFoundException {
    List<Task> tasks = new ArrayList<>();

    File file = new File("input.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {

      String line = scanner.nextLine();

      Task task = new Task(line);

      tasks.add(task);

    }
    return tasks;
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

  public void createIndividualTodoPanel(JTextField textField) {

    tasksForSaving.add(new Task(textField.getText()));

    JPanel individualTodoPanel = new JPanel();

    JCheckBox checkBox = new JCheckBox(textField.getText());
    individualTodoPanel.add(checkBox);

    JButton deleteButton = new JButton("  X  ");
    deleteButton.addActionListener(event-> {
      contentPanel.remove(individualTodoPanel);
      contentPanel.setVisible(false);
      contentPanel.setVisible(true);
      //해당되는 '그' 것을 지워라 과연될까 ?
      tasksForSaving.remove(new Task(textField.getText()));
    });

    individualTodoPanel.add(deleteButton);

    contentPanel.add(individualTodoPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }

  public void createIndividualTodoPanel(Task task) {

    tasksForSaving.add(new Task(task.task()));

    JPanel individualTodoPanel = new JPanel();

    JCheckBox checkBox = new JCheckBox(task.task());
    individualTodoPanel.add(checkBox);

    JButton deleteButton = new JButton("  X  ");
    deleteButton.addActionListener(event-> {

      contentPanel.remove(individualTodoPanel);
      contentPanel.setVisible(false);
      contentPanel.setVisible(true);
      tasksForSaving.remove(new Task(task.task()));
    });

    individualTodoPanel.add(deleteButton);

    contentPanel.add(individualTodoPanel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
  }

}
