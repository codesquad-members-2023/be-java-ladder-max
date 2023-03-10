package kr.codesquad;

import java.util.Arrays;
import java.util.Random;

public class Ladder {

    final int ROW_SIZE;
    final int COLUMN_SIZE;
    private final LadderLine[][] ladder;

    public Ladder(int numberOfPlayer, int ladderHeight) {
        ROW_SIZE = ladderHeight;
        COLUMN_SIZE = numberOfPlayer * 2 - 1;
        ladder = new LadderLine[ROW_SIZE][COLUMN_SIZE];
        init();
    }

    private void init(){
        for(int rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++){
            initColumn(rowIndex);
        }
    }

    private void initColumn(int rowIndex){
        for(int columnIndex = 0; columnIndex < COLUMN_SIZE; columnIndex++){
            //TODO: 함수로 분리
            ladder[rowIndex][columnIndex] = LadderLine.VERTICAL.validate(columnIndex) ? LadderLine.VERTICAL
                    : LadderLine.HORIZONTAL.validate(columnIndex) ? LadderLine.HORIZONTAL
                    : LadderLine.BLANK ;
        }
    }

    private LadderLine getLadderLine(int index){
        Random random = new Random();
        boolean isVertical = index%2 == 0;
        boolean isRandomPicked = random.nextBoolean();

        if(isVertical){
            return LadderLine.VERTICAL;
        }

        if(isRandomPicked){
            return LadderLine.HORIZONTAL;
        }

        return LadderLine.BLANK;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++){
            Arrays.stream(ladder[rowIndex])
                    .forEach(s -> sb.append(s == null ? " " : s.getLine()));
            sb.append("\n");
        }

        return sb.toString();
    }

    public void print(){
        for(int rowIndex = 0; rowIndex < ROW_SIZE; rowIndex++){
            for(int columnIndex = 0; columnIndex < COLUMN_SIZE; columnIndex++){
                LadderLine line = ladder[rowIndex][columnIndex];
                System.out.print(line == null ? " " : line.getLine());
            }
            System.out.println();
        }
    }

}
