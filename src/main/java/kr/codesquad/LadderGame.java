package kr.codesquad;

import java.util.List;

public class LadderGame {
    private final List<String> playerNames;
    private final Ladder ladder;

    public LadderGame() {
        playerNames = Screen.inputPlayerNames();
        ladder = new Ladder(playerNames.size(), Screen.inputLadderHeight());
    }

    public void run() {
        Screen.printResult(playerNames, ladder.makeMapToString());
    }
}
