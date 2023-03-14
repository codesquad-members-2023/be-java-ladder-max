package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private int length;
    private int countOfPerson;

    private List<Line> ladder;


    public Ladder( int length,int countOfPerson) {
        this.length = length;
        this.countOfPerson = countOfPerson-1;
        ladder = makeLadder();
    }
    private List<Line> makeLadder() {
        return IntStream.range(0,length)
                .mapToObj(i->new Line(countOfPerson))
                .collect(Collectors.toList());
    }
    @Override
    public String toString(){
        return ladder.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
}
