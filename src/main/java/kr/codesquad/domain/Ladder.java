package kr.codesquad.domain;

import java.util.ArrayList;

import static kr.codesquad.domain.LadderLine.drawLine;

public class Ladder {
    private final int countOfPeople;
    private final int ladderHeight;
    private  ArrayList ladder;
    private ArrayList<String> nameList;


    public Ladder(ArrayList nameList,int ladderHeight) {
        this.ladderHeight = ladderHeight;
        this.nameList = nameList;
        this.countOfPeople = this.nameList.size();
        createLadder();
    }

    private void createLadder() {
        ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            LadderLine ladderLine = new LadderLine(countOfPeople);
            ladderLine.createLine();
            ladder.add(ladderLine);
        }
    }

    private void drawName(StringBuilder sb){
        for(String name: nameList){
            sb.append(String.format(" %1$-5s", name));
        }
        sb.append("\n");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        drawName(sb);
        drawLine(ladder,sb);
        return sb.toString();
    }
}
