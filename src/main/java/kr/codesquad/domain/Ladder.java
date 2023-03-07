package kr.codesquad.domain;

import java.util.Arrays;

public class Ladder {
    private final char PLAYER_LINE = '|';
    private final char BRIDGE = '-';
    private final char EMPTY_SPACE = ' ';

    private final char[][] ladder;
    private final int rowSize;
    private final int columnSize;

    public Ladder(int playerCount, int ladderHeight) {
        this.rowSize = ladderHeight;
        this.columnSize = (playerCount * 2) - 1;
        this.ladder = makeLadder();
    }

    /* getter */
    public char[][] getLadder() {
        char[][] ladderClone = new char[rowSize][columnSize];
        for(int i = 0; i < rowSize; i++) {
            ladderClone[i] = ladder[i].clone();
        }

        return ladderClone;
    }

    /* private method */
    private char[][] makeLadder() {
        char[][] ladder = new char[rowSize][columnSize];

        initLadder(ladder);
        for(int row = 0; row < rowSize; row++) {
            addPlayerLineIntoRow(ladder, row);
            addBridgeIntoRow(ladder, row);
        }

        return ladder;
    }

    private void initLadder(char[][] ladder) {
        for (int i = 0; i < rowSize; i++) {
            Arrays.fill(ladder[i], EMPTY_SPACE);
        }
    }

    private void addPlayerLineIntoRow(char[][] ladder, int row) {
        for(int col = 0; col < columnSize; col += 2) {
            insertPlayerLine(ladder, row, col);
        }
    }

    private void addBridgeIntoRow(char[][] ladder, int row) {
        for (int col = 1; col < columnSize; col += 2) {
            insertBridge(ladder, row, col);
        }
    }

    private boolean shouldBuildingBridge() {
        return (int)(Math.random() * 2) == 1;
    }

    private void insertPlayerLine(char[][] ladder, int row, int column) {
        ladder[row][column] = PLAYER_LINE;
    }

    private void insertBridge(char[][] ladder, int row, int column) {
        if (shouldBuildingBridge()) {
            ladder[row][column] = BRIDGE;
        }
    }

}
