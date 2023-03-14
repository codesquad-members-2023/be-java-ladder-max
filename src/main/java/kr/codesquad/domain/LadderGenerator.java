package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    private int maxHeight;
    private int maxWidth;
    private int rowIndex;
    private int columnIndex;
    private String[][] ladder;

    public LadderGenerator(int joinMembers, int maxHeight) {
        this.maxHeight = maxHeight;
        maxWidth = calculateMaxWidth(joinMembers);
    }

    public String[][] generateLadder() {
        ladder = new String[maxHeight][maxWidth];
        generateLadderArray();
        generateBorderLine();
        generateRandomLine();
        return ladder;
    }

    private int calculateMaxWidth(int joinMembers) {
        int maxWidth = joinMembers * 2 - 1;
        return maxWidth;
    }

    // 수정 필요
    private void generateLadderArray() {
        for (rowIndex = 0; rowIndex < ladder.length; rowIndex++) {
            for (columnIndex = 0; columnIndex < ladder[rowIndex].length; columnIndex++) {
                ladder[rowIndex][columnIndex] = " ";
            }
        }
    }

    private void generateBorderLine() {
        for (rowIndex = 0; rowIndex < ladder.length; rowIndex++) {
            for (columnIndex = 0; columnIndex < ladder[rowIndex].length; columnIndex++) {
                if (columnIndex % 2 == 0) {
                    ladder[rowIndex][columnIndex] = "|";
                }
            }
        }
    }

    private void generateRandomLine() {
        Random random = new Random();
        for (rowIndex = 0; rowIndex < ladder.length; rowIndex++) {
            for (columnIndex = 0; columnIndex < ladder[rowIndex].length; columnIndex++) {
                if (columnIndex % 2 != 0 && random.nextBoolean()) {
                    ladder[rowIndex][columnIndex] = "-";
                }
            }
        }
    }
}