package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExcutionResultGenerator {
    private HashMap<String,String> resultMap;
    Ladder ladder;
    Players player;
    Result result;

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
        HashMap<Integer,Integer> tempResultMap = new HashMap<>();
        for(int i=0;i<playerCount;i++){
            tempResultMap.put(i,ladder.ladderRide(i));
        }
        playerAndResultMatcher(tempResultMap);
    }

    private void playerAndResultMatcher(HashMap<Integer,Integer> tempResultMap){
        for(Map.Entry<Integer, Integer> elem : tempResultMap.entrySet()){
            resultMap.put(player.getNameFromNameList(elem.getKey()),result.getResultFromResultList(elem.getValue()));
        }
    }
}
