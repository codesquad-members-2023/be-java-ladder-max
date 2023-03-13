package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderHeight;
import kr.codesquad.domain.Player;
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

    public ArrayList getNameAndHeightFromUser(){
        ArrayList listForNameAndHeight = new ArrayList();
        getName(listForNameAndHeight);
        getHeight(listForNameAndHeight);
        return listForNameAndHeight;
    }

    private void getName(ArrayList listForNameAndHeight){
        inputHandler.ParticipantNamePrompt();
        Player playerValidator = new Player();
        while(!playerValidator.getVaildNameFromUser(listForNameAndHeight, inputHandler));
    }

    private void getHeight(ArrayList listForNameAndHeight){
        inputHandler.LadderHeightPrompt();
        LadderHeight heightValidator = new LadderHeight();
        while(!heightValidator.getValidHeightFromUser(listForNameAndHeight, inputHandler));
    }

    public void printLadder(Ladder ladder) {
        outputHandler.printLadder(ladder);
    }
}
