package kr.codesquad.domain;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> points;
    private final String LEG = "-----";
    private final String BLANK = "     ";

    public Line() {
        this.points = new ArrayList<>();
    }

    private boolean canDraw (int countOfPerson) {
        return countOfPerson == 0 || !points.get(countOfPerson - 1).booleanValue();
    }

    public void drawLine(boolean draw, int countOfPerson) {
        if(draw && canDraw(countOfPerson)) {
            addLine(true);
            return;
        }
        addLine(false);
    }

    private void addLine(boolean b) {
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
