package ladder;

public class Worker {
    private final InputView inputView;
    private Ladder ladder;
    private String[] participants;

    public Worker() {
        this.inputView = new InputView();
    }

    public void makeLadder() {
        this.participants = inputView.getNamesOfParticipants();
        int space = participants.length - 1;
        int height = inputView.getNumberOfLadderHeight();
        ladder = new Ladder(space, height);
    }

    private void makeNameLabel() {
        StringBuilder builder = new StringBuilder();
        for (String participant : participants) {
            builder.append(" ".repeat((6 - participant.length()) / 2));
            builder.append(participant);
            builder.append(" ".repeat((6 - participant.length()) % 2));
        }
        System.out.println(builder);
    }

    public void showLadder() {
        makeNameLabel();
        ladder.drawLadder();
        inputView.stop();
    }

}
