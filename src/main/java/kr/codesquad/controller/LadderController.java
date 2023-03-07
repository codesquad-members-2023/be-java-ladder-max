package kr.codesquad.controller;

import kr.codesquad.model.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderController {
    private final InputView inputView;

    public LadderController() {
        inputView = new InputView();
    }

    public void run() {
        int n = inputView.getN();
        int maxHeight = inputView.getMaxHeight();
        Ladder ladder = new Ladder(n, maxHeight);
        ladder.generateLegs();
        OutputView.printLadder(ladder);
    }
}
