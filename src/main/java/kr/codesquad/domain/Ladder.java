package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ladder {
    private ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPerson, int countOfLadder) {
        for (int i = 0; i < countOfLadder; i++) {
            ladder.add(new Line(countOfPerson));
        }
    }

    public int moveVertically(int index, int position) {
        return ladder.get(index).moveHorizontally(position);
    }

    @Override
    public String toString() {
        return ladder.stream()
                .map(Line::toString)
                .map(a -> "  " + a)
                .collect(Collectors.joining("\n"));
    }
}
