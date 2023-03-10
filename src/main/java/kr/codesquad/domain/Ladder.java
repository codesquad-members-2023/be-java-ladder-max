package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private static final int MIN_SIZE = 2;

    private final List<RowLines> ladder;

    public Ladder(List<RowLines> rowLines) {
        validateMinSize(rowLines);
        this.ladder = rowLines;
    }

    private void validateMinSize(List<RowLines> rowLines) {
        if (rowLines.size() < MIN_SIZE) {
            throw new IllegalArgumentException("사다리 높이는 최소 2이상 입니다.");
        }
    }

    public int calculateResultIndex(int userIndex) {
        for (RowLines rowLines : this.ladder) {
            userIndex = rowLines.moveDown(userIndex);
        }

        return userIndex;
    }

    @Override
    public String toString() {
        return this.ladder.stream()
            .map(RowLines::toString)
            .collect(Collectors.joining("\n"));
    }
}
