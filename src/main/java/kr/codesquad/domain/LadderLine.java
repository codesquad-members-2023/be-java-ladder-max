package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<LadderPart> ladderParts = new ArrayList<>();

    public LadderLine(int playerNumber) {
        if (playerNumber < 1) {
            throw new IllegalArgumentException("사다리 라인을 만들 수 없습니다.");
        }

        addParts(playerNumber * 2 - 1);
    }

    private void addParts(int width) {
        for (int x = 0; x < width; x++) {
            ladderParts.add(makePart(x));
        }
    }

    private LadderPart makePart(int x) {
        if (isExistCrossBarOnLeft(x)) {
            return LadderPart.EMPTY;
        }

        return LadderPart.from(x);
    }

    private boolean isExistCrossBarOnLeft(int x) {
        return x > 2 && ladderParts.get(x - 2) == LadderPart.CROSSBAR;
    }

    @Override
    public String toString() {
        return ladderParts.stream()
                .map(LadderPart::getShape)
                .collect(Collectors.joining());
    }
}
