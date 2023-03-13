package kr.codesquad.domain;

import kr.codesquad.view.InputView;

import java.io.IOException;
import java.util.HashMap;

public class ExecutionResult {

    HashMap<String,String> resultMap;
    public ExecutionResult(InputView inputHandler) throws IOException {
        resultMap = new HashMap<>();
        inputHandler.selectPlayerPrompt();
        getExecutionResult(inputHandler.getInput());
        inputHandler.executionResultPrompt();
    }

    void getExecutionResult(String pickedPerson){
        if(pickedPerson.equals("all")){
            //todo all이면 hashmap다보여주고 아니면 맞는사람보여줘
        }
    }
}
