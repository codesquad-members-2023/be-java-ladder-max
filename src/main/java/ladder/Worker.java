package ladder;

public class Worker {
    private final InputView inputView;
    private Ladder ladder;

    public Worker() {
        this.inputView = new InputView();
    }

    public void makeLadder() {
        int participants = inputView.getNumberOfParticipants();
        int height = inputView.getNumberOfLadderHeight();
        ladder = new Ladder(participants, height);
    }

    public void showLadder() {
        ladder.drawLadder();
        inputView.stop();
    }

}
