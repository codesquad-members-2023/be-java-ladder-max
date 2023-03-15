package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


public class LadderLine {

    private final int lineWidth;
    private ArrayList<Boolean> points;

    public LadderLine(int countOfPeople) {
        this.lineWidth = countOfPeople - 1;
        this.points = new ArrayList<>();
    }

    void createLine() {
        new RandomLineGenerator().buildLadderLine(lineWidth,points);
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
        if (playerNumber > 0 && points.get(playerNumber - 1)) {
            return playerNumber - 1;
        }
        if (playerNumber < lineWidth && points.get(playerNumber)) {
            return playerNumber + 1;
        }
        return playerNumber;
    }
}
