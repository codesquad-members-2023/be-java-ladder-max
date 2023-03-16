package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
    private Players players;
    public void start(String list,String resultList, int row){
        List<String> playersList = Arrays.asList(list.split(","));

        Ladder ladder = new Ladder(row,playersList.size());
        this.players = new Players(playersList,resultList,ladder.calculateResult());
        printAll(players,ladder);
    }
    public String searchResult(String id) {
        if ("춘식이".equals(id)){
            System.out.println("게임을 종료합니다.");
        }
//        System.out.println(players.searchResult(id));
        return players.searchResult(id);
    }
    private void printAll(Players players, Ladder ladder){ // 플레이어 이름, 사다리 모양, 결과
        System.out.println(players.getNames());
        System.out.println(ladder.make());
        System.out.println(players.getResultList());
    }
}
