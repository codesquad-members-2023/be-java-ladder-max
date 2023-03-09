package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderPartGenerator {

    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";
    private static final String BAR = "|";

    private final Random random;

    public LadderPartGenerator(Random random) {
        this.random = random;
    }

    public List<List<String>> generateLadderPart(Ladder ladder) {
        List<List<String>> partLines = ladder.createEmptyLadderLines();
        for (int i = 0; i < partLines.size(); i++) {
            partLines.get(i).addAll(createRandomLadderByLadder(ladder));
        }
        return partLines;
    }

    private List<String> createRandomLadderByLadder(Ladder ladder) {
        List<String> partLine = new ArrayList<>();
        for (int col = 0; col < ladder.calLineColumnSize(); col++) {
            partLine.add(generatePart(partLine, col));
        }
        return partLine;
    }

    private String generatePart(List<String> partLine, int col) {
        if (isBarColumn(col)) {
            return generateBar();
        }
        return generateBridge(partLine, col);
    }

    private boolean isBarColumn(int col) {
        return col % 2 == 0;
    }

    private String generateBar() {
        return BAR;
    }

    private String generateBridge(List<String> partLine, int col) {
        if (!buildOrNotBridge()) {
            return EMPTY;
        }
        if (existBridgeOnLeft(partLine, col)) {
            return EMPTY;
        }
        return BRIDGE;
    }

    private boolean buildOrNotBridge() {
        return random.nextBoolean();
    }

    private boolean existBridgeOnLeft(List<String> partLine, int col) {
        return col >= 3 && partLine.get(col - 2).equals(BRIDGE);
    }


}
