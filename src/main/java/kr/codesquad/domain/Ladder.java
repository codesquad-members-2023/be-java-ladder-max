package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final String NEW_LINE = "\n";
    private final int FIRST_INDEX = 0;
    private final int LAST_INDEX = 1;
    private final List<Line> ladders = new ArrayList<>();

    public void add(Line line) {
        ladders.add(line);
    }

    public void play() {

    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladders) {
            sb.append(line.show());
            sb.append(NEW_LINE);
        }
        return sb.substring(FIRST_INDEX, sb.length() - LAST_INDEX);
    }
}
