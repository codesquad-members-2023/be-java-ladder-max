package kr.codesquad.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class RowLines {

    private static final String COLUMN_LINE = "|";
    private static final String ROW_LINE = "-----";
    private static final String PRE_FIX = "    |";
    private static final String EMPTY = "     ";
    private static final int ROW_LINES_MIN_SIZE = 2;

    private final List<Boolean> rowLines;

    public RowLines(List<Boolean> rowLines) {
        validateMinSize(rowLines);
        validateDuplicationLine(rowLines);
        this.rowLines = rowLines;
    }

    private void validateMinSize(List<Boolean> rowLines) {
        if (rowLines.size() < ROW_LINES_MIN_SIZE) {
            throw new IllegalArgumentException("사다리의 가로라인 개수는 최소 2개 이어야 합니다.");
        }
    }

    private void validateDuplicationLine(List<Boolean> rowLines) {
        IntStream.range(1, rowLines.size())
            .forEach(index -> {
                if (rowLines.get(index - 1) && rowLines.get(index)) {
                    throw new IllegalArgumentException("가로 사다리 라인이 곁치지 않아야 합니다.");
                }
            });
    }

    public boolean findByIndex(int index) {
        return this.rowLines.get(index);
    }

    public boolean isConnectLine(int index) {
        if (index == 0) {
            return !this.rowLines.get(index + 1);
        }

        if (index == this.rowLines.size() - 1) {
            return !this.rowLines.get(index - 1);
        }

        return !this.rowLines.get(index - 1) && !this.rowLines.get(index + 1);
    }

    public void connect(int index) {
        this.rowLines.set(index, true);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(COLUMN_LINE, PRE_FIX, COLUMN_LINE);
        this.rowLines.forEach(line -> stringJoiner.add(line ? ROW_LINE : EMPTY));
        return stringJoiner.toString();
    }
}
