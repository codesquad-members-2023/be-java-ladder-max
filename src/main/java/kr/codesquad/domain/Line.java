package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<String> line;

    public Line(int playersCount) {
        this.line = generateLine(playersCount);
    }

    public List<String> generateLine(int playersCount) {
        List<String> line = new ArrayList<>();
        int lineSize = playersCount * 2 - 1;
        for (int i = 0; i < lineSize; i++) {
            line.add("");
        }
        generateVertical(line);
        generateRandom(line);
        return line;
    }

    private List<String> generateVertical(List<String> line) {
        for (int i = 0; i < line.size(); i++) {
            if (i % 2 == 0) {
                line.set(i, "|");
            }
        }
        return line;
    }

    private List<String> generateRandom(List<String> line) {
        Random random = new Random();
        for (int i = 0; i < line.size(); i++) {
            if (i % 2 != 0 && random.nextBoolean()) {
                line.set(i, "-----");
                continue;
            }
            if (i % 2 != 0 && !random.nextBoolean()) {
                line.set(i, "     ");
            }
        }
        return line;
    }

    public List<String> getLine() {
        return line;
    }
}
