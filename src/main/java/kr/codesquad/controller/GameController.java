package kr.codesquad.controller;

import kr.codesquad.domain.LadderMaker;
import kr.codesquad.util.LadderRandomNumberGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class GameController {

    public void run() {
        int number = InputView.readNumberOfPeople();
        int size = InputView.readLadderSize();
        LadderMaker ladderMaker = new LadderMaker(new LadderRandomNumberGenerator());
        OutputView.printLadder(ladderMaker.makeLadder(number, size));
    }
}
