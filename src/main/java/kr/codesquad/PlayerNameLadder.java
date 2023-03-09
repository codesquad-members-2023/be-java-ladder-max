package kr.codesquad;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerNameLadder implements Ladder {
    private final List<LadderLine> ladderLines;

    public PlayerNameLadder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    @Override
    public List<String> createOutputLines() {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.toList());
    }
}
