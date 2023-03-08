package kr.codesquad;

import java.util.Random;

public class LadderPartGenerator {

    private static final String BRIDGE = "-";
    private static final String EMPTY = " ";
    private static final String BAR = "|";

    private final Ladder ladder;
    private final Random random;

    public LadderPartGenerator(Ladder ladder, Random random) {
        this.ladder = ladder;
        this.random = random;
    }

    public String[][] generate() {
        String[][] board = ladder.createEmptyLadderBoard();
        for (int i = 0; i < board.length; i++) {
            board[i] = createRandomLadderByLadder();
        }
        return board;
    }

    private String[] createRandomLadderByLadder() {
        String[] ladderColumns = ladder.createEmptyLadderColumns();
        for (int col = 0; col < ladderColumns.length; col += 2) {
            ladderColumns[col] = generateBar();
        }
        for (int col = 1; col < ladderColumns.length; col += 2) {
            ladderColumns[col] = generateBridge();
        }
        return ladderColumns;
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

    private String generateBar() {
        return BAR;
    }
}
