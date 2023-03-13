package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExecutionResult {

    private HashMap<String,Integer> resultMap;
    private InputView inputHandler;
    private Result result;

    public ExecutionResult(InputView inputHandler,HashMap<String,Integer> resultMap,Result result) throws IOException {
        this.resultMap = resultMap;
        this.inputHandler = inputHandler;
        this.result = result;
        getNameForExcutionResult();
    }

    private void getNameForExcutionResult() throws IOException {
        inputHandler.selectPlayerPrompt();
        getExecutionResult(inputHandler,inputHandler.getInput());
    }

    private void getExecutionResult(InputView inputHandler,String pickedPerson){
        inputHandler.executionResultPrompt();
        if(pickedPerson.equals("all")){
            for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                System.out.println(entry.getKey() + " : " + result.resultList.get(entry.getValue()));
            }
            return;
        }
        System.out.println(result.resultList.get(resultMap.get(pickedPerson)));
    }
}
