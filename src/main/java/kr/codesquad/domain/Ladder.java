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

    public String[][] generateLadder() {
        String[][] ladderFrame = new String[rowNum][columnNum];
        for(int i = 0; i < rowNum; i++) {
            generateVerticalOfLadder(ladderFrame, i);
            generateHorizonOfLadder(ladderFrame, i);
        }
        return ladderFrame;
    }

    private void generateVerticalOfLadder(String[][] ladderFrame, int row) {
        for(int j = 0; j < columnNum; j += 2) {
            ladderFrame[row][j] = LadderLine.VerticalLine.getValue();
        }
    }

    private void generateHorizonOfLadder(String[][] ladderFrame, int row) {
        for(int j = 1; j < columnNum; j += 2) {
           ladderFrame[row][j] = selectHorizonLine();
        }
    }

    private String selectHorizonLine() {
        Random random = new Random();
        boolean isThereLine = random.nextBoolean();
        return isThereLine ? LadderLine.StraightLine.getValue() : LadderLine.BlankLine.getValue();
    }

    
}
