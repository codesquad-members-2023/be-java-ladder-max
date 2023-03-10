package Ladder2.domain;

import Ladder2.view.Output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Ladder {
    ArrayList<LadderRow> ladder;
    int height;

    public Ladder(int ladderLength) throws IOException {
        this.height = new LadderHeight().getHeight();
        this.createLadder(ladderLength, height);
    }

    private void createLadder(int size, int ladderHeight) throws IOException {
        this.ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            this.ladder.add(new LadderRow(size));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow line : ladder){
            sb.append("     ").append(line.toString());
        }
        return sb.toString();
    }

}


