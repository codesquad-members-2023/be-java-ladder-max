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

    private void addParts(int maxWidth) {
        for (int width = 0; width < maxWidth; width++) {
            ladderParts.add(decidePart(width));
        }
    }

    private LadderPart decidePart(int width) {
        if (isBarPosition(width)) {
            return LadderPart.BAR;
        }
        if (isExistBridgeOnLeft(width)) {
            return LadderPart.EMPTY;
        }

        return LadderPart.makeRandomBridge();
    }

    private boolean isBarPosition(int x) {
        return x % 2 == 0;
    }

    private boolean isExistBridgeOnLeft(int x) {
        return x > 2 && ladderParts.get(x - 2) == LadderPart.BRIDGE;
    }

    @Override
    public String toString() {
        return ladderParts.stream()
                .map(LadderPart::toString)
                .collect(Collectors.joining());
    }
}
