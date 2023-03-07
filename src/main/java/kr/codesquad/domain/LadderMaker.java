package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import kr.codesquad.config.LadderConfig;
import kr.codesquad.util.NumberGenerator;

public class LadderMaker {

    private final NumberGenerator numberGenerator;

    public LadderMaker(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<List<String>> makeLadder(int numberOfPeople, int size) {
        List<List<String>> ladder = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ladder.add(makeOneLineLadder(numberOfPeople));
        }
        return ladder;
    }

    private List<String> makeOneLineLadder(int numberOfPeople) {
        List<String> oneLine = new ArrayList<>();
        for (int i = 0; i < numberOfPeople - 1; i++) {
            oneLine.add(LadderConfig.AFFIX.expression());
            oneLine.add(numberToLadder());
        }
        oneLine.add(LadderConfig.AFFIX.expression());
        return oneLine;
    }

    private String numberToLadder() {
        int number = numberGenerator.generate();
        if (number == LadderConfig.EMPTY.number()) {
            return LadderConfig.EMPTY.expression();
        }
        return LadderConfig.LADDER.expression();
    }
}
