package kr.codesquad.domain;

import java.util.*;

public class Ladder {
    private final List<LadderRow> ladder;
    private final int height;
    private final int playerLineSize;
    private final int bridgeLineSize;

    public Ladder(int playerCount, int ladderHeight) {
        this.height = ladderHeight;
        this.playerLineSize = playerCount;
        this.bridgeLineSize = playerCount - 1;
        this.ladder = makeLadder();
    }

    /* private method */
    private List<LadderRow> makeLadder() {
        List<LadderRow> ladder = new ArrayList<>(height);

        for(int row = 0; row < height; row++) {
            ladder.add(new LadderRow(bridgeLineSize));
        }

        return ladder;
    }

    public int climbDownLadder(int startIndex) {
        int currentIndex = startIndex;
        for(int row = 0; row < height; row++) {
            // 좌 우로 이동하기
            currentIndex = ladder.get(row).checkBridgeInBothDirection(currentIndex);
        }
        return currentIndex;
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
        final String PLAYER_LINE = "|";
        final String BRIDGE = "-----";
        final String EMPTY_SPACE = "     ";
        StringBuilder sb = new StringBuilder();

        // playerLine(세로줄) 처리
        sb.append(PLAYER_LINE.repeat(playerLineSize));

        // bridge 구간(가로줄) 처리
        int sbPointer = 1;
        for (int col = 0; col < bridgeLineSize; col++) {
            sb.insert(sbPointer, ladderRow.isBridge(col)? BRIDGE : EMPTY_SPACE);
            sbPointer += 6;
        }

        // 맨 앞에 2칸씩 공백 삽입
        sb.insert(0, "  ");

        return sb.toString();
    }
}
