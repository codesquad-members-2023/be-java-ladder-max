package kr.codesquad.controller;

import kr.codesquad.service.LadderGame;
import kr.codesquad.view.Screen;

import java.util.List;
import java.util.Optional;

public class LadderGameController {
    private final LadderGame ladderGame;
    private final Screen screen;

    private LadderGameController(LadderGame ladderGame, Screen screen) {
        this.ladderGame = ladderGame;
        this.screen = screen;
    }

    public LadderGameController() {
        this(new LadderGame(), new Screen());
    }

    public void run() {
        final List<String> playerNames = inputPlayerNames();
        final int height = inputLadderHeight();

        ladderGame.makeLadder(playerNames.size(), height);
        showResult(playerNames);
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

    private void showResult(List<String> playerNames) {
        screen.printResult(playerNames, ladderGame.toLadderShape());
    }
}
