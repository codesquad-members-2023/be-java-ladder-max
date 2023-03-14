package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Line;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class LadderGame {

    public void run() throws IOException {
        OutputView.printMessageNames();
        String names = InputView.inputNames();

        OutputView.printMessageLadderNumber();
        String ladderNumber = InputView.inputLadderNumber();

        GameController gameController = new GameController(names, ladderNumber);
        String result = gameController.start();

        OutputView.printLadder(result);
    }
}
