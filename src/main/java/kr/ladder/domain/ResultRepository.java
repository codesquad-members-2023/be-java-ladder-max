package kr.ladder.domain;

import kr.ladder.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultRepository {
    private final Map<String, String> result;
    private final OutputView outputView;

    public ResultRepository(){
        this.result = new HashMap<>();
        this.outputView = new OutputView();
    }

    public void mapping(List<Integer> mappingIndex, String[] players, String[] prizes, String generatedLadder){
        // player index, prize index
        for (int i = 0; i < mappingIndex.size(); i++) {
            result.put(players[i], prizes[mappingIndex.get(i)]);
        }
        outputView.printAll(players, generatedLadder, prizes);
    }

    public void printPrize(String command){
        if (command.equals("all")) {
            outputView.print(resultToString());
        }
        if (!command.equals("all")) {
            outputView.print(result.get(command));
        }
    }

    private String resultToString() {
        StringBuilder sb = new StringBuilder();
        for (String key : result.keySet()) {
            sb.append(key).append(" : ").append(result.get(key)).append("\n");
        }
        return sb.toString();
    }

    public void exit() {
        outputView.printExitMassage();
    }
}
