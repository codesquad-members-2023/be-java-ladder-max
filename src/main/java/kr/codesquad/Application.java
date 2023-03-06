package kr.codesquad;

public class Application {
    public static void main(String[] args) {
        int peopleNum = Integer.parseInt(InputView.inputPeople());
        int ladderCnt = Integer.parseInt(InputView.inputLadderHeight());

        Ladder ladder = new Ladder(peopleNum, ladderCnt);
        ladder.makeBasicLadder();
        ladder.makeRandomLadderLine();
        ladder.showFinalLadder();

    }
}

