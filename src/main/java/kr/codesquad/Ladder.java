package kr.codesquad;

import java.util.Random;

public class Ladder {
    private int peopleNum;
    private int ladderHeight;
    char [][] ladder;

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public void setLadderHeight(int ladderHeight) {
        this.ladderHeight = ladderHeight;
    }

    void makeLadder() {
        ladder = new char[ladderHeight][peopleNum * 2 - 1];
        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < peopleNum * 2 - 1; j++) {
                if (j % 2 != 0) {
                    ladder[i][j] = random() ? '-' : ' ';
                } else {
                    ladder[i][j] = '|';
                }
            }
        }
    }

    boolean random(){
        Random rd = new Random();
        return rd.nextBoolean();
    }
}
