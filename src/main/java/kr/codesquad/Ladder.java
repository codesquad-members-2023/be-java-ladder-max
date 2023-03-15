package kr.codesquad;

import java.util.List;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public String drawLadder() {
        StringBuilder sb = new StringBuilder();

        for (Line row : ladder) {
            sb.append(row.drawLine());
            sb.append("\n");
        }
        return sb.toString();
    }
}
