package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> ladder = new ArrayList<>();

    public void addLine(Line line) {
        ladder.add(line);
    }

    @Override
    public String toString() {
        return ladder.stream()
                .map(line -> line.toString())
                .collect(Collectors.joining("\n"));
    }

}
