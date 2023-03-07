package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> ladders;
    private final List<String> people;
    private final int height;

    public Ladder(List<String> people, int height) {
        this.people = people;
        this.height = height;
        this.ladders = new ArrayList<>(); // 출력할 때 | 추가할거임
        makeLadder();
        printLadder();
    }

    void makeLadder() {
        for(int idx = 0; idx < height; idx++) {
            ladders.add(makeLine());
        }
    }

    private Line makeLine() {
        Random random = new Random();
        Line line = new Line();
        for(int idx = 0; idx < people.size() - 1; idx++) {
            line.drawLine(idx);
        }
        return line;
    }

    private void printLadder() {
        printPeople();
        for(Line line : ladders) {
            System.out.print("    |");
            System.out.println(line);
        }
    }

    private void printPeople() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        System.out.println(people.stream()
                .map(o -> " " + String.format("%5s", o))
                .reduce(new StringBuilder(), (sb, o) ->
                                sb.append(o)
                        , StringBuilder::append));
    }
}
