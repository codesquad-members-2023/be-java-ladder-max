package kr.codesquad;

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
            ladder[rowIndex][columnIndex] = LadderLine.VERTICAL.isProperLocation(columnIndex) ? LadderLine.VERTICAL
                    : LadderLine.HORIZONTAL.isProperLocation(columnIndex) ? LadderLine.HORIZONTAL
                    : null ;
        }
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
