package kr.codesquad.domain;

import java.util.HashMap;
import java.util.Map;

public class ExcutionResultGenerator {
    private HashMap<String,String> resultMap;
    private Ladder ladder;
    private Players player;
    private Result result;

    public HashMap<String, String> getResultMap() {
        return resultMap;
    }

    public ExcutionResultGenerator(Ladder ladder, Players player, Result result) {
        this.resultMap = new HashMap<>();
        this.ladder = ladder;
        this.player = player;
        this.result = result;
        generateResultMap(player.getNameList().size());
    }

    private void generateResultMap(int playerCount){
        for(int i=0;i<playerCount;i++){
            int ladderRideResult = ladder.ladderRide(i);
            String playerName = player.getNameFromNameList(i);
            String resultValue = result.getResultFromResultList(ladderRideResult);
            resultMap.put(playerName, resultValue);
        }
    }
}
