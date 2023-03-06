package ladder;

public class Worker {
    private InputView inputView;
    private Ladder ladder;

    public Worker() {
        this.inputView = new InputView();
    }

    public void makeLadder() {
        int participants = inputView.getNumberOfParticipants();
        int height = inputView.getNumberOfLadderHeight();
        this.ladder = new Ladder(participants, height);
    }
}
