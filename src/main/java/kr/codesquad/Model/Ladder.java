package kr.codesquad.Model;

import java.util.Arrays;
import java.util.Random;

public class Ladder {
    final int ROW_SIZE;
    final int COLUMN_SIZE;
    private final Bar[][] ladder;

    public Ladder(int numberOfPlayer, int ladderHeight) {
        ROW_SIZE = ladderHeight;
        COLUMN_SIZE = numberOfPlayer * 2 - 1;
        ladder = new Bar[ROW_SIZE][COLUMN_SIZE];
        initLadder();
    }

    private void initLadder(){
        for(int rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++){
            initRow(rowIndex);
        }
    }

    private void initRow(int rowIndex){
        for(int columnIndex = 0; columnIndex < COLUMN_SIZE; columnIndex++){
            ladder[rowIndex][columnIndex] = getLadderLine(columnIndex);
        }
    }

    private Bar getLadderLine(int index){
        Random random = new Random();
        boolean isVertical = index%2 == 0;
        boolean isRandomPicked = random.nextBoolean();

        if(isVertical){
            return Bar.VERTICAL;
        }

        if(isRandomPicked){
            return Bar.HORIZONTAL;
        }

        return Bar.BLANK;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++){
            Arrays.stream(ladder[rowIndex])
                    .forEach(s -> sb.append(s.getBar()));
            sb.append("\n");
        }

        return sb.toString();
    }


    public void print(){
        for(int rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++){
            for(int columnIndex = 0; columnIndex < COLUMN_SIZE; columnIndex++){
                Bar line = ladder[rowIndex][columnIndex];
                System.out.print(line == null ? " " : line.getBar());
            }
            System.out.println();
        }
    }

}
