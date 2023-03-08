package ladder.domain;

public class LadderGame {
    private final Worker worker;

    public LadderGame() {
        this.worker = new Worker();
    }

    public void start() {
        worker.makeLadder();
        worker.showLadder();
    }
}
