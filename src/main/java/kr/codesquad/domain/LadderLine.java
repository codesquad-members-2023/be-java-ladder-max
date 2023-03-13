package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<LadderPart> ladderParts;

    public LadderLine(List<LadderPart> ladderParts) {
        validateLine(ladderParts);
        this.ladderParts = ladderParts;
    }

    public int getSumParts() {
        return ladderParts.size();
    }

    private void validateLine(List<LadderPart> ladderParts) {
        final int maxWidth = ladderParts.size();

        for (int width = 0; width < maxWidth; width++) {
            validatePart(ladderParts, width);
        }
    }

    private void validatePart(List<LadderPart> ladderParts, int width) {
        if (width % 2 == 0 && ladderParts.get(width) != LadderPart.BAR) {
            throw new IllegalArgumentException();
        }
        if (width % 2 == 1 && ladderParts.get(width) == LadderPart.BAR) {
            throw new IllegalArgumentException();
        }
        if (width > 2 && ladderParts.get(width - 2) == ladderParts.get(width)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return ladderParts.stream()
                .map(LadderPart::toString)
                .collect(Collectors.joining());
    }
}
