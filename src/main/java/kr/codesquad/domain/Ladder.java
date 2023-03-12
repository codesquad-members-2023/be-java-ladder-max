package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.exception.ladder.LadderMinHeightException;

public class Ladder {

    private final List<RowLines> ladder;

    public Ladder(List<RowLines> rowLinesList) {
        validateMinSize(rowLinesList);
        this.ladder = rowLinesList;
    }

    private void validateMinSize(List<RowLines> rowLines) {
        if (rowLines.size() < LadderHeight.MIN_HEIGHT) {
            throw new LadderMinHeightException();
        }
    }

    public int calculateResultIndex(int columnLineIndex) {
        for (RowLines rowLines : this.ladder) {
            columnLineIndex = rowLines.moveDown(columnLineIndex);
        }

        return columnLineIndex;
    }

    @Override
    public String toString() {
        return this.ladder.stream()
            .map(RowLines::toString)
            .collect(Collectors.joining("\n"));
    }
}
