package kr.codesquad.domain;

import kr.codesquad.view.InputView;

public class LadderApplication {

    public void startLadderGame(){
        InputView inputView = new InputView();
        Ladder ladder = new Ladder(inputView.getPlayerList(), inputView.getLadderHeight());
        ladder.run();
    }
}
