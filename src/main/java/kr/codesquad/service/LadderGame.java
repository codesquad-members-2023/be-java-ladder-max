package kr.codesquad.service;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderLine;
import kr.codesquad.domain.LadderPart;
import kr.codesquad.view.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LadderGame {
    private final Screen screen;
    private Ladder ladder;

    public LadderGame(Screen screen) {
        this.screen = screen;
    }

    public void makeLadder(int playerNumber, int height) {
        final List<LadderLine> ladderLines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladderLines.add(makeLadderLine(playerNumber));
        }

        this.ladder = new Ladder(ladderLines);
    }

    private LadderLine makeLadderLine(int playerNumber) {
        final List<LadderPart> ladderParts = new ArrayList<>();
        int maxWidth = playerNumber * 2 - 1;

        for (int width = 0; width < maxWidth; width++) {
            ladderParts.add(makeLadderPart(width));
        }

        checkLadderParts(ladderParts);

        return new LadderLine(ladderParts);
    }

    private LadderPart makeLadderPart(int width) {
        if (width % 2 == 0) {
            return LadderPart.BAR;
        }

        return LadderPart.makeRandomBridge();
    }

    private void checkLadderParts(List<LadderPart> ladderParts) {
        int maxWidth = ladderParts.size();

        for (int width = 1; width < maxWidth; width += 2) {
            removeConnectedBridge(ladderParts, width);
        }
    }

    private void removeConnectedBridge(List<LadderPart> ladderParts, int width) {
        if (width + 2 >= ladderParts.size()) {
            return;
        }
        if (isConnectedBridge(ladderParts, width)) {
            ladderParts.remove(width + 2);
            ladderParts.add(width + 2, LadderPart.EMPTY);
        }
    }

    private boolean isConnectedBridge(List<LadderPart> ladderParts, int width) {
        return ladderParts.get(width) == ladderParts.get(width + 2);
    }


    public void run() {
        final List<String> playerNames = inputPlayerNames();
        final int height = inputLadderHeight();

        makeLadder(playerNames.size(), height);

        showResult(playerNames, ladder);
    }

    private void showResult(List<String> playerNames, Ladder ladder) {
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
