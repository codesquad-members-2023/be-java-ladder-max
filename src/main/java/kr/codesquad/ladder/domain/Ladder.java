package kr.codesquad.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    /**
     * 사다리를 특정 열에서 타고 내려오면서 몇번째 열에서 내려오는지 탐색하는 기능
     *
     * @param col 사다리를 타고자 하는 열(0번째부터 시작)
     * @return 타고 내려온 열
     */
    public int climb(int col) {
        int selectedCol = col;
        for (Line line : lines) {
            selectedCol = line.climb(selectedCol);
        }
        return selectedCol;
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
        return result.toString().trim();
    }

}
