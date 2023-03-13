package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {
    final int ROW_SIZE;
    final int COLUMN_SIZE;
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int numberOfPlayer, int ladderHeight) {
        ROW_SIZE = ladderHeight;
        COLUMN_SIZE = numberOfPlayer * 2 - 1;
        makeLadder();
    }

    private void makeLadder(){
        for(int rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++){
            ladder.add(new Line(COLUMN_SIZE));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++){
            sb.append("   ");
            sb.append(ladder.get(rowIndex).toString());
            sb.append("\n");
        }

        return sb.toString();
    }

}
