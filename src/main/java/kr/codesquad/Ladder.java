package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<String> players;
    private final int height;
    private final List<Line> ladder = new ArrayList<>();

    Ladder(List<String> players, int height) {
        this.players = players;
        this.height = height;
        buildLadder();
    }
    
    Ladder(List<Line> ladder) {
        this.players = null;
        this.height = ladder.size();
        this.ladder.addAll(ladder);

    }

    private void buildLadder() {
        for (int cnt = 0; cnt < height; cnt++) {
            Line l = new Line(players.size());
            ladder.add(l);
        }
    }

    public List<Line> getline() {
        return this.ladder;
    }
}
