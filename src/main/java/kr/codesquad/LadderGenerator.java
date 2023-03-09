package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public Ladder generate(int playerNumber, int height) {
        if (isInValidNumber(playerNumber) || isInValidNumber(height)) {
            throw new IllegalArgumentException("사다리를 생성할 수 없습니다.");
        }

        final List<LadderLine> ladderLines = createLadderLines(playerNumber, height);

        return new Ladder(ladderLines);
    }

    private boolean isInValidNumber(int number) {
        return number < 1;
    }

    private List<LadderLine> createLadderLines(int playerNumber, int height) {
        final List<LadderLine> ladderLines = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            ladderLines.add(new LadderLine(playerNumber));
        }

        return ladderLines;
    }

}
