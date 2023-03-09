package kr.codesquad;

public class Ladder {

    final int ROW_SIZE;
    final int COLUMN_SIZE;
    private final LadderLine[][] ladder;

    public Ladder(int n, int m) {
        ROW_SIZE = m;
        COLUMN_SIZE = n * 2 - 1;
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




}
