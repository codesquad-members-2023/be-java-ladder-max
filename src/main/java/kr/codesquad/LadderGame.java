package kr.codesquad;

public class LadderGame {
    private final Ladder ladder;

    private LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public LadderGame() {
        this(new Ladder(Screen.inputPlayerNumber(), Screen.inputLadderHeight()));
    }

    public void run() {
        ladder.print();
    }
}
