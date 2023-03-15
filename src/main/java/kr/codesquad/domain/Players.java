package kr.codesquad.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Players {
    private List<String> players;
    private HashMap<String,Integer> playerResult;
    private List<String> result;
    public Players(List<String> playersList,String result){
        this.players = playersList;
        for(int i = 0; i < players.size(); i++) {
            playerResult.put(players.get(i), i);
        }
        this.result = Arrays.asList(result.split(","));
        trim(players);
        trim(this.result);
    }
    private void trim(List<String> list){
        for(int i=0; i<list.size(); i++){
            list.set(i, list.get(i).trim());
        }
    }
}
