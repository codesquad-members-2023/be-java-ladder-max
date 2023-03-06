package kr.codesquad.Controller;

import kr.codesquad.Domain.Ladder;
import kr.codesquad.View.OutputView;

public class LadderController {
    private Ladder ladder;
    public LadderController(){
        ladder = new Ladder();
    }
    public void run(){
        OutputView.printLadder(ladder.getLadder());
    }
}
