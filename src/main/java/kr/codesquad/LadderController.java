package kr.codesquad.controller;

import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderController {
    OutputView outputView;
    InputView inputView;

    public LadderController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void startLadderGame() {
        outputView.printJoinMembers();
        int joinMembers = inputView.userInput();
        outputView.printMaxHeight();
        int maxHeight = inputView.userInput();
    }
}