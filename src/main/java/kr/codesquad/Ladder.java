package kr.codesquad;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final static int PLAYER_MAX_LENGTH = 5;
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

    public List<List<>> inform() {
        List<List<>> information = new ArrayList<>();

        information.add(informPlayers());
        information.add(informLadder());
        return information
    }

    private List<String> informPlayers() {
        return this.players;
    }

    private List<List<Boolean>> informLadder() {
        List<List<Boolean>> ladder = new ArrayList<>();

        for (Line l : this.ladder) {
            ladder.add(l.getLine());
        }
        return ladder;
    }
}
