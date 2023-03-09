package kr.codesquad;

import java.util.Random;

public class LadderPartGenerator {

    private static final String BRIDGE = "-";
    private static final String EMPTY = " ";
    private static final String BAR = "|";

    private final Random random;

    public LadderPartGenerator(Random random) {
        this.random = random;
    }

    public String[][] generateLadderPart(Ladder ladder) {
        String[][] partLines = ladder.createEmptyLadderLines();
        for (int i = 0; i < partLines.length; i++) {
            partLines[i] = createRandomLadderByLadder(ladder);
        }
        return partLines;
    }

    private String[] createRandomLadderByLadder(Ladder ladder) {
        String[] partLine = ladder.createEmptyLadderColumns();
        for (int col = 0; col < partLine.length; col++) {
            partLine[col] = generatePart(col);
        }
        return partLine;
    }

    private String generatePart(int col) {
        if (isBarColumn(col)) {
            return generateBar();
        }
        return generateBridge();
    }

    private boolean isBarColumn(int col) {
        return col % 2 == 0;
    }

    private String generateBar() {
        return BAR;
    }

    private String generateBridge() {
        if (!buildOrNotBridge()) {
            return EMPTY;
        }
        return BRIDGE;
    }

    private boolean buildOrNotBridge() {
        return random.nextBoolean();
    }


}
