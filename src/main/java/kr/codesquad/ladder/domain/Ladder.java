package kr.codesquad.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ladder)) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Line line : lines) {
            result.append(line).append("\n");
        }
        return result.toString();
    }
}
