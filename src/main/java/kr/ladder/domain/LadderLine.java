package kr.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
    protected List<Boolean> ladderLine;

    public LadderLine(){
        this.ladderLine = new ArrayList<>();
    }

    public void make(int playerNumber){
        for (int i = 0; i < playerNumber-1; i++) { // 열 넣기 (그룹 개수)
            ladderLine.add(randomBoolean());
        }

        checkDoubleFoothold();
    }

    private Boolean randomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }

    private void checkDoubleFoothold(){ // "-----" + "-----" 일 때 발판 바꾸기
        for (int i = 0; i < ladderLine.size()-1; i++) {
            fixDoubleFoothold(i);
        }
    }

    private void fixDoubleFoothold(int i){
        if (ladderLine.get(i) && ladderLine.get(i+1)) {
            ladderLine.set(i, false);
        }
    }

    public String generate() {
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

}
