package kr.codesquad;

import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<LadderPart> line;

    public LadderLine(List<LadderPart> line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return line.stream()
                .map(LadderPart::getShape)
                .collect(Collectors.joining());
    }
}
