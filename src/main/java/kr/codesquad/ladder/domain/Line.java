package kr.codesquad.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Boolean> line;

    public Line(List<Boolean> line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "|" + line.stream()
                .map(bool -> bool ? "-----|" : "     |")
                .collect(Collectors.joining());
    }
}
