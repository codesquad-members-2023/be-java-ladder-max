package ladder.domain;

import ladder.view.View;

public class Worker {
    private final View view;
    private Ladder ladder;
    private String[] participants;

    public Worker() {
        this.view = new View();
    }

    public void makeLadder() {
        this.participants = view.getNamesOfParticipants();
        int space = participants.length - 1;
        int height = view.getNumberOfLadderHeight();
        ladder = new Ladder(space, height);
        ladder.makeRandomLadder();
    }

    private String makeNameLabel() {
        StringBuilder builder = new StringBuilder();
        for (String participant : participants) {
            int frontBlank = (6 - participant.length()) / 2;
            int backBlank = (6 - participant.length()) % 2;
            boolean isNotMaxLength = participant.length() < 6;
            builder.append(" ".repeat(frontBlank));
            builder.append(participant);
            builder.append(" ".repeat(frontBlank == 0 && isNotMaxLength ? backBlank : frontBlank));
        }
        return builder.toString();
    }

    public void showLadder() {
        view.printLadder(makeNameLabel(), ladder.drawLadder());
        view.stop();
    }
}
