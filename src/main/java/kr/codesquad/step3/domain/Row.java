package kr.codesquad.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {
    private final List<LadderType> ladderTypes;
    private static final int NO_ROW = 0;
    private static final int GET_LENGTH = 1;

    public Row(int countNumOfParticipate) {
        ladderTypes = new ArrayList<>();
        makeRow(countNumOfParticipate);
    }

    private void makeRow(int countNumOfParticipate) {
        IntStream.range(0, countNumOfParticipate)
                .forEach(i -> ladderTypes.add(connectLadderTypes(new RandomConnection())));
    }

    public List<LadderType> ladderTypes() {
        return ladderTypes;
    }
}
