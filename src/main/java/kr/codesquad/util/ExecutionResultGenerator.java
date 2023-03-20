package kr.codesquad.util;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Players;
import kr.codesquad.domain.Results;

import java.util.HashMap;

public class ExecutionResultGenerator {
    private final HashMap<String,String> resultMap;
    public HashMap<String, String> getResultMap() {
        return resultMap;
    }

    public ExecutionResultGenerator(Ladder ladder, Players player, Results result) {
        this.resultMap = new HashMap<>();
        generateResultMap(ladder,player,result);
    }

    private void generateResultMap(Ladder ladder, Players player, Results result){
        for(int i = 0; i<player.getCountOfPlayers(); i++){
            int ladderRideResult = ladder.rideLadder(i);
            resultMap.put(player.getPlayer(i),result.getResultFromResultList(ladderRideResult));
        }
    }
}
