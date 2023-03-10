package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<LadderLine> ladderLines = new ArrayList<>();

    public Ladder(int playerNumber, int height) {
        if (playerNumber < 1 || height < 1) {
            throw new IllegalArgumentException("사다리를 생성할 수 없습니다.");
        }

        addLadderLines(playerNumber, height);
    }

    private void addLadderLines(int playerNumber, int height) {
        for (int y = 0; y < height; y++) {
            ladderLines.add(new LadderLine(playerNumber));
        }
    }

    public List<String> createOutputLines() {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.toList());
    }
}
