package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public void addLine(List<Boolean> bool) {
        Line line = new Line(bool);
        ladder.add(line);
    }

    public String drawLadder() {
        StringBuilder sb = new StringBuilder();

        for (Line row : ladder) {
            sb.append(row.drawLine());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getLadderSize() {
        return this.ladder.size();
    }
}
