package kr.codesquad;

public class Application {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(InputView.inputPeopleNumber(), InputView.inputLadderHeight());
        Outputview.printLadder(ladder.makeLadder());
    }
}

