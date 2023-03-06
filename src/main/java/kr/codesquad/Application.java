package kr.codesquad;

public class Application {
    public static void main(String[] args) {
        int peopleNum = Integer.parseInt(Outputview.printPeopleFormat());
        int ladderCnt = Integer.parseInt(Outputview.printLadderHeightFormat());

        Ladder ladder = new Ladder(peopleNum, ladderCnt);
        ladder.makeBasicLadder();
        ladder.makeRandomLadderLine();
        ladder.showFinalLadder();

    }
}

