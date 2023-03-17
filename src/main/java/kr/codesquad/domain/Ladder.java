package kr.codesquad.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static kr.codesquad.domain.Line.lineSize;

public class Ladder {
    private List<Line> ladder;

    public Ladder(int numOfPlayers, int height) {
        this.ladder = generate(numOfPlayers, height);
    }

    public List<Line> generate(int numOfPlayers, int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> new Line(numOfPlayers))
                .collect(Collectors.toList());
    }

    public List<Line> getLadder() {
        return ladder;
    }
}