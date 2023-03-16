package kr.codesquad;

import javax.swing.*;

public class MainForGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField textField2;
    private JTextField textField1;
    private JButton startButton;
    private JTextArea ladderTextArea;
    private JTextArea resultTextArea;
    private JLabel playerNameLabel;
    private JLabel destinationLabel;
    private JLabel ladderLabel;
    private JLabel resultLabel;

    public MainForGUI() {
        setContentPane(mainPanel);
        setTitle("Ape의 사다리 게임");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainForGUI myFrame = new MainForGUI();
    }
}
