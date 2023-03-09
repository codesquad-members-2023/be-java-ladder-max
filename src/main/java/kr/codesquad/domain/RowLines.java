package kr.codesquad.domain;

import java.util.List;
import java.util.StringJoiner;

public class RowLines {

    private static final String COLUMN_LINE = "|";
    private static final String ROW_LINE = "-----";
    private static final String PRE_FIX = "    |";
    private static final String EMPTY = "     ";

    private final List<Boolean> rowLines;

    public RowLines(RandomRowLinesGenerator randomRowLinesGenerator) {
        this.rowLines = randomRowLinesGenerator.generate();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(COLUMN_LINE, PRE_FIX, COLUMN_LINE);
        this.rowLines.forEach(line -> stringJoiner.add(line ? ROW_LINE : EMPTY));
        return stringJoiner.toString();
    }
}
