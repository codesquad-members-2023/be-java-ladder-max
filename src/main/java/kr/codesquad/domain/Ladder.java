package kr.codesquad.domain;

public class Ladder {
    private final String PLAYER_LINE = "|";
    private final String BRIDGE = "-";

    private final String[][] ladder;
    private final int rowSize;
    private final int columnSize;

    public Ladder(int playerCount, int ladderHeight) {
        this.rowSize = ladderHeight;
        this.columnSize = (playerCount * 2) - 1;
        this.ladder = makeLadder();
    }

    /* getter */
    public String[][] getLadder() {
        String[][] ladderClone = new String[rowSize][columnSize];
        for(int i = 0; i < rowSize; i++) {
            ladderClone[i] = ladder[i].clone();
        }

        return ladderClone;
    }

    /* private method */
    private String[][] makeLadder() {

        String[][] ladder = new String[rowSize][columnSize];

        for(int row = 0; row < rowSize; row++) {
            addPlayerLineIntoRow(ladder, row);
            addBridgeIntoRow(ladder, row);
        }

        return ladder;
    }

    private void addPlayerLineIntoRow(String[][] ladder, int row) {
        for(int col = 0; col < columnSize; col += 2) {
            insertPlayerLine(ladder, row, col);
        }
    }

    private void addBridgeIntoRow(String[][] ladder, int row) {
        for (int col = 1; col < columnSize; col += 2) {
            insertBridge(ladder, row, col);
        }
    }

    private boolean shouldBuildingBridge() {
        return (int)(Math.random() * 2) == 1;
    }

    private void insertPlayerLine(String[][] ladder, int row, int column) {
        ladder[row][column] = PLAYER_LINE;
    }

    private void insertBridge(String[][] ladder, int row, int column) {
        if (shouldBuildingBridge()) {
            ladder[row][column] = BRIDGE;
        }
    }

}
