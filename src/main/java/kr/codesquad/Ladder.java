package kr.codesquad;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder;

    public Ladder(ArrayList<Line> ladder) {
        this.ladder = ladder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var line : ladder) {
            sb.append("  "); // 사람 이름 5글자가 기준이므로 사다리 앞에 2칸의 간격 추가
            for (int i = 0; i < line.size(); i++) {
                sb.append(line.hasBridge(i) ? "|-----" : "|     ");
            }
            sb.append("\n");
        }

        return String.valueOf(sb);
    }

    public ArrayList<Line> getLadder() {
        return ladder;
    }
}
