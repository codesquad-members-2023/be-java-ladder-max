package kr.codesquad.domain;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPerson, int countOfLadder) {
        for (int i = 0; i < countOfLadder; i++) {
            ladder.add(new Line(countOfPerson));
        }
    }
}
