package kr.codesquad.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExecutionResult {

    public ExecutionResult(InputView inputHandler,Map<String,String> resultMap) throws IOException {
        getNameForExcutionResult(inputHandler,resultMap);
    }

    private void getNameForExcutionResult(InputView inputHandler,Map<String,String> resultMap) throws IOException {
        inputHandler.selectPlayerPrompt();
        getExecutionResult(inputHandler,inputHandler.getInput(),resultMap);
    }

    private void getExecutionResult(InputView inputHandler,String pickedPerson,Map<String,String> resultMap){
        if(pickedPerson.equals("춘식이")){
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
        inputHandler.executionResultPrompt();
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
