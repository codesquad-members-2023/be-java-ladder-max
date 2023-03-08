package kr.codesquad;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class Main {
    public static void main(String[] args) {
        int numberOfUsers = InputView.inputNumberOfUsers();
        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(numberOfUsers, ladderHeight);
        OutputView.printLadder(ladder);
        InputView.close();
    }
}
