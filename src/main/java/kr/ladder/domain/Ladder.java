package kr.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladder;

    public Ladder(){
        this.ladder = new ArrayList<>();
    }

    public void make(int playerNumber, int ladderHeight) {
        // 1. 사다리를 만든다
        makeLadderLine(playerNumber, ladderHeight);
        // 2. 유효성 검사를 한다 (세로줄 공백인지 확인하고, 사다리 재입력 받음)
        while (!available()){
            makeLadderLine(playerNumber, ladderHeight);
        }
        // 3. OutputView에 넘겨서 바로 출력 가능하게 만들어준다.
//        generate();
    }
    
    private void makeLadderLine(int playerNumber, int ladderHeight){
        for (int i = 0; i < ladderHeight; i++) { // 행 넣기
            LadderLine ladderLine = new LadderLine();
            ladderLine.make(playerNumber);
            ladder.add(ladderLine);
        }
    }

    private boolean available(){
        int[] countBlanks = new int[ladder.size()];
        for (LadderLine ladderLine : ladder){
            countBlank(countBlanks, ladderLine);
        }

        return isFilled(countBlanks);
    }

    private void countBlank(int[] countBlanks, LadderLine ladderLine){
        for (int i = 0; i < ladderLine.size(); i++) {
            if (!ladderLine.get(i)) {
                countBlanks[i]++;
            }
        }
    }

    private boolean isFilled(int[] countBlanks){
        for (int count : countBlanks) {
            if (count == ladder.size()) {
                return false;
            }
        }
        return true;
    }

//    욕심 시작...
//    private void rebuildColumn(int ladderHeight){
//        int[] columnFalses = new int[ladder.size()];
//        for (LadderLine ladderLine : ladder) {
//            List<Boolean> booleans = ladderLine.ladderLine;
//            for (int i = 0; i < booleans.size(); i++) {
//                if (!booleans.get(i)){
//                    columnFalses[i]++;
//                }
//            }
//        }
//
//        for (int i = 0; i < columnFalses.length; i++) {
//            if (columnFalses[i] == ladderHeight) {
//                changeLadderColumn(i);
//            }
//        }
//    }

    // 하드 코딩해서 마지막 열에서 추가하는 것으로 생각중..
//    private void changeLadderColumn(int falseIndex){
//
//    }
    
    public String generate(){
        StringBuilder sb = new StringBuilder();
        for (LadderLine ladderLine : ladder) {
            sb.append(ladderLine.generate()).append("\n");
        }
        return sb.toString();
    }

}
