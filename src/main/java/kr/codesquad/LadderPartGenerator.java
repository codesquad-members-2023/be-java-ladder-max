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
        String[][] board = ladder.createLadderBoard();
        makeLadderBar(board);
        makeLadderBridge(board);
        return board;
    }

    private void makeLadderBar(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j += 2) {
                board[i][j] = generateBar();
            }
        }
    }

    private void makeLadderBridge(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j += 2) {
                board[i][j] = generateBridge();
            }
        }
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

    private boolean isBarColumn(int column) {
        return column % 2 == 0;
    }
}
