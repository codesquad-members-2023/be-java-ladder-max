package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public String toString() {
        return lines.stream()
                .map(line -> line.toString())
                .collect(Collectors.joining("\n"));
    }

    public int findLastPosition(int startIndex) {
        int position = startIndex;
        for (int index = 0; index < lines.size(); index++) {
            position = lines.get(index).switchIndex(position);
        }
        return position;
    }

}
