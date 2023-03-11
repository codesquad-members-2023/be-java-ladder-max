package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    private final ArrayList<Integer> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            fillCountOfPerson();
            fillCountOfLadder(2 * i);
        }
        fillCountOfPerson();
    }

    // "|": 2
    private void fillCountOfPerson() {
        points.add(2);
    }

    // "     ": 0, "-----": 1
    private void fillCountOfLadder(int index) {
        if (index >= 2 && points.get(index - 1) == 1) {
            points.add(0);
            return;
        }
        points.add(new Random().nextInt(2));
    }

    @Override
    public String toString() {
        String[] str = {"     ", "-----", "|"};
        return points.stream().map(b -> str[b]).collect(Collectors.joining(""));
    }
}
