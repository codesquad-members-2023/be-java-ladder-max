package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private final List<String> line;
    public static int lineSize;

    public Line(int numOfPlayers) {
        this.lineSize = numOfPlayers * 2 - 1;
        this.line = generateLine(numOfPlayers);
    }

    public List<String> generateLine(int numOfPlayers) {
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
                line.set(i, "|");
            }
        }
        return line;
    }

    private List<String> generateRandom(List<String> line) {
        Random random = new Random();
        for (int i = 0; i < line.size(); i++) {
            if (i % 2 != 0) {
                line.set(i, random.nextBoolean() ? "-----" : "     ");
            }
        }
        return line;
    }

    private void checkContinuous(List<String> line) {
        for (int i = 0; i < line.size() - 2; i++) {
            if (line.get(i).equals("-----") && line.get(i + 2).equals("-----")) {
                line.set(i, "     ");
            }
        }
    }

    public List<String> getLine() {
        return line;
    }
}
