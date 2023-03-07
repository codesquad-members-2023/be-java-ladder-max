package kr.codesquad;

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
            points.add("-----");
            return;
        }
        points.add("     ");
    }

    public String get(int idx) {
        return this.points.get(idx);
    }

    @Override
    public String toString() {
        return points.stream()
                .reduce(new StringBuilder(), (sb, o) ->
                                sb.append(o).append("|")
                        , StringBuilder::append).toString();
    }
}
