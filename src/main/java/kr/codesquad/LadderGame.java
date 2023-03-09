package kr.codesquad;

import java.util.List;
import java.util.Optional;

public class LadderGame {
    private final LadderGenerator ladderGenerator;
    private final Screen screen;

    public LadderGame(LadderGenerator ladderGenerator, Screen screen) {
        this.ladderGenerator = ladderGenerator;
        this.screen = screen;
    }

    public void run() {
        final List<String> playerNames = inputPlayerNames();
        final Integer ladderHeight = inputLadderHeight();
    }

    private Integer inputLadderHeight() {
        Optional<Integer> ladderHeight = Optional.empty();

        while (ladderHeight.isEmpty()) {
            ladderHeight = screen.inputLadderHeight();
        }

        return ladderHeight.get();
    }

    private List<String> inputPlayerNames() {
        Optional<List<String>> playerNames = Optional.empty();

        while (playerNames.isEmpty()) {
            playerNames = screen.inputPlayerNames();
        }

        return playerNames.get();
    }
}
