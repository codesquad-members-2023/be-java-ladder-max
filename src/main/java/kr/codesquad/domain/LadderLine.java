package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Random;

public class LadderLine {

    private final int lineWidth;
    private ArrayList<Boolean> points = new ArrayList();

    public LadderLine(int countOfPeople) {
        lineWidth = countOfPeople - 1;
        buildLadderLine();
    }

    private ArrayList buildLadderLine() {
        for (int i = 0; i < lineWidth; i++) {
            points.add(hasRung() ? true : false);
        }
        return points;
    }

    private boolean hasRung() {
        if (points.isEmpty()) {
            return new Random().nextBoolean();
        }
        return new Random().nextBoolean() && !points.get(points.size() - 1);
    }

    static void drawLine(ArrayList<LadderLine> ladder,StringBuilder sb){
        for(LadderLine line: ladder){
            sb.append("  |");
            drawRung(sb, line);
            sb.append("\n");
        }
    }

    private static void drawRung(StringBuilder sb, LadderLine line) {
        for (boolean hasRung : line.points) {
            sb.append(hasRung ? "-----|" : "     |");
        }
    }
}
