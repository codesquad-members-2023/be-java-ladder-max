package kr.codesquad.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder createLadder(int height, int playerCount) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(Line.createLine(playerCount));
        }
        return new Ladder(lines);
    }

    @Override
    public String toString() {
        return ladder.stream()
                .map(line -> line.toString())
                .collect(Collectors.joining("\n"));
    }

}
