package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.HashMap;

public class ExecutionResult {

    HashMap<String,String> resultMap;

    public ExecutionResult(InputView inputHandler) throws IOException {
        resultMap = new HashMap<>();
        inputHandler.selectPlayerPrompt();
        getExecutionResult(inputHandler,inputHandler.getInput());
    }

    void getExecutionResult(InputView inputHandler,String pickedPerson){
        inputHandler.executionResultPrompt();
        if(pickedPerson.equals("all")){
            System.out.println(resultMap);
            return;
        }
        System.out.println(pickedPerson + ":" + resultMap.get(pickedPerson));
    }
}
