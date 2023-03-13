package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.HashMap;

import static kr.codesquad.domain.LadderLine.drawLine;

public class Ladder {
    private final int countOfPeople;
    private final int ladderHeight;
    private ArrayList<LadderLine> ladder;
    private ArrayList<String> nameList;
    private HashMap<String, Integer> resultMap;


    public Ladder(ArrayList nameList, int ladderHeight) {
        this.ladderHeight = ladderHeight;
        this.nameList = nameList;
        this.countOfPeople = this.nameList.size();
        createLadder();
        resultMap = new HashMap<>();
    }

    private void createLadder() {
        ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            LadderLine ladderLine = new LadderLine(countOfPeople);
            ladderLine.createLine();
            ladder.add(ladderLine);
        }
    }
    public HashMap<String, Integer> generateResultMap(){
        makeResultMap();
        return resultMap;
    }

    private void makeResultMap() {
        int i = 0;
        for (String name : nameList) {
            resultMap.put(name, i++);
        }
        for (LadderLine line : ladder) {
            line.canMove(resultMap, nameList);
        }
    }

    private void drawName(StringBuilder sb) {
        for (String name : nameList) {
            sb.append(String.format(" %1$-5s", name));
        }
        sb.append("\n");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        drawName(sb);
        drawLine(ladder, sb);
        return sb.toString();
    }
}
