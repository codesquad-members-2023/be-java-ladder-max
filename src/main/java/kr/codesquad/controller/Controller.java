package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.Input;

import java.io.IOException;

public class Controller {

    public void run() {
        Input input = new Input();
        try {
            Ladder ladder = new Ladder(input.inputName(), input.inputResult(), input.inputHeight());
            ladder.printRadder();
            ladder.playLadderGame();
            ladder.printAllResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
