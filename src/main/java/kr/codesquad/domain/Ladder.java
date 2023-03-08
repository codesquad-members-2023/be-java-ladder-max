package kr.codesquad.domain;

import java.util.Random;

public class Ladder {
    private String[][] ladder;
    private int columnNum;
    private int rowNum;

    public Ladder(int numberOfPlayer, int maximumHeight) {
        this.columnNum = numberOfPlayer + (numberOfPlayer - 1);
        this.rowNum = maximumHeight;
        this.ladder = generateLadder();
    }

    private String[][] generateLadder() {
        String[][] ladderFrame = new String[rowNum][columnNum];
        for(int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (j % 2 == 0) {
                    ladderFrame[i][j] = LadderLine.VerticalLine.getValue();
                } else {
                    ladderFrame[i][j] = selectHorizonLine();
                }
            }
        }
        return ladderFrame;
    }

    private String selectHorizonLine() {
        Random random = new Random();
        boolean isThereLine = random.nextBoolean();
        return isThereLine ? LadderLine.StraightLine.getValue() : LadderLine.BlankLine.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String[] row : ladder) {
            for(String cell : row) {
                sb.append(cell);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
