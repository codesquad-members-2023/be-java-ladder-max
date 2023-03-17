package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> ladder;

    public Ladder(int numOfPlayers, int height) {
        this.ladder = generateLadder(numOfPlayers, height);
    }

    public List<Line> generateLadder(int numOfPlayers, int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Line(numOfPlayers))
                .collect(Collectors.toList());
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
