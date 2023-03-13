package kr.codesquad.domain;

import kr.codesquad.view.Input;
import kr.codesquad.view.Output;

import java.io.IOException;

public class LadderGame {

    private Input input = new Input();
    private Output output = new Output();
    private Ladder ladder;

    public void run() {
        try {
            ladder = new Ladder(input.inputName(), input.inputResult(), input.inputHeight());
            output.printLadder(ladder);
            ladder.playLadderGame();

            while (true) {
                printResultByInput(input.inputNameCommand());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void printResultByInput(String inputName) {
        if (inputName.equals("all")) {
            ladder.printAllResult();
            return;
        }
        if (inputName.equals("춘식이")) {
            System.out.println("\n게임을 종료합니다.");
            System.exit(1);
        }

        ladder.printPlayerResult(inputName);
    }
}
