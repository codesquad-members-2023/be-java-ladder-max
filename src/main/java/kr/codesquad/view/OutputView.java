package kr.codesquad.view;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.Players;
import kr.codesquad.domain.Results;

import java.util.Map;

public class OutputView {
    public void printLadder(Ladder ladder, Players player, Results result) {
        System.out.println(player+""+ladder+""+ result);
    }

    public void getExecutionResult(String pickedPerson,Map<String,String> resultMap){
        InputView inputView = new InputView();
        if(pickedPerson.equals("춘식이")){
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
        inputView.executionResultPrompt();
        if(pickedPerson.equals("all")){
            printResultMap(resultMap);
            return;
        }
        System.out.println(resultMap.get(pickedPerson));
    }

    private void printResultMap(Map<String,String> resultMap) {
        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
