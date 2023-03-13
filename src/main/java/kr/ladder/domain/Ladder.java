package kr.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<LadderLine> ladder;

    public Ladder(){
        this.ladder = new ArrayList<>();
    }

    public void makeLadder(int playerNumber, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) { // 행 넣기
            LadderLine ladderLine = new LadderLine();
            ladderLine.makeLadderLine(playerNumber);
            ladder.add(ladderLine);
        }
    }
    
    private void makeLadderColumnGroup(List<String> ladderLine, int peopleNumber){
        int[] columnFalses = new int[ladder.size()];
        for (LadderLine ladderLine : ladder) {
            List<Boolean> booleans = ladderLine.ladderLine;
            for (int i = 0; i < booleans.size(); i++) {
                }
            }
        }
        
        for (int i = 0; i < columnFalses.length; i++) {
            if (columnFalses[i] == ladderHeight) {
                changeLadderColumn(i);
            }
        }
    }

    // 하드 코딩해서 마지막 열에서 
    private void changeLadderColumn(int falseIndex){
        
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (LadderLine ladderLine : ladder) {
            sb.append(ladderLine.toString()).append("\n");
        }
        return sb.toString();
    }
}
