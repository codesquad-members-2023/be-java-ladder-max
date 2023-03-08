package kr.codesquad;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderHeight;
import kr.codesquad.domain.Users;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Users users = InputView.inputNumberOfUsers();
        LadderHeight ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(users, ladderHeight);
        OutputView.printUsers(users);
        OutputView.printLadder(ladder);
        InputView.close();
    }
}
