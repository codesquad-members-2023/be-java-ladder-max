package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;
    private static final String LEG = "-----";
    private static final String BLANK = "     "; // 한번만 생성 보장

    public Line(int totalPoints) {
        this.points = new ArrayList<>();
        for(int idx = 0; idx < totalPoints - 1; idx++) {
            drawLine(new Random().nextBoolean(), idx);
        }
    }

    private boolean canDraw (int countOfPerson) {
        return countOfPerson == 0 || !points.get(countOfPerson - 1).booleanValue();
    }

    private void drawLine(boolean draw, int countOfPerson) {
        if(draw && canDraw(countOfPerson)) {
            addPoint(true);
            return;
        }
        addPoint(false);
    }

    private void addPoint(boolean b) {
        points.add(b);
    }

    @Override
    public String toString() {
        return points.stream()
                .map(o -> {
                    if(o.booleanValue()) return LEG;
                    return BLANK;
                })
                .reduce(new StringBuilder(), (sb, o) ->
                                sb.append(o).append("|")
                        , StringBuilder::append).toString();
    }

    public int goLine(int curr) {
        if(curr > 0 && points.get(curr - 1).booleanValue()) {
            return curr - 1;
        }
        if(curr < points.size() && points.get(curr).booleanValue()) {
            return curr + 1;
        }
        return curr;
    }
}
