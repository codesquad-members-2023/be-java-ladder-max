package kr.codesquad;

import kr.codesquad.view.InputView;

public class Main {
    public static void main(String[] args) {
        LadderMaker ladderMaker = new LadderMaker();
        InputView inputView = new InputView();
        inputView.startLadderGame();
        ladderMaker.make(inputView.getNamesList(), inputView.getLadderHeight());
    }
}


