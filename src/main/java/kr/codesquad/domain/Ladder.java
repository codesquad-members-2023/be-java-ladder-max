package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private Elements names;
    private Elements results;
    private List<LadderRow> radder = new ArrayList<>();
    private List<Integer> radderResult = new ArrayList<>();

    public Ladder(String nameData, String resultData, int height) {
        names = new Elements(nameData.split(","));
        results = new Elements(resultData.split(","));

        for (int i = 0; i < height; i++) {
            radder.add(new LadderRow(names.size() - 1));
        }
    }

    public void playLadderGame() {
        for (int i = 0; i < names.size(); i++) {
            moveDown(i);
        }
    }

    public void moveDown(int index) {
        for (int i = 0; i < radder.size(); i++) {
            LadderRow row = radder.get(i);
            index = row.moveLine(index);
        }
        radderResult.add(index);
    }

    public void printRadder() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n사다리 출력\n");
        // 이름 row
        sb.append(names + "\n");
        // 사다리 row
        for (int i = 0; i < radder.size(); i++) {
            sb.append(radder.get(i));
            sb.append("\n");
        }
        // 결과 row
        sb.append(results + "\n");
        System.out.println(sb);
    }

    public void printPlayerResult(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n실행 결과\n");
        sb.append(results.get(radderResult.get(names.indexOf(name))) + "\n");
        System.out.println(sb);
    }

    public void printAllResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과\n");
        for (int i = 0; i < names.size(); i++) {
            sb.append(names.get(i) + " : " + results.get(radderResult.get(i)) + "\n");
        }
        System.out.println(sb);
    }
}
