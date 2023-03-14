package kr.codesquad.domain;

public class LadderGame {
    private String[] players;
    public void start(String players, int row){
        this.players = players.split(",");
        Ladder ladder = new Ladder(row,this.players.length);
        ladder.makeLadder();
    }
}
