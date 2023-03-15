package kr.codesquad.domain;

import java.util.HashMap;

public class ExecutionResultGenerator {
    private HashMap<String,String> resultMap;
    private Ladder ladder;
    private Players player;
    private Results result;

    public HashMap<String, String> getResultMap() {
        return resultMap;
    }

    public ExecutionResultGenerator(Ladder ladder, Players player, Results result) {
        this.resultMap = new HashMap<>();
        this.ladder = ladder;
        this.player = player;
        this.result = result;
        generateResultMap(player.getPlayersList().size());
    }

    private void generateResultMap(int playerCount){
        for(int i=0;i<playerCount;i++){
            int ladderRideResult = ladder.rideLadder(i);
            String playerName = player.getNameFromNameList(i);
            String resultValue = result.getResultFromResultList(ladderRideResult);
            resultMap.put(playerName, resultValue);
        }
    }
}
