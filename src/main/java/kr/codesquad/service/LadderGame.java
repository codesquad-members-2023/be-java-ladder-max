package kr.codesquad.service;

import kr.codesquad.domain.Ladder;
import kr.codesquad.controller.dto.LadderInputDto;
import kr.codesquad.domain.LadderLine;
import kr.codesquad.domain.LadderPart;
import kr.codesquad.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public String play(LadderInputDto ladderInputDto) {
        Ladder ladder = new Ladder(makeLadderMap(ladderInputDto.getPlayerNumber(), ladderInputDto.getHeight()));

        final List<Point> points = ladder.makeResult();

        return String.join("\n", ladder.createOutputLines());
    }

    private List<LadderLine> makeLadderMap(int playerNumber, int height) {
        final List<LadderLine> ladderLines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladderLines.add(makeLadderLine(playerNumber));
        }

        return ladderLines;
    }

    private LadderLine makeLadderLine(int playerNumber) {
        final List<LadderPart> ladderParts = new ArrayList<>();
        int maxWidth = playerNumber * 2 - 1;

        for (int width = 0; width < maxWidth; width++) {
            ladderParts.add(makeLadderPart(ladderParts, width));
        }

        return new LadderLine(ladderParts);
    }

    private LadderPart makeLadderPart(List<LadderPart> ladderParts, int width) {
        if (width % 2 == 0) {
            return LadderPart.BAR;
        }
        if (existBridgeOnLeft(ladderParts, width)) {
            return LadderPart.EMPTY;
        }

        return LadderPart.makeRandomBridge();
    }

    private boolean existBridgeOnLeft(List<LadderPart> ladderParts, int width) {
        return width > 2 && ladderParts.get(width - 2) == LadderPart.BRIDGE;
    }
}
