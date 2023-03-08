package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Players;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void runLadderGame() throws IOException {
        Players players = new Players(inputView.inputPlayerNames());
        Ladder ladder = new Ladder(players.getPlayerCount(), inputView.inputLadderHeight());
        outputView.printPlayerNames(players);
        outputView.printLadder(ladder);
    }

}
