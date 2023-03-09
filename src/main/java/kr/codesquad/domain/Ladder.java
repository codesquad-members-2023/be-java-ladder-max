package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<String> createOutputLines() {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.toList());
    }
}
