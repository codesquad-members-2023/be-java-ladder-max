package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderHeightValidator;
import kr.codesquad.domain.PlayerValidator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.ArrayList;

public class InputOutputController extends PlayerValidator {

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
        PlayerValidator playerValidator = new PlayerValidator();
        while(!playerValidator.getVaildNameFromUser(listForNameAndHeight, inputHandler));
    }

    private void getHeight(ArrayList listForNameAndHeight){
        inputHandler.LadderHeightPrompt();
        LadderHeightValidator heightValidator = new LadderHeightValidator();
        while(!heightValidator.getValidHeightFromUser(listForNameAndHeight, inputHandler));
    }

    public void printLadder(Ladder ladder) {
        outputHandler.printLadder(ladder);
    }
}
