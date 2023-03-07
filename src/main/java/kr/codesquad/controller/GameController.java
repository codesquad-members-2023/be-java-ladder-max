package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void runLadderGame() throws IOException {
        int playerCount = inputView.inputPlayerCount();
        int ladderHeight = inputView.inputLadderHeight();
        Ladder ladder = new Ladder(playerCount, ladderHeight);
        outputView.printLadder(ladder);

    }
}
