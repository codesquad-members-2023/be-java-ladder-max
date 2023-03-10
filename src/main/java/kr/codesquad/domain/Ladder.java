package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private Elements names;
    private Elements results;
    private List<LadderRow> radder = new ArrayList<>();

    public Ladder(String nameData, String resultData, int height) {
        names = new Elements(nameData.split(","));
        results = new Elements(resultData.split(","));

        for (int i = 0; i < height; i++) {
            radder.add(new LadderRow(names.size() - 1));
        }
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
}
