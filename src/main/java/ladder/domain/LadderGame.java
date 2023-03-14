package ladder.domain;

import ladder.view.View;

public class LadderGame {
    private final View view;
    private Ladder ladder;
    private Players players;
    private Results results;

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
        reportResult();
    }

    private void makeGame() {
        final String[] names = view.getNamesOfPlayers();
        players = new Players(names);
        final int numberOfPlayers = players.getNumberOfPlayers();
        final int height = view.getLadderHeight();
        results = new Results(view.getCategories());
        ladder = new Ladder(numberOfPlayers, height);
        ladder.makeLadder();
        for (int i = 0; i < numberOfPlayers; i++) {
            results.addResult(names[i], ladder.rideLadder(i));
        }
    }

    private void printGame() {
        final int LABEL_SIZE = 6;
        String game = System.lineSeparator() +
                players.makeNameLabels(LABEL_SIZE) +
                ladder.drawLadder() +
                results.makeResultLabels(LABEL_SIZE);
        view.print(game);
    }

    private void reportResult() {
        String name = view.getPlayerNameForResult();
        while (!name.equals("exit")) {
            view.print(results.findResultByName(name));
            name = view.getPlayerNameForResult();
        }
        view.stop();
    }
}
