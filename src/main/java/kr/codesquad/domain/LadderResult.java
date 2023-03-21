package kr.codesquad.domain;

import java.util.List;

public class LadderResult {
    List<String> players;
    List<Line> lines;

    public LadderResult(List<String> players, List<Line> lines){
        this.players = players;
        this.lines = lines;
    }

    public List<String> getPlayers(){
        return players;
    }

    public List<Line> getLines(){
        return lines;
    }
}
