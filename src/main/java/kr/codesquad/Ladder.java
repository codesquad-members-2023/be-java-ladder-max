package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<List<String>> ladders;
    private final List<String> people;
    private final int height;

    Ladder(List<String> people, int height) {
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

    private List<String> makeLine() {
        Random random = new Random();
        List<String> ladder = new ArrayList<>();
        for(int idx = 0; idx < people.size() - 1; idx++) {
            boolean flag = random.nextBoolean();
            drawLine(flag, idx, ladder);
        }
        return ladder;
    }

    private void drawLine(boolean flag, int idx, List<String> ladder) {
        if(flag && (idx == 0 || ladder.get(idx - 1).equals("     "))) {
            ladder.add("-----");
            return;
        }
        ladder.add("     ");
    }

    void printLadder() {
        printPeople();
        for(List<String> ladder : ladders) {
            System.out.print("    |");
            System.out.println(ladder.stream()
                    .reduce(new StringBuilder(), (sb, o) ->
                                    sb.append(o).append("|")
                            , StringBuilder::append));
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
