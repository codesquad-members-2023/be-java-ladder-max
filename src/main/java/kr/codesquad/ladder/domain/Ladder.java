package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private int length;
    private int countOfPerson;

    private List<Line> ladder;


    public Ladder( int length,int countOfPerson) {
        this.length = length;
        this.countOfPerson = countOfPerson-1;
        ladder = makeLadder();
    }
    public List<Line> makeLadder() {
        List<Line> list = new ArrayList<>();
        for (int i = 0; i<length; i++) {
            Line line = new Line(countOfPerson);
            list.add(line);
        }
        return list;
    }
}
