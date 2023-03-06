package Ladder;

public class Ladder {
    String[][] ladder;

    Ladder(int pplNumber, int ladderHeight){
        this.initLadder(pplNumber, ladderHeight);
        this.createRandomBridge();
        Output output = new Output(this);
    }

    private void initLadder(int pplNumber, int ladderHeight) {
        this.ladder = new String[ladderHeight][(pplNumber * 2) - 1];
        for (int i = 0; i <ladderHeight; i++){
            this.initRow(i,(pplNumber * 2) - 1);
        }
    }

    private void initRow(int i, int rowSize) {
        for(int j = 0; j < rowSize; j+= 2){
            this.ladder[i][j] = "|";
        }
    }
}
