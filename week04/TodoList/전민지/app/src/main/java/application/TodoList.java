package application;

import models.Tasks;
import panels.FormPanel;
import panels.TasksPanel;
import utils.TasksLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class TodoList {
  private Tasks tasks;

  private JFrame frame;
  private JPanel headerPanel;
  private JPanel contentPanel;
  private TasksPanel tasksPanel;

  public static void main(String[] args) throws IOException {
    TodoList application = new TodoList();
    application.run();
  }

  public TodoList() throws IOException {
    tasks = new Tasks();
  }

  public void run() {
    initFrame();

    initContentPanel(tasks);

    initHeader();

    saveTasks();
  }

  public void initFrame() {
    frame = new JFrame("Todo List");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);
    frame.setVisible(true);
  }

  public void initContentPanel(Tasks tasks) {
    contentPanel = new JPanel();
    tasksPanel = new TasksPanel(tasks);
    contentPanel.add(tasksPanel);
    frame.add(contentPanel);
    frame.setVisible(true);
  }

  public void initHeader() {
    createHeaderPanel();

    createTitleLabel();

    createForm();
  }

  public void createHeaderPanel() {
    headerPanel = new JPanel();
    headerPanel.setLayout(new BorderLayout());
    frame.add(headerPanel, BorderLayout.PAGE_START);
  }

  public void createTitleLabel() {
    JLabel titleLabel = new JLabel("할 일 목록");
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    headerPanel.add(titleLabel, BorderLayout.PAGE_START);
  }

  public void createForm() {
    FormPanel formPanel = new FormPanel(tasks, tasksPanel);
    headerPanel.add(formPanel);
  }

  public void showContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);

    panel.setVisible(false);
    panel.setVisible(true);

    frame.setVisible(true);
  }

  public void saveTasks() {
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        TasksLoader tasksLoader = new TasksLoader();
        try {
          tasksLoader.saveTasks(tasks);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    });
  }
}
