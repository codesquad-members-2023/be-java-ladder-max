package kr.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<LadderLine> ladder;

    public Ladder(){
        this.ladder = new ArrayList<>();
    }

    public void make(int playerNumber, int ladderHeight) {
        // 1. 사다리를 만든다
        makeLadderLine(playerNumber, ladderHeight);
        // 2. 유효성 검사를 한다 (세로줄 공백인지 확인하고, 사다리 재입력 받음)
        while (!available() && ladderHeight != 1){
            ladder.clear();
            makeLadderLine(playerNumber, ladderHeight);
        }
        // 3. OutputView에 넘겨서 바로 출력 가능하게 만들어준다.
//        generate();
    }

    private void makeLadderLine(int playerNumber, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) { // 행 넣기
            LadderLine ladderLine = new LadderLine();
            ladderLine.make(playerNumber);
            ladder.add(ladderLine);
        }
    }

    private boolean available(){
        int[] countBlanks = new int[ladder.get(0).size()];
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
    
    public String generate(){
        StringBuilder sb = new StringBuilder();
        for (LadderLine ladderLine : ladder) {
            sb.append("  "); // player name과 맞추기 위해서
            sb.append(ladderLine.generate()).append("\n");
        }
        return sb.toString();
    }

    public List<Integer> play(){
        List<Integer> mappingIndex = new ArrayList<>();
        int playerNum = ladder.get(0).size()+1;
        for (int i = 0; i < playerNum; i++) { // player 수
            int nowIndex = i;
            for (int j = 0; j < ladder.size(); j++) { // 사다리 높이
                nowIndex += compareRight(nowIndex, playerNum, j) + compareLeft(nowIndex, j);
            }
            mappingIndex.add(nowIndex);
        }
        return mappingIndex;
    }

    private int compareRight(int nowIndex, int playerNum, int height) {
        if (nowIndex == playerNum-1) { // 오른쪽 끝
            return 0;
        }
        if (ladder.get(height).get(nowIndex)) { // 오른쪽 발판 있으면
            return 1;
        }
        return 0;
    }

    private int compareLeft(int nowIndex, int height){
        if (nowIndex == 0) { // 왼쪽 끝
            return 0;
        }
        if (ladder.get(height).get(nowIndex-1)) { // 왼쪽 발판 있으면
            return -1;
        }
        return 0;
    }

}
