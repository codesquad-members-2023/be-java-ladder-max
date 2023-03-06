package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class GameController {

    private Ladder ladder = new Ladder();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void runApplication() throws IOException {
        int playerCount = inputView.inputPlayerCount();
        int ladderHeight = inputView.inputLadderHeight();
        String[][] newLadder = ladder.makeLadder(playerCount, ladderHeight);
        outputView.printLadder(newLadder);

    }
}
