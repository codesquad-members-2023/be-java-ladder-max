package kr.codesquad;

import java.util.Random;

public class Ladder {
    private String[][] laddder;

    Ladder(int peoleNumber, int ladderHeight) {
        this.laddder = new String[ladderHeight][2 * peoleNumber - 1];
    }

    public String[][] makeLadder() {
        for (int row = 0; row < laddder.length; row++) {
            for (int column = 0; column < laddder[row].length; column++) {
                makeBasicPeopleLine(row, column);
                makeRandomLadderLine(row,column);
            }
        }
        return this.laddder;
    }


    private void makeBasicPeopleLine(int row, int column) {
        if (column % 2 == 0) {
            this.laddder[row][column] = "|";
        } this.laddder[row][column] = " ";
    }


//    public void makeRandomLadderLine() {
//
//        for (int i = 0; i < laddder.length; i++) {
//            for (int j = 0; j < laddder[i].length; j++) {
//                makeRandomLadderLine(i, j);
//            }
//        }
//    }

    private void makeRandomLadderLine(int row, int column) {
        Random random = new Random();
        if (random.nextBoolean() && column % 2 == 1) {
            laddder[row][column] = "-";
        }
    }


}
