package Ladder2.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {
    private ArrayList<String> line = new ArrayList<>();

    private int size;

    public LadderRow(int size) throws IOException {
        this.size = size;

        this.initLine();
        this.createRandomBridges();

    }

    public void initLine() {

        for(int j = 0; j < this.size; j++){
            this.line.add("|");
            this.line.add("     ");
        }
        this.line.subList(this.line.size()-1,this.line.size()).clear();
    }

    private void createRandomBridges() {
        for (int i = 1; i <this.size; i+=2){
            this.putRandomBridge(i, this.coinflip());
        }
    }

    private void putRandomBridge(int i, boolean coinflip) {
        if(i > 1 && coinflip && this.line.get(i - 2) == "     "){
            this.line.set(i, "-----");
        }

        if(i == 1 && coinflip) {
            this.line.set(i, "-----");
        }
    }

    private boolean coinflip() {
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String s : line){
            sb.append(s);
        }
        sb.append("\n");
        return sb.toString();
    }


}
