package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {
    private final int FIRST_LINE = 0;
    private final int SECOND_LINE = 1;

    private List<LadderUnit> ladderRow;
    private int size;

    public LadderRow(int size) {
        this.size = size;
        this.ladderRow = new ArrayList<>(size);
        makeLadderRow();
    }

    private void makeLadderRow() {
        initialize();
    }

    private void initialize() {
        fillEmptySpace();
        fillBridges();
    }

    private void fillEmptySpace() {
        for(int lineIndex = 0; lineIndex < size; lineIndex++) {
            ladderRow.add(new EmptySpace());
        }
    }

    private void fillBridges() {
        for(int lineIndex = 0; lineIndex < size; lineIndex++) {
            setBridgeRandomly(lineIndex);
        }
    }

    private void setBridgeRandomly(int lineIndex) {
        if(new Random().nextBoolean() && validateBridgePlacement(lineIndex)) {
            ladderRow.set(lineIndex, new Bridge());
        }
    }

    private boolean validateBridgePlacement(int lineIndex) {
        return isFirstLine(lineIndex)
                || (isMoreThanSecondLine(lineIndex) && !isBridgeOnPreviousLine(lineIndex));
    }

    private boolean isFirstLine(int lineIndex) {
        return lineIndex == FIRST_LINE;
    }

    private boolean isMoreThanSecondLine(int lineIndex) {
        return lineIndex >= SECOND_LINE;
    }

    private boolean isBridgeOnPreviousLine(int lineIndex) {
        return ladderRow.get(lineIndex - 1) instanceof Bridge;
    }

    public boolean isBridge(int lineIndex) {
        return ladderRow.get(lineIndex) instanceof Bridge;
    }

}
