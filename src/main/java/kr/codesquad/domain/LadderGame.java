package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;

public class LadderGame {

    public void start(String list,String result, int row){
        List<String> playersList = Arrays.asList(list.split(","));
        Ladder ladder = new Ladder(row,playersList.size());
        Players players = new Players(playersList,result);
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
