package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderHeight;
import kr.codesquad.domain.Player;
import kr.codesquad.domain.Result;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.ArrayList;

public class InputOutputController extends Player {

    private OutputView outputHandler;
    private InputView inputHandler;

    public InputOutputController() {
        this.inputHandler = new InputView();
        this.outputHandler = new OutputView();
    }

    void getName(ArrayList nameList){
        inputHandler.playerNamePrompt();
        Player player = new Player();
        while(!player.getVaildNameFromUser(nameList, inputHandler));
    }

    void getHeight(int height){
        inputHandler.LadderHeightPrompt();
        LadderHeight ladderHeight = new LadderHeight();
        while(!ladderHeight.getValidHeightFromUser(height, inputHandler));
    }

    void getResult(ArrayList resultList,int playerNum){
        inputHandler.resultPrompt();
        Result result = new Result();
        while(!result.getResult(resultList, inputHandler, playerNum));
    }

    public void printLadder(Ladder ladder) {
        outputHandler.printLadder(ladder);
    }
}
