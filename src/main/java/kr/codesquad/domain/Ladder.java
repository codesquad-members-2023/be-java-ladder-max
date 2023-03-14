package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        validateLineWidth(ladderLines);
        this.ladderLines = ladderLines;
    }

    private void validateLineWidth(List<LadderLine> ladderLines) {
        if (isSameWidth(ladderLines)) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private boolean isSameWidth(List<LadderLine> ladderLines) {
        if (ladderLines.size() < 1) {
            return false;
        }

        final int width = ladderLines.get(0).getSumParts();

        return ladderLines.stream()
                .mapToInt(LadderLine::getSumParts)
                .allMatch(sum -> sum == width);
    }

    public List<String> createOutputLines() {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.toList());
    }
}
