package kr.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
    protected List<Boolean> ladderLine;

    public LadderLine(){
        this.ladderLine = new ArrayList<>();
    }

    public void makeLadderLine(int playerNumber){
        for (int i = 0; i < playerNumber-1; i++) { // 열 넣기 (그룹 개수)
            ladderLine.add(randomBoolean());
        }
        checkDoubleFoothold();
        checkEmptyFoothold();
    }

    private Boolean randomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    private void checkDoubleFoothold(){ // "-----" + "-----" 일 때 발판 바꾸기
        for (int i = 0; i < ladderLine.size()-1; i++) {
            if (ladderLine.get(i) && ladderLine.get(i+1)) {
                ladderLine.set(i+1, false);
            }
        }
    }

    private void checkEmptyFoothold(){ // 3연속 false (공백)일 때 가운데 true (하이픈)으로 바꾸기
        for (int i = 1; i < ladderLine.size()-1; i++) {
            if (!ladderLine.get(i-1) && !ladderLine.get(i) && !ladderLine.get(i+1)) {
                ladderLine.set(i, true);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");

        for (boolean foothold : ladderLine) {
            sb.append(makeFoothold(foothold)).append("|");
        }
        return sb.toString();
    }

    private String makeFoothold(boolean foothold){
        if (foothold) {
            return "-----";
        }
        return "     ";
    }

    public int size(){
        return ladderLine.size();
    }

    public boolean get(int i){
        return ladderLine.get(i);
    }

    // Test
    public int isFilled(){
        return ladderLine.size();
    }

    public boolean isDoubleFoothold(){
        for (int i = 0; i < ladderLine.size()-1; i++) {
            if (ladderLine.get(i) && ladderLine.get(i+1)) {
                return false;
            }
        }
        return true;
    }

}
