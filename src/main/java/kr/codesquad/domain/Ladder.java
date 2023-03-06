package kr.codesquad.domain;

import java.util.Random;

public class Ladder {

    public String[][] makeLadder(int playerCount, int ladderHeight) {

        String[][] ladder = new String[ladderHeight][(playerCount*2) - 1];

        // player line(세로 줄) 추가
        addPlayerLine(ladder);

        // bridge(가로 줄) 추가
        addBridge(ladder);

        return ladder;
    }

    private String[][] addPlayerLine(String[][] ladder) {
        for(int i = 0; i < ladder.length; i++) {
            for(int j = 0; j < ladder[i].length; j++) {
                if(j%2 == 0) {
                    ladder[i][j] = "|";
                }
            }
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
