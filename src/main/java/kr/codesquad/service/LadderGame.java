package kr.codesquad.service;

import kr.codesquad.domain.Ladder;
import kr.codesquad.view.Screen;

import java.util.ArrayList;
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
        final int height = inputLadderHeight();

        final Ladder ladder = ladderGenerator.generate(playerNames.size(), height);

        showResult(playerNames, ladder);
    }

    private void showResult(List<String> playerNames, Ladder ladder) {
        final List<String> result = new ArrayList<>();

        screen.printResult(playerNames, ladder.createOutputLines());
    }

    private int inputLadderHeight() {
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
