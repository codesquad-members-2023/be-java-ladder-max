package kr.codesquad.controller.dto;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderLine;
import kr.codesquad.domain.LadderPart;

import java.util.ArrayList;
import java.util.List;

public class LadderInputDto {
    private final int playerNumber;
    private final int height;

    public LadderInputDto(int playerNumber, int height) {
        this.playerNumber = playerNumber;
        this.height = height;
    }

    public Ladder toLadder() {
        final List<LadderLine> ladderLines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladderLines.add(makeLadderLine(playerNumber));
        }

        return new Ladder(ladderLines);
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
}
