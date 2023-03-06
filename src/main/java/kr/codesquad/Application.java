package kr.codesquad;

public class Application {
    public static void main(String[] args) {
        int peopleNum = Integer.parseInt(InputView.inputPeople());
        int ladderCnt = Integer.parseInt(InputView.inputPeople());

        Ladder ladder = new Ladder(peopleNum, ladderCnt);
        ladder.makeLadderMap();
        ladder.showTotalLadder();

    }
}

