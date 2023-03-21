package kr.codesquad.domain;

import kr.codesquad.view.OutputView;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<String> players;
    private final int ladderHeight;
    private final int playerSize;

    private List<Line> lines = new ArrayList<>();

    public Ladder(List<String> players, int ladderHeight){
        this.players = players;
        this.ladderHeight = ladderHeight;
        playerSize = players.size();
    }

    public LadderResult run(){
        generateLine();
        return getResultForView();
    }

    public void generateLine(){
        LineGenerator lineGenerator = new LineGenerator();
        for(int i = 0; i < ladderHeight; i++){
            lines.add(lineGenerator.execute(playerSize));
        }
    }

    public LadderResult getResultForView(){
        return new LadderResult(Collections.unmodifiableList(players), Collections.unmodifiableList(lines));
    }
}
