package Ladder2;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    ArrayList<ArrayList<String>> ladder;

    Ladder(ArrayList<String> pplNames, int ladderHeight){
        this.initLadder(pplNames, ladderHeight);
        this.createRandomBridges();
        Output output = new Output(this.ladder, pplNames);
    }

    private void createRandomBridges() {
        for (int i = 0; i <this.ladder.size(); i++){
            this.putBridges(i,ladder.get(0).size());
        }
    }

    private void putBridges(int i, int rowSize) {
        for(int j = 1; j < rowSize; j++){
            this.putRandomBridge(i,j, this.coinflip());
        }
    }

    private void putRandomBridge(int i, int j, boolean coinflip) {
        if(j > 1 && coinflip && this.ladder.get(i).get(j - 2) == "     "){
            this.ladder.get(i).set(j, "-----");
        }

        if(j == 1 && coinflip) {
            this.ladder.get(i).set(j, "-----");
        }
    }

    private boolean coinflip() {
        Random random = new Random();
        return random.nextBoolean();
    }

    private void initLadder(ArrayList<String> pplNames, int ladderHeight) {
        this.ladder = new ArrayList<>();
        for (int i = 0; i <ladderHeight; i++){
            this.initRow(i,pplNames.size());
        }
    }

    private void initRow(int i, int rowSize) {
        ArrayList<String> row = new ArrayList<>();
        for(int j = 0; j < rowSize; j++){
            row.add("|");
            row.add("     ");
        }
        row.subList(row.size()-1,row.size()).clear();
        ladder.add(row);
    }
}
