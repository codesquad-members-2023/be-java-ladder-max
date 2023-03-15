package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.view.ExecutionResult;
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

    void setupGame(Players players, LadderHeight ladderHeight, Results result){
        getPlayers(players);
        getResults(result,players.getPlayersList().size());
        getHeight(ladderHeight);
    }

    private void getPlayers(Players players){
        inputHandler.playerNamePrompt();
        while(!players.getValidPlayerFromUser(inputHandler));
    }

    private void getHeight(LadderHeight ladderHeight){
        inputHandler.LadderHeightPrompt();
        while(!ladderHeight.getValidHeightFromUser(inputHandler));
    }

    private void getResults(Results result, int playerNum){
        inputHandler.resultPrompt();
        while(!result.getResultsFromUser(inputHandler, playerNum));
    }

    void getExecutionResult(HashMap<String,String> resultMap) throws IOException {
        while(true){
            new ExecutionResult(inputHandler,resultMap);
        }
    }

    void printLadder(Ladder ladder, Players player, Results result) {
        outputHandler.printLadder(ladder,player,result);
    }
}
