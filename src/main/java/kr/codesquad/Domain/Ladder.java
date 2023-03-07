package kr.codesquad.Domain;

import kr.codesquad.Util.LadderMaker;
import kr.codesquad.View.InputView;

import java.util.List;

public class Ladder {
    private List<Line> ladder;
    private LadderMaker ladderMaker;
    public List<Line> getLadder() {
        return ladderMaker.makeLadder(InputView.getLadderWidth(), InputView.getLadderHeight());
    }

    public Ladder(){
        ladderMaker = new LadderMaker();
    }
}
