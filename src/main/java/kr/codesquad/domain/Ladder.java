package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private Elements names;
    private Elements results;
    private List<LadderRow> ladder = new ArrayList<>();
    private List<Integer> ladderResult = new ArrayList<>();

    public Ladder(String nameData, String resultData, int height) {
        names = new Elements(nameData.split(","));
        results = new Elements(resultData.split(","));

        for (int i = 0; i < height; i++) {
            ladder.add(new LadderRow(names.size() - 1));
        }
    }

    public void playLadderGame() {
        for (int i = 0; i < names.size(); i++) {
            moveDown(i);
        }
    }

    public void moveDown(int index) {
        for (int i = 0; i < ladder.size(); i++) {
            LadderRow row = ladder.get(i);
            index = row.moveLine(index);
        }
        ladderResult.add(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n사다리 출력\n");
        // 이름 row
        sb.append(names + "\n");
        // 사다리 row
        for (int i = 0; i < ladder.size(); i++) {
            sb.append(ladder.get(i));
            sb.append("\n");
        }
        // 결과 row
        sb.append(results + "\n");
        return sb.toString();
    }

    public void printPlayerResult(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n실행 결과\n");
        sb.append(results.get(ladderResult.get(names.indexOf(name))) + "\n");
        System.out.println(sb);
    }

    public void printAllResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과\n");
        for (int i = 0; i < names.size(); i++) {
            sb.append(names.get(i) + " : " + results.get(ladderResult.get(i)) + "\n");
        }
        System.out.println(sb);
    }
}
