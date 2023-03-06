package ladder;

public class LadderGame {
    private final Worker worker;

    public LadderGame() {
        this.worker = new Worker();
    }

    public void start() {
        worker.makeLadder();
        worker.showLadder();
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }
}
