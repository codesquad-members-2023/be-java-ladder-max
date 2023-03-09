package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.NameValidator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.util.ArrayList;

public class InputOutputController {

    private OutputView outputHandler;
    private InputView inputHandler;
    private NameValidator inputParser;

    public InputOutputController() {
        this.inputHandler = new InputView();
        this.outputHandler = new OutputView();
        this.inputParser = new NameValidator();
    }

    public ArrayList getNameAndHeightFromUser(){
        ArrayList listForNameAndHeight = new ArrayList();
        getName(listForNameAndHeight);
        getHeight(listForNameAndHeight);
        return listForNameAndHeight;
    }

    void getName(ArrayList listForNameAndHeight){
        outputHandler.outputParticipantNamePrompt();
        listForNameAndHeight.addAll(inputParser.getValidNameFromUser(inputHandler));
    }

    void getHeight(ArrayList listForNameAndHeight){
        outputHandler.outputLadderHeightPrompt();
        listForNameAndHeight.add(inputParser.getValidHeightFromUser(inputHandler));
    }

    public void printLadder(Ladder ladder) {
        outputHandler.printLadder(ladder);
    }
}
