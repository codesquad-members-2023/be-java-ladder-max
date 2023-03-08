package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final char PLAYER_LINE = '|';
    private final char BRIDGE = '-';

    private final List<List<Character>> ladder;
    private final int rowSize;
    private final int columnSize;

    public Ladder(int playerCount, int ladderHeight) {
        this.rowSize = ladderHeight;
        this.columnSize = (playerCount * 2) - 1;
        this.ladder = makeLadder();
    }

    /* getter */
    public char[][] getLadder() {
        /* toString 으로 대체하여 삭제할 예정 */
        /* OutputView와의 의존성 때문에 일단 남겨 놓았음 */
        return null;
    }

    /* private method */
    private List<List<Character>> makeLadder() {
        List<List<Character>> ladder = new ArrayList<>(rowSize);

        for(int row = 0; row < rowSize; row++) {
            addPlayerLineIntoRow(ladder, row);
            addBridgeIntoRow(ladder, row);
        }

        return ladder;
    }

    private void addPlayerLineIntoRow(List<List<Character>> ladder, int row) {
        for(int col = 0; col < columnSize; col += 2) {
            insertPlayerLine(ladder, row, col);
        }
    }

    private void addBridgeIntoRow(List<List<Character>> ladder, int row) {
        for (int col = 1; col < columnSize; col += 2) {
            insertBridge(ladder, row, col);
        }
    }

    private boolean shouldBuildingBridge() {
        return new Random().nextBoolean();
    }

    private void insertPlayerLine(List<List<Character>> ladder, int row, int column) {
        ladder.get(row).add(column, PLAYER_LINE);
    }

    private void insertBridge(List<List<Character>> ladder, int row, int column) {
        if (shouldBuildingBridge()) {
            ladder.get(row).add(column, BRIDGE);
        }
    }

}
