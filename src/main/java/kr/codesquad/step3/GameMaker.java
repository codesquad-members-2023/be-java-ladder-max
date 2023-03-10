package kr.codesquad.step3;

import java.util.List;

public class GameMaker {
    public void gameStart() {
        OutputView.printAskParticipatePeopleName();
        String participatePeopleNames = InputView.inputParticipatePeopleName();
        List<Participate> participates = Util.splitParticipatePeopleNameLine(participatePeopleNames);
        OutputView.printNumTheMostLadderHeight();
        int ladderHeight = InputView.inputNumTheMostLadderHeight();
        Ladder ladder = new Ladder(participates.size(), ladderHeight);
        System.out.println(ladder.generateLadder());
    }
}
