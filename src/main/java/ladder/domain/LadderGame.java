package ladder.domain;

import ladder.view.View;

public class LadderGame {
    private final View view;
    private Ladder ladder;

    public LadderGame() {
        this.view = new View();
    }

    public void makeLadder(int space, int height) {
        ladder = new Ladder(space, height);
        ladder.makeRandomLadder();
    }

    public String makeNameLabel(String[] names) {
        StringBuilder builder = new StringBuilder();
        for (String name : names) {
            int frontBlank = (6 - name.length()) / 2;
            int backBlank = (6 - name.length()) % 2;
            boolean isNotMaxLength = name.length() < 6;
            builder.append(" ".repeat(frontBlank));
            builder.append(name);
            builder.append(" ".repeat(frontBlank == 0 && isNotMaxLength ? backBlank : frontBlank));
        }
        return builder.toString();
    }

    public void start() {
        String[] participants = view.getNamesOfParticipants();
        int space = participants.length - 1;
        int height = view.getNumberOfLadderHeight();
        makeLadder(space, height);
        view.printLadder(makeNameLabel(participants), ladder.drawLadder());
        view.stop();
    }
}
