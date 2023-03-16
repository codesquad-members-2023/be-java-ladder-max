package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private Players players;
    public void start(String list,String result, int row){
        List<String> playersList = Arrays.asList(list.split(","));

        Ladder ladder = new Ladder(row,playersList.size());
        this.players = new Players(playersList,result,ladder.make());

        System.out.println(players.getNames()); // 플레이어 이름
        System.out.println(ladder.make()); // 사다리 모양
        System.out.println(players.getResult()); // 결과
    }
    public void searchResult(String id) {
        if ("춘식이".equals(id)){
            throw new IllegalArgumentException();
        }
        System.out.println(players.searchResult(id));
    }
}
