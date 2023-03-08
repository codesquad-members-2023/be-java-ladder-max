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
            int frontBlank = (6 - participant.length()) / 2;
            int backBlank = (6 - participant.length()) % 2;
            boolean isNotMaxLength = participant.length() < 6;
            builder.append(" ".repeat(frontBlank));
            builder.append(participant);
            builder.append(" ".repeat(frontBlank == 0 && isNotMaxLength ? backBlank : frontBlank));
        }
        System.out.println(builder);
    }

    public void showLadder() {
        makeNameLabel();
        ladder.drawLadder();
        inputView.stop();
    }
}
