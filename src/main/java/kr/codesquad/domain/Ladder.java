package kr.codesquad.domain;


import kr.codesquad.view.InputView;

import java.util.List;

public class Ladder {

    private final List<String> players;
    private final int ladderHeight;
    private List<Line> lines;
    private final int playerSize;

    public Ladder(List<String> players, int ladderHeight){
        this.players = players;
        this.ladderHeight = ladderHeight;
        playerSize = players.size();
    }

    public void run(){
        generateLine();
    }

    public void generateLine(){
        LineGenerator lineGenerator = new LineGenerator();
        for(int i = 0; i < ladderHeight; i++){
            lines.add(lineGenerator.execute(playerSize));
        }
    }
}
