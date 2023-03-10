package main.java.kr.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int DEFAULT_LADDER_GROUP_WIDTH = 6;
    private List<List<String>> ladder;

    public Ladder(){
        this.ladder = new ArrayList<>();
    }

    public void makeLadder(int peopleNumber, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) { // 행 넣기
            List<String> ladderLine = new ArrayList<>();
            makeLadderColumnGroup(ladderLine, peopleNumber);
            ladder.add(ladderLine);
        }
    }

    private void makeLadderColumnGroup(List<String> ladderLine, int peopleNumber){
        for (int i = 0; i < peopleNumber-1; i++) { // 열 넣기 (그룹 개수)
            for (int j = 0; j < DEFAULT_LADDER_GROUP_WIDTH; j++) { // 한 그룹 안의 요소 넣기
                makePipe(ladderLine, j);
                makeHyphenOrBlank(ladderLine,i, j, peopleNumber);
            }
        }
        ladderLine.add("|");
    }

    private void makePipe(List<String> ladderLine, int j){
        if (j == 0) {
            ladderLine.add("|");
        }
    }

    // 여기서 그룹이란! pipe(|)를 기준으로 나눴을 때, 나머지 부분을 이야기 한다.
    private void makeHyphenOrBlank(List<String> ladderLine, int i, int j, int peopleNumber){
        int lastLadderGroupNumber = peopleNumber - 2;
        String beforeGroupChar = ladderLine.get(ladderLine.size() - 3);

        // 그룹의 시작 문자를 판단하는 3가지 메서드
        chooseFirstCharOfGroup(ladderLine, i, j, lastLadderGroupNumber, beforeGroupChar);
        // 판단한 시작 문자로 반복해서 넣는 메서드
        repeatFirstCharOfGroup(ladderLine, i, j);
    }
    private void chooseFirstCharOfGroup(List<String> ladderLine, int i, int j, int lastLadderGroupNumber, String beforeGroupChar) {
        // 공백이나 하이픈을 랜덤으로 넣어도 되는 경우
        if (j == 1) {
            checkRandomHyphenOrBlank(ladderLine, i, lastLadderGroupNumber, beforeGroupChar);
            // 공백을 넣어야만 하는 경우
            checkBlank(ladderLine, i, beforeGroupChar);
            // 하이픈을 넣어야만 하는 경우
            checkHyphen(ladderLine, i, lastLadderGroupNumber);
        }
    }

    private void repeatFirstCharOfGroup(List<String> ladderLine, int i, int j) {
        if (j > 1) {
            // 그룹의 중간~끝 부분일 경우 (그룹의 시작이 아닐 경우), 그룹의 시작(윗부분에서 판가름 해서 넣은)을 반복해서 넣는다.
            addFirstChar(ladderLine, i);
        }
    }

    private String randomChar(){
        Random random = new Random();
        if (random.nextBoolean()) {
            return "-"; // true
        }
        return " "; // false
    }

    // 맨 앞일 경우 || (checkHyphen의 경우가 아니면서 && 그 전의 그룹이 공백이었을 경우)
    private void checkRandomHyphenOrBlank(List<String> ladderLine, int i, int lastLadderGroupNumber, String beforeGroupChar){
        if (i == 0
                || (!((i == lastLadderGroupNumber) && !ladderLine.contains("-"))
                    && beforeGroupChar.equals(" "))) {
            ladderLine.add(randomChar());
        }
    }
    // 맨 앞이 아니면서 && 그 전의 그룹이 Hyphen 이었을 경우
    private void checkBlank(List<String> ladderLine, int i, String beforeGroupChar){
        if (i != 0 && beforeGroupChar.equals("-")) {
            ladderLine.add(" ");
        }
    }
    // 맨 마지막 그룹이면서 (사람수-2 == i) && 여태까지 "-"가 한번도 넣어진 적 없는 경우
    private void checkHyphen(List<String> ladderLine, int i, int lastLadderGroupNumber){
        if ((i == lastLadderGroupNumber) && !ladderLine.contains("-")) {
            ladderLine.add("-");
        }
    }

    // 그룹의 시작 부분을 반복해서 ladderLine에 넣는다.
    private void addFirstChar(List<String> ladderLine, int i){
        ladderLine.add(ladderLine.get((i * 6) + 1)); // 현재 뭉터기의 첫 부분
    }

    public List<List<String>> getLadder(){
        return ladder;
    }
}
