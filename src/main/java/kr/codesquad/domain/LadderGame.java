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
        // 첫번째 플레이어 이름 출력
        System.out.print(players[0]);
        System.out.print(" ".repeat(6-players[0].length()));

        // 가운데 플레이어 이름 출력
        int endIdx = players.length-1;
        for (int i=1;i<endIdx;i++){
            String str = players[i];
            int space = (5-str.length());
            System.out.print(" ".repeat(space/2));
            System.out.print(str);
            System.out.print(" ".repeat((space-space/2)));
            System.out.print(" ".repeat(3));
        }
        // 마지막 플레이어 이름 출력
        if (players[endIdx].length() < 3){
            System.out.print(" ".repeat(3-players[endIdx].length()));
            System.out.println(players[endIdx]);
            return;
        }
        System.out.println(players[endIdx]);

    }
}
