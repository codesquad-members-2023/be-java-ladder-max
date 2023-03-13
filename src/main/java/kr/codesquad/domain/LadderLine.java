package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class LadderLine {

    private final int lineWidth;
    ArrayList<Boolean> points;

    public LadderLine(int countOfPeople) {
        this.lineWidth = countOfPeople - 1;
        this.points = new ArrayList<>();
    }

    void createLine() {
        points.addAll(new RandomLineGenerator().buildLadderLine(lineWidth));
    }

    static void drawLine(List<LadderLine> ladder, StringBuilder sb) {
        for (LadderLine line : ladder) {
            sb.append("  |");
            drawRung(sb, line);
            sb.append("\n");
        }
    }

    private static void drawRung(StringBuilder sb, LadderLine line) {
        for (boolean boolInLine : line.points) {
            sb.append(boolInLine ? "-----|" : "     |");
        }
    }

    int canMove(int playerNumber) {
        int pos = playerNumber;
        if (pos > 0 && points.get(pos - 1)) {
            return pos - 1;
        }
        if (pos < lineWidth && points.get(pos)) {
            return pos + 1;
        }
        return pos;
    }
}
