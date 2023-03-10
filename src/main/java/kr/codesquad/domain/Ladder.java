package kr.codesquad.domain;

import java.util.*;

public class Ladder {
    private final char PLAYER_LINE = '|';
    private final char BRIDGE = '-';
    private final char EMPTY_SPACE = ' ';

    private final List<LadderRow> ladder;
    private final int rowSize;
    private final int columnSize;

    public Ladder(int playerCount, int ladderHeight) {
        this.rowSize = ladderHeight;
        this.columnSize = (playerCount * 2) - 1;
        this.ladder = makeLadder();
    }

    /* private method */
    private List<LadderRow> makeLadder() {
        List<LadderRow> ladder = new ArrayList<>(rowSize);

        initLadder(ladder);
        for(int row = 0; row < rowSize; row++) {
            addPlayerLineIntoRow(ladder, row);
            addBridgeIntoRow(ladder, row);
        }

        return ladder;
    }

    private void initLadder(List<LadderRow> ladder) {
        for(int row = 0; row < rowSize; row++) {
            ladder.add(row, new LadderRow(columnSize));
        }
    }

    private void addPlayerLineIntoRow(List<LadderRow> ladder, int row) {
        for(int col = 0; col < columnSize; col += 2) {
            insertPlayerLine(ladder, row, col);
        }
    }

    private void addBridgeIntoRow(List<LadderRow> ladder, int row) {
        for (int col = 1; col < columnSize; col += 2) {
            insertBridge(ladder, row, col);
        }
    }

    private boolean shouldBuildingBridge() {
        return new Random().nextBoolean();
    }

    private void insertPlayerLine(List<LadderRow> ladder, int row, int column) {
        ladder.get(row).setPlayerLine(column);
    }

    private void insertBridge(List<LadderRow> ladder, int row, int column) {
        if (shouldBuildingBridge()) {
            ladder.get(row).setBridge(column);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(LadderRow ladderRow : ladder) {
            sb.append(buildLadderRow(ladderRow));
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private String buildLadderRow(LadderRow ladderRow) {
        StringBuilder sb = new StringBuilder();

        // playerLine(세로줄) 처리
        for(int col = 0; col < columnSize; col += 2) {
            sb.append(PLAYER_LINE);
        }

        // bridge 구간(가로줄) 처리
        int sbPointer = 1;
        for (int col = 1; col < columnSize; col += 2) {
            sb.insert(sbPointer, ladderRow.isBridge(col)? "-----" : "     ");
            sbPointer += 6;
        }

        // 맨 앞에 2칸씩 공백 삽입
        sb.insert(0, "  ");

        return sb.toString();
    }
}
