package kr.codesquad.domain;

import java.util.Random;

public class Ladder {

    public String[][] makeLadder(int playerCount, int ladderHeight) {

        String[][] ladder = new String[ladderHeight][(playerCount*2) - 1];

        for(int row = 0; row < ladder.length; row++) {
            addPlayerLine(ladder, row);
            addBridge(ladder, row);
        }

        return ladder;
    }

    private String[][] addPlayerLine(String[][] ladder, int row) {
        for(int col = 0; col < ladder[0].length; col += 2) {
            ladder[row][col] = "|";
        }

        return ladder;
    }

    private String[][] addBridge(String[][] ladder, int row) {
        for (int col = 1; col < ladder[0].length; col += 2) {
            insertBridge(ladder, row, col);
        }

        return ladder;
    }

    private boolean shouldBuildingBridge() {
        return (int)(Math.random() * 2) == 1? true : false;
    }

    private void insertBridge(String[][] ladder, int row, int col) {
        if (shouldBuildingBridge()) {
            ladder[row][col] = "-";
        }
    }

}
