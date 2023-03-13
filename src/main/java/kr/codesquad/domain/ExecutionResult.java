package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExecutionResult {

    private HashMap<String,String> resultMap;
    private InputView inputHandler;

    public ExecutionResult(InputView inputHandler,HashMap<String,String> resultMap) throws IOException {
        this.resultMap = resultMap;
        this.inputHandler = inputHandler;
        getNameForExcutionResult();
    }

    private void getNameForExcutionResult() throws IOException {
        inputHandler.selectPlayerPrompt();
        getExecutionResult(inputHandler,inputHandler.getInput());
    }

    private void getExecutionResult(InputView inputHandler,String pickedPerson){
        inputHandler.executionResultPrompt();
        if(pickedPerson.equals("all")){
            for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
            return;
        }
        System.out.println(resultMap.get(pickedPerson));
    }
}
