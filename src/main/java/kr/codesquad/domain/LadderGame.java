package kr.codesquad.domain;

public class LadderGame {
    private String[] players;
    public void start(String players, int row){
        this.players = players.split(",");
        Ladder ladder = new Ladder(row,this.players.length);
        printPlayers();
        printLadder(ladder.make());
    }
    private void printLadder(String ladder){
        System.out.println(ladder);
    }
    private void printPlayers(){
        for (String name : players){
            System.out.printf("%-6s", name); // 각 이름당 주어진 자리는 6자리
        }
        System.out.println();
    }
}
