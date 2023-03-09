package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderLine {

    private final int lineWidth;

    //TestCode를 위해 default로 설정
    ArrayList<Boolean> points = new ArrayList();

    public LadderLine(int countOfPeople) {
        this.lineWidth = countOfPeople - 1;
    }

    void createLine(){
        buildLadderLine();
        pointsValidate();
    }

    private void buildLadderLine() {
        IntStream.range(0, lineWidth)
                .mapToObj(i -> hasRung())
                .forEach(points::add);
    }

    private boolean hasRung() {
        if (points.isEmpty()) {
            return new Random().nextBoolean();
        }
        return new Random().nextBoolean() && !points.get(points.size() - 1);
    }

    void pointsValidate() {
        IntStream.range(0, points.size()-1)
                .filter(i ->points.get(i) && points.get(i + 1))
                .findFirst()
                .ifPresent(i -> {
            throw new IllegalStateException("연속적인 true 존재");
        });
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
