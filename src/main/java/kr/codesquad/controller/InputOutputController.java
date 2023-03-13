package kr.codesquad.controller;

import kr.codesquad.domain.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;

public class InputOutputController extends Player {

    private OutputView outputHandler;
    private InputView inputHandler;

    public InputOutputController() {
        this.inputHandler = new InputView();
        this.outputHandler = new OutputView();
    }

    Player getName(){
        inputHandler.playerNamePrompt();
        Player player = new Player();
        while(!player.getVaildNameFromUser(inputHandler));
        return player;
    }

    LadderHeight getHeight(){
        inputHandler.LadderHeightPrompt();
        LadderHeight ladderHeight = new LadderHeight();
        while(!ladderHeight.getValidHeightFromUser(inputHandler));
        return ladderHeight;
    }

    Result getResult(int playerNum){
        inputHandler.resultPrompt();
        Result result = new Result();
        while(!result.getResult(inputHandler, playerNum));
        return result;
    }

    void getExcutionResult() throws IOException {
        while(true){
            ExecutionResult executionResult = new ExecutionResult(inputHandler);
        }
    }

    void printLadder(Ladder ladder) {
        outputHandler.printLadder(ladder);
    }
}
