package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<LadderPart> ladderParts;

    public LadderLine(List<LadderPart> ladderParts) {
        validateWidth(ladderParts);
        validateLine(ladderParts);
        this.ladderParts = ladderParts;
    }

    private void validateWidth(List<LadderPart> ladderParts) {
        if (ladderParts.size() % 2 == 0) {
            throw new IllegalArgumentException("사다리 길이가 유효하지 않습니다.");
        }
    }

    public Direction findCanMoveDirection(Point point) {
        int currentWidth = point.getCurrentWidth();

        if (currentWidth > 0 && ladderParts.get(currentWidth - 1) == LadderPart.BRIDGE) {
            return Direction.LEFT;
        }
        if (currentWidth < ladderParts.size() - 1 && ladderParts.get(currentWidth + 1) == LadderPart.BRIDGE) {
            return Direction.RIGHT;
        }

        return Direction.NONE;
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
            throw new IllegalArgumentException("사다리 Bar가 생성될 위치입니다.");
        }
        if (width % 2 == 1 && ladderParts.get(width) == LadderPart.BAR) {
            throw new IllegalArgumentException("사다리 Bar가 생성될 수 없는 위치입니다.");
        }
        if (isConnectedBridge(ladderParts, width)) {
            throw new IllegalArgumentException("사다리 Bridge는 연속으로 생성될 수 없습니다.");
        }
    }

    private boolean isConnectedBridge(List<LadderPart> ladderParts, int width) {
        return width > 2 &&
                ladderParts.get(width - 2) == LadderPart.BRIDGE &&
                ladderParts.get(width) == LadderPart.BRIDGE;
    }

    @Override
    public String toString() {
        return ladderParts.stream()
                .map(LadderPart::toString)
                .collect(Collectors.joining());
    }
}
