import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ToDoManagerGUI extends JFrame {
    private JFrame mainFrame;
    private List<String> tasks;
    private JFrame loginFrame;
    private JFrame signupFrame;
    private JFrame recentTasksFrame;

    public ToDoManagerGUI() {
        tasks = new ArrayList<>();
        createWelcomeFrame();
    }

    private void createWelcomeFrame() {
        JFrame welcomeFrame = new JFrame("Welcome");
        welcomeFrame.setSize(400, 300);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("Welcome to Jam's To Do List  Manager");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Sign Up");

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(welcomeLabel);
        panel.add(loginButton);
        panel.add(signupButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.setVisible(false);
                showLoginForm();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeFrame.setVisible(false);
                showSignupForm();
            }
        });

        welcomeFrame.add(panel);
        welcomeFrame.setVisible(true);
    }

    private void createMainFrame() {
        mainFrame = new JFrame("Jam's To-Do Manager");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(6, 1));

        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton markButton = new JButton("Mark Task");
        JButton setReminderButton = new JButton("Set Reminder");
        JButton viewTasksButton = new JButton("View Recent Tasks");

        mainFrame.add(new JLabel("Enter Task:"));
        mainFrame.add(taskField);
        mainFrame.add(addButton);
        mainFrame.add(deleteButton);
        mainFrame.add(markButton);
        mainFrame.add(setReminderButton);
        mainFrame.add(viewTasksButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                tasks.add(task);
                JOptionPane.showMessageDialog(mainFrame, "Task added: " + task);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                tasks.remove(task);
                JOptionPane.showMessageDialog(mainFrame, "Task deleted: " + task);
            }
        });

        markButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                JOptionPane.showMessageDialog(mainFrame, "Task marked: " + task);
            }
        });

        setReminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                JOptionPane.showMessageDialog(mainFrame, "Reminder set for task: " + task);
            }
        });

        viewTasksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRecentTasks();
            }
        });

        mainFrame.setVisible(true);
    }

    private void showRecentTasks() {
        StringBuilder taskList = new StringBuilder();
        for (String task : tasks) {
            taskList.append(task).append("\n");
        }

        if (recentTasksFrame != null) {
            recentTasksFrame.dispose();
        }

        recentTasksFrame = new JFrame("Recent Tasks");
        JTextArea taskTextArea = new JTextArea(10, 20);
        taskTextArea.setText(taskList.toString());
        taskTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(taskTextArea);

        recentTasksFrame.add(scrollPane);
        recentTasksFrame.pack();
        recentTasksFrame.setLocationRelativeTo(mainFrame);
        recentTasksFrame.setVisible(true);
    }

    private void showLoginForm() {
        loginFrame = new JFrame("Login");
        loginFrame.setSize(300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                JOptionPane.showMessageDialog(loginFrame,
                        "Login with Username: " + username + " and Password: " + String.valueOf(password));
                loginFrame.setVisible(false);
                createMainFrame();
            }
        });

        loginFrame.add(panel);
        loginFrame.setVisible(true);
    }

    private void showSignupForm() {
        signupFrame = new JFrame();
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        JButton signupButton = new JButton("Sign Up");

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(signupButton);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                JOptionPane.showMessageDialog(signupFrame,
                        "Signup with Username: " + username + " and Password: " + String.valueOf(password));
                signupFrame.setVisible(false);
                createMainFrame();
            }
        });

        signupFrame.add(panel);
        signupFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoManagerGUI();
    }
}
