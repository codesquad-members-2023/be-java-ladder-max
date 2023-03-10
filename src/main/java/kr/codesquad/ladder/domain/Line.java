package kr.codesquad.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Boolean> line;

    public Line(List<Boolean> line) {
        this.line = line;
    }

    public int switchIndex(int startIndex) {
        if (isFirstOrLast(startIndex)) {
            return firstOrLastIndex(startIndex);
        }
        return innerIndex(startIndex);
    }

    private boolean isFirstOrLast(int index) {
        if (index == 0 || index == line.size()) {
            return true;
        }
        return false;
    }

    private int firstOrLastIndex(int startIndex) {
        if (startIndex == 0 && line.get(startIndex)) {
            return ++startIndex;
        } else if (startIndex == line.size() && line.get(startIndex - 1)) {
            return --startIndex;
        }
        return startIndex;
    }

    private int innerIndex(int index) {
        if (line.get(index)) {
            return ++index;
        } else if (line.get(index - 1)) {
            return --index;
        }
        return index;
    }


    @Override
    public String toString() {
        return "|" + line.stream()
                .map(bool -> bool ? "-----|" : "     |")
                .collect(Collectors.joining());
    }
}
