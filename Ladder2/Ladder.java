package Ladder2;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    ArrayList<ArrayList<String>> ladder;

    Ladder(ArrayList<String> pplNames, int ladderHeight){
        this.initLadder(pplNames, ladderHeight);
        this.createRandomBridges();
        Output output = new Output(this.ladder);
    }

    private void createRandomBridges() {
        for (int i = 0; i <ladder.length; i++){
            this.putBridges(i,ladder[0].length);
        }
    }

    private void putBridges(int i, int rowSize) {
        for(int j = 1; j < rowSize; j+= 2){
            this.putRandomBridge(i,j, this.coinflip());
        }
    }

    private void putRandomBridge(int i, int j, boolean coinflip) {
        if(j > 1 && coinflip && this.ladder[i][j - 2] == " "){
            this.ladder[i][j] = "-";
        }

        if(j == 1 && coinflip) {
            this.ladder[i][j] = "-";
        }
    }
    private boolean coinflip() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private void initLadder(ArrayList<String> pplNames, int ladderHeight) {
        this.ladder = new String[ladderHeight][((pplNames.size() - 1) * 2) - 1];
        for (int i = 0; i <ladder.length; i++){
            this.initRow(i,ladder[0].length);
        }
    }

    private void initRow(int i, int rowSize) {
        for(int j = 0; j < rowSize; j+= 2){
            this.ladder[i][j] = "|";
        }
        for(int j = 1; j < rowSize; j+= 2){
            this.ladder[i][j] = " ";
        }
    }
}
