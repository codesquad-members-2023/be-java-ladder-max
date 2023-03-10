package main.java.kr.codesquad.step1;

public class GameMaker {
    public void gameStart() {
        OutputView.printAskParticipatePeople();
        int participatePeople = InputView.inputParticipatePeople();
        OutputView.printNumTheMostLadderHeight();
        int ladderHeight = InputView.inputNumTheMostLadderHeight();
        Ladder ladder = new Ladder(participatePeople, ladderHeight);
        System.out.println(ladder.createLadder());
    }
}
