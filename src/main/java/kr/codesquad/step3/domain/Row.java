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

    public LadderType connectLadderTypes(RandomConnection randomConnection) {
        if (ladderTypes.size() == NO_ROW) {
            return LadderType.DISCONNECT;
        }

        LadderType prePoint = ladderTypes.get(ladderTypes.size() - GET_LENGTH);
        if (prePoint.isConnected()) {
            return LadderType.CONNECT;
        }

        return LadderType.getLadderType(randomConnection.connect());
    }


    public List<LadderType> ladderTypes() {
        return ladderTypes;
    }
}
