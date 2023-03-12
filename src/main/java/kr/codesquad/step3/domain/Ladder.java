package kr.codesquad.step3.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import kr.codesquad.step3.util.Validation;

public class Ladder {
    private final List<Row> ladder;
    private final int height;

    public Ladder(Participates participates, int inputHeight) {
        this.height = checkHeight(inputHeight);
        ladder = new ArrayList<>();
        makeLadder(participates.participatesNames.size());
    }

    private int checkHeight(int inputHeight) {
        Validation.validateIsMinHeight(inputHeight);
        return inputHeight;
    }

    private void makeLadder(int countNumOfParticipate) {
        IntStream.range(0, height)
                .forEach(i -> ladder.add(new Row(countNumOfParticipate)));
    }

    public List<Row> getLadder() {
        return ladder;
    }
}
