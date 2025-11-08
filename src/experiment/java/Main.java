import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("✨ Todo List Pro ✨");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        frame.setContentPane(mainPanel);

        // ======= HEADER =======
        JLabel title = new JLabel("My Daily Tasks");
        title.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(title, BorderLayout.NORTH);

        // ======= TASK AREA =======
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        taskList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskList.setFixedCellHeight(35);
        taskList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // ======= INPUT PANEL =======
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setBorder(new EmptyBorder(15, 0, 0, 0));

        JTextField taskField = new JTextField();
        taskField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        taskField.setPreferredSize(new Dimension(300, 35));
        taskField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        taskField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1, true),
                new EmptyBorder(5, 10, 5, 10)
        ));

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear All");

        Color accent = new Color(63, 81, 181); // Indigo 500
        JButton[] buttons = {addButton, deleteButton, clearButton};

        for (JButton b : buttons) {
            b.setFocusPainted(false);
            b.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
            b.setBackground(accent);
            b.setForeground(Color.WHITE);
            b.setBorderPainted(false);
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b.setOpaque(true);
            b.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    b.setBackground(accent.darker());
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    b.setBackground(accent);
                }
            });
        }

        inputPanel.add(taskField);
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        inputPanel.add(addButton);
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        inputPanel.add(deleteButton);
        inputPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        inputPanel.add(clearButton);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // ======= ACTIONS =======
        addButton.addActionListener((ActionEvent e) -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement("• " + task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a task!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Select a task to delete!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        clearButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to clear all tasks?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) listModel.clear();
        });

        frame.setVisible(true);
    }
}
