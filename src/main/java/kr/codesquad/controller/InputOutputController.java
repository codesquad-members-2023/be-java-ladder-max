package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderHeightValidator;
import kr.codesquad.domain.PlayerNameValidator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.ArrayList;

public class InputOutputController {

    private OutputView outputHandler;
    private InputView inputHandler;
    private PlayerNameValidator nameValidator;
    private LadderHeightValidator heightValidator;


    public InputOutputController() {
        this.inputHandler = new InputView();
        this.outputHandler = new OutputView();
        this.nameValidator = new PlayerNameValidator();
        this.heightValidator = new LadderHeightValidator();
    }

    public ArrayList getNameAndHeightFromUser(){
        ArrayList listForNameAndHeight = new ArrayList();
        getName(listForNameAndHeight);
        getHeight(listForNameAndHeight);
        return listForNameAndHeight;
    }

    private void getName(ArrayList listForNameAndHeight){
        outputHandler.outputParticipantNamePrompt();
        while(!nameValidator.getValidNameFromUser(listForNameAndHeight, inputHandler));
    }

    private void getHeight(ArrayList listForNameAndHeight){
        outputHandler.outputLadderHeightPrompt();
        while(!heightValidator.getValidHeightFromUser(listForNameAndHeight, inputHandler));
    }

    public void printLadder(Ladder ladder) {
        outputHandler.printLadder(ladder);
    }
}
