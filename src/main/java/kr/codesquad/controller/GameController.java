package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.PlayerGroup;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void runLadderGame() throws IOException {
        PlayerGroup playerGroup = new PlayerGroup(inputView.inputPlayerNames());
        Ladder ladder = new Ladder(playerGroup.getPlayerCount(), inputView.inputLadderHeight());
        outputView.printPlayerNames(playerGroup);
        outputView.printLadder(ladder);
    }

}
