package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final String FULL_BRIDGE = "-----";
    private static final String EMPTY_BRIDGE = "     ";
    private static final String VERTICAL_BAR = "|";
    private final List<String> line;

    public Line(int numOfPlayers) {
        this.line = generate(numOfPlayers);
    }

    public List<String> generate(int numOfPlayers) {
        int lineSize = numOfPlayers * 2 - 1;
        List<String> line = new ArrayList<>();
        for (int i = 0; i < lineSize; i++) {
            line.add("");
        }
        generateVertical(line);
        generateRandom(line);
        checkContinuous(line);
        return line;
    }

    private List<String> generateVertical(List<String> line) {
        for (int i = 0; i < line.size(); i++) {
            if (i % 2 == 0) {
                line.set(i, VERTICAL_BAR);
            }
        }
        return line;
    }

    private List<String> generateRandom(List<String> line) {
        Random random = new Random();
        for (int i = 0; i < line.size(); i++) {
            if (i % 2 != 0) {
                line.set(i, random.nextBoolean() ? FULL_BRIDGE : EMPTY_BRIDGE);
            }
        }
        return line;
    }

    private void checkContinuous(List<String> line) {
        for (int i = 0; i < line.size() - 2; i++) {
            if (line.get(i).equals(FULL_BRIDGE) && line.get(i + 2).equals(FULL_BRIDGE)) {
                line.set(i, EMPTY_BRIDGE);
            }
        }
    }

    public List<String> getLine() {
        return line;
    }

    public int getSize() {
        return line.size();
    }
}