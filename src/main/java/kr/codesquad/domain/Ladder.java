package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> ladder;

    public Ladder(int numOfPlayers, int height) {
        this.ladder = generate(numOfPlayers, height);
    }

    public List<Line> generate(int numOfPlayers, int height) {
        return IntStream.range(0, height)
                .mapToObj(l -> new Line(numOfPlayers))
                .collect(Collectors.toList());
    }

    public Line getOneLine(int index) {
        return ladder.get(index);
    }

    public int getSize() {
        return ladder.size();
    }
}