package kr.codesquad.domain;

import java.util.*;

public class Ladder {
    private final char PLAYER_LINE = '|';
    private final char BRIDGE = '-';
    private final char EMPTY_SPACE = ' ';

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

        initLadder(ladder);
        for(int row = 0; row < rowSize; row++) {
            addPlayerLineIntoRow(ladder, row);
            addBridgeIntoRow(ladder, row);
        }

        return ladder;
    }

    private void initLadder(List<List<Character>> ladder) {
        for(int row = 0; row < rowSize; row++) {
            ladder.add(row, makeLadderRow());
        }
    }

    private List<Character> makeLadderRow() {
        List<Character> ladderRow = new ArrayList<>();
        for(int col = 0; col < columnSize; col++) {
            ladderRow.add(EMPTY_SPACE);
        }
        return ladderRow;
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

    private boolean validateBridgePlacement(List<List<Character>> ladder, int row, int column) {
        if(column == 1 || (column > 2 && ladder.get(row).get(column-2) == EMPTY_SPACE)) {
            return true;
        }
        return false;
    }

    private void insertPlayerLine(List<List<Character>> ladder, int row, int column) {
        ladder.get(row).set(column, PLAYER_LINE);
    }

    private void insertBridge(List<List<Character>> ladder, int row, int column) {
        if (shouldBuildingBridge() && validateBridgePlacement(ladder, row, column)) {
            ladder.get(row).set(column, BRIDGE);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<Character> ladderRow : ladder) {
            for(char cell : ladderRow) {
                sb.append(cell);
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
