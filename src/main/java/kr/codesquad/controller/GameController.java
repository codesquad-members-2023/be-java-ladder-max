package kr.codesquad.controller;

import kr.codesquad.domain.LadderMaker;
import kr.codesquad.domain.Players;
import kr.codesquad.util.LadderRandomNumberGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class GameController {

    public void run() {
        Players players = new Players(InputView.readPlayers());
        int size = InputView.readLadderSize();
        LadderMaker ladderMaker = new LadderMaker(new LadderRandomNumberGenerator());
        OutputView.printLadder(players.names(), ladderMaker.makeLadder(players.number(), size));
    }
}
