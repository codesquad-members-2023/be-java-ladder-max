package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<LadderPart> ladderParts;

    public LadderLine(List<LadderPart> ladderParts) {
        this.ladderParts = ladderParts;
    }

    @Override
    public String toString() {
        return ladderParts.stream()
                .map(LadderPart::toString)
                .collect(Collectors.joining());
    }
}
