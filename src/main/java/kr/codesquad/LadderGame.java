package kr.codesquad;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public void run() {
        Screen.printResult(ladder.createOutputLines());
    }
}
