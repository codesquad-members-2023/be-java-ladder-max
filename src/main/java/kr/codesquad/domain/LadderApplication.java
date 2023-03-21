package kr.codesquad.domain;

import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderApplication {


    public void startLadderGame(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Ladder ladder = new Ladder(inputView.getPlayerList(), inputView.getLadderHeight());
        outputView.printLadderGameShape((ladder.run()));
    }
}
