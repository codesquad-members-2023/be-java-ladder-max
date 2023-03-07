package kr.codesquad;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private int ladderWidth;
    private int ladderHeight;
    private char [][] ladder;

    public char[][] getLadder() {
        return ladder;
    }

   public Ladder(ArrayList<Integer> arr){
       ladderWidth = arr.get(0);
       ladderHeight = arr.get(1);
       makeLadder();
   }

    void makeLadder() {
        ladder = new char[ladderHeight][ladderWidth * 2 - 1];
        for (int i = 0; i < ladderHeight; i++) {
            fillRowWithSymbols(i);
        }
    }

    private void fillRowWithSymbols(int i) {
        for (int j = 0; j < ladderWidth * 2 - 1; j++) {
            isOdd(i, j);
        }
    }

    private void isOdd(int i, int j) {
        if (j % 2 != 0) {
            ladder[i][j] = random() ? '-' : ' ';
            return;
        }
        ladder[i][j] = '|';
    }

    boolean random(){
        Random rd = new Random();
        return rd.nextBoolean();
    }
}
