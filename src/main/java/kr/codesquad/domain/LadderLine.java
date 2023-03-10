package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;


public class LadderLine {

    private final int lineWidth;
    ArrayList<Boolean> points;

    LinePointsValidator linePointsValidator;

    public LadderLine(int countOfPeople) {
        this.lineWidth = countOfPeople - 1;
        this.points = new ArrayList();
        linePointsValidator = new LinePointsValidator();
    }

    void createLine(){
        buildLadderLine();
    }

    private void buildLadderLine() {
        IntStream.range(0, lineWidth)
                .mapToObj(i -> generateRungStatus())
                .forEach(points::add);
        linePointsValidator.validatePoints(points);
    }

    private boolean generateRungStatus() {
        if (points.isEmpty()) {
            return new Random().nextBoolean();
        }
        return new Random().nextBoolean() && !points.get(points.size() - 1);
    }

    static void drawLine(ArrayList<LadderLine> ladder, StringBuilder sb) {
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
}
