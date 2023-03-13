package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;
import java.util.HashMap;

public class InputOutputController extends Players {

    private OutputView outputHandler;
    private InputView inputHandler;

    public InputOutputController() {
        this.inputHandler = new InputView();
        this.outputHandler = new OutputView();
    }

    public void setupGame(Players players,LadderHeight ladderHeight,Result result){
        getName(players);
        getResult(result,players.getNameList().size());
        getHeight(ladderHeight);
    }

    private void getName(Players players){
        inputHandler.playerNamePrompt();
        while(!players.getVaildNameFromUser(inputHandler));
    }

    private void getHeight(LadderHeight ladderHeight){
        inputHandler.LadderHeightPrompt();
        while(!ladderHeight.getValidHeightFromUser(inputHandler));
    }

    private void getResult(Result result,int playerNum){
        inputHandler.resultPrompt();
        while(!result.getResult(inputHandler, playerNum));
    }

    void getExcutionResult(HashMap<String,Integer> resultMap,Result result) throws IOException {
        while(true){
            new ExecutionResult(inputHandler,resultMap,result);
        }
    }

    void printLadder(Ladder ladder,Players player,Result result) {
        outputHandler.printLadder(ladder,player,result);
    }
}
