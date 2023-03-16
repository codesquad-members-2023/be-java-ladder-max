package kr.codesquad;

import kr.codesquad.controller.GUIGameController;
import kr.codesquad.domain.destination.DestinationGroup;
import kr.codesquad.domain.ladder.Ladder;
import kr.codesquad.domain.player.PlayerGroup;
import kr.codesquad.domain.result.Result;
import kr.codesquad.domain.result.ResultGroup;
import kr.codesquad.exception.GameProgressException;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ContainerAdapter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainForGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField destinationNamesTextField;
    private JTextField playerNamesTextField;
    private JButton startButton;
    private JTextArea ladderTextArea;
    private JTextArea resultTextArea;
    private JLabel playerNamesLabel;
    private JLabel destinationsLabel;
    private JLabel ladderLabel;
    private JLabel resultLabel;
    private JLabel heightLabel;
    private JTextField heightTextField;
    private JLabel paddingLabel;

    private InputView inputView = new InputView(System.in);
    private OutputView outputView = new OutputView();

    public MainForGUI() {
        setContentPane(mainPanel);
        setTitle("Ape의 사다리 게임");
        setSize(900,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);

        /**
         * [시작하기] 버튼 클릭
         */
        startButton.addActionListener(new ActionListener() {
            public String makeInputValue() {
                StringBuilder sb = new StringBuilder();
                sb.append(playerNamesTextField.getText()).append(System.lineSeparator())
                        .append(destinationNamesTextField.getText()).append(System.lineSeparator())
                        .append(heightTextField.getText());
                return sb.toString();
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream is = new ByteArrayInputStream(makeInputValue().getBytes());
                    GUIGameController controller = new GUIGameController(is);
                    ladderTextArea.setText(controller.renderLadder());
                    resultTextArea.setText(controller.renderResults());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

    }


    public static void main(String[] args) {
        MainForGUI myFrame = new MainForGUI();
    }
}
