package main.java.kr.ladder.view;

import java.util.List;

public class OutputView {
    private static final int DEFAULT_WIDTH = 6;
    StringBuilder sb;

    public OutputView(){
         sb = new StringBuilder();
    }

    public void printPeopleNameAndLadder(String[] peopleNames,int ladderHeight, List<List<String>> ladder){
        appendPeopleName(peopleNames, ladderHeight);
        appendLadder(ladder);

        System.out.println(sb); // 모아서 출력
        sb.setLength(0); // stringBuilder 초기화 (리셋)
    }

    public void appendPeopleName(String[] peopleNames, int ladderHeight){
        for (String peopleName : peopleNames) {
            sb.append(peopleName);
            addBlank(peopleName, ladderHeight);
        }
        sb.append("\n");
    }

    public void addBlank(String peopleName, int ladderHeight){
        for (int i = 0; i < DEFAULT_WIDTH - peopleName.length(); i++) {
            sb.append(" ");
        }
    }

    public void appendLadder(List<List<String>> ladders){ // 일단 2중 for문 사용
        for (List<String> ladder : ladders) {
            for (String str : ladder) {
                sb.append(str);
            }
            sb.append("\n");
        }
    }

}
