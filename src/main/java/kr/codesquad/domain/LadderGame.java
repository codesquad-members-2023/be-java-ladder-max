package kr.codesquad.domain;

import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGame {

    public void run() {
        Users users = InputView.inputNumberOfUsers();
        LadderHeight ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(users, ladderHeight);
        OutputView.printUsers(users);
        OutputView.printLadder(ladder);
        InputView.close();
    }
}
