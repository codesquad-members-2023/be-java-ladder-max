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
        makeGame();
        printGame();
        reportResult();
    }

    private void makeGame() {
        String[] names = setPlayers();
        setLadder(players.getNumberOfPlayers());
        setResults(names);
    }

    private void setResults(String[] names) {
        while (results == null) {
            try {
                results = new Results(view.getCategories(), players.getNumberOfPlayers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < players.getNumberOfPlayers(); i++) {
            results.addResult(names[i], ladder.rideLadder(i));
        }
    }

    private void setLadder(int numberOfPlayers) {
        while (ladder == null) {
            try {
                int height = view.getLadderHeight();
                ladder = new Ladder(numberOfPlayers, height);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] setPlayers() {
        String[] names = view.getNamesOfPlayers();
        while (players == null) {
            try {
                players = new Players(names);
                return names;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                names = view.getNamesOfPlayers();
            }
        }
        return names;
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
            try {
                view.print(results.findResultByName(name));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            name = view.getPlayerNameForResult();
        }
        view.stop();
    }
}
