package ladder.domain;

import ladder.view.View;

public class LadderGame {
    private final View view;
    private Ladder ladder;
    private Players players;

    public LadderGame() {
        this.view = new View();
    }

    public void start() {
        try {
            makeGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeGame();
        }
        printGame();
    }

    private void makeGame() {
        players = new Players(view.getNamesOfParticipants());
        final int width = players.getNumberOfPlayers() - 1;
        final int height = view.getLadderHeight();
        ladder = new Ladder(width, height);
        ladder.makeLadder();
    }

    private void printGame() {
        final int LABEL_SIZE = 6;
        String builder = players.makeNameLabels(LABEL_SIZE) +
                ladder.drawLadder();
        view.print(builder);
        view.stop();
    }
}
