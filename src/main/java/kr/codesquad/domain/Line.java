package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private final ArrayList<String> points;

    public Line() {
        this.points = new ArrayList<>();
    }

    public boolean canDraw (int countOfPerson) {
        return countOfPerson == 0 || points.get(countOfPerson - 1).equals("     ");
    }

    public void drawLine(int countOfPerson) {
        Random random = new Random();
        boolean draw = random.nextBoolean();
        if(draw && canDraw(countOfPerson)) {
            addLine("-----");
            return;
        }
        addLine("     ");
    }

    public void addLine(String s) {
        points.add(s);
    }

    @Override
    public String toString() {
        return points.stream()
                .reduce(new StringBuilder(), (sb, o) ->
                                sb.append(o).append("|")
                        , StringBuilder::append).toString();
    }
}
