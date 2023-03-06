package kr.codesquad.domain;

import java.util.Random;

public class Ladder {

    public String[][] makeLadder(int playerCount, int ladderHeight) {

        String[][] ladder = new String[ladderHeight][(playerCount*2) - 1];

        // player line(세로 줄) 추가
        for(int row = 0; row < ladder.length; row++) {
            addPlayerLine(ladder, row);
        }

        // bridge(가로 줄) 추가
        addBridge(ladder);

        return ladder;
    }

    private String[][] addPlayerLine(String[][] ladder, int row) {
        for(int col = 0; col < ladder[0].length; col += 2) {
            ladder[row][col] = "|";
        }

        return ladder;
    }

    private String[][] addBridge(String[][] ladder) {
        for(int i = 0; i < ladder.length; i++) {
            for(int j = 0; j < ladder[i].length; j++) {
                if(j%2 != 0 && shouldBuildingBridge()) {
                    ladder[i][j] = "-";
                }
            }
        }

        return ladder;
    }

    private boolean shouldBuildingBridge() {
        return (int)(Math.random() * 2) == 1? true : false;
    }

}
