package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.Input;

import java.io.IOException;

public class Controller {

    private Input input = new Input();
    private Ladder ladder;

    public void run() {
        try {
            ladder = new Ladder(input.inputName(), input.inputResult(), input.inputHeight());
            ladder.printRadder();
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
        } else if (inputName.equals("춘식이")) {
            System.out.println("\n게임을 종료합니다.");
            System.exit(1);
        } else {
            ladder.printPlayerResult(inputName);
        }
    }
}
