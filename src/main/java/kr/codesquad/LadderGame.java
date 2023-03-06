package kr.codesquad;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame() {
        ladder = new Ladder(Screen.inputPlayerNumber(), Screen.inputLadderHeight());
    }

    public void run() {
        Screen.printLadderMap(ladder.makeMapToString());
    }
}
