package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<LadderRow> ladder = new ArrayList<>();

    public Ladder(int namesSize, int height) {
        for (int i = 0; i < height; i++) {
            ladder.add(new LadderRow(namesSize - 1));
        }
    }

    public int moveDown(int index) {
        for (int i = 0; i < ladder.size(); i++) {
            LadderRow row = ladder.get(i);
            index = row.moveLine(index);
        }
        return index;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ladder.size(); i++) {
            sb.append(ladder.get(i));
            sb.append("\n");
        }

        return sb.toString();
    }
}
