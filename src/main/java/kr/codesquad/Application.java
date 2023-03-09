package kr.codesquad;

import kr.codesquad.domain.LadderColumn;
import kr.codesquad.view.InputView;
import kr.codesquad.view.Outputview;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Ladder ladder = new Ladder();
        ladder.makeLadder(inputView.inputPeopleSize(),inputView.inputLadderHeight());
        Outputview outputview = new Outputview();
        outputview.printLadder(ladder.getLadder());
        inputView.close();
    }
}

