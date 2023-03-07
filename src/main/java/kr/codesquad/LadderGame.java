package kr.codesquad;

import java.util.List;

public class LadderGame {
    private final List<String> playerNames;
    private final LadderV2 ladder;

    public LadderGame() {
        playerNames = Screen.inputPlayerNames();
        ladder = new LadderV2(playerNames.size(), Screen.inputLadderHeight());
    }

    public void run() {
        Screen.printResult(playerNames, ladder.createOutputLines());
    }
}
