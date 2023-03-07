package kr.codesquad.view;

import java.util.List;
import java.util.stream.Collectors;
import kr.codesquad.domain.Ladder;

public class OutputView {

    private static final String LINE = "|";
    private static final String CONNECTION = "-";
    private static final String NOT_CONNECTION = " ";

    public static void printLadder(Ladder ladder) {
        List<List<Boolean>> readLadder = ladder.readLadder();
        String result = readLadder.stream()
            .map(OutputView::convertRowLadderToString)
            .collect(Collectors.joining("\n"));
        System.out.printf("\n%s\n", result);
    }

    private static String convertRowLadderToString(List<Boolean> rowLadder) {
        return rowLadder.stream()
            .map(connect -> String.format("%s%s", LINE, connect ? CONNECTION : NOT_CONNECTION))
            .collect(Collectors.joining())
            .concat(LINE);
    }
}
