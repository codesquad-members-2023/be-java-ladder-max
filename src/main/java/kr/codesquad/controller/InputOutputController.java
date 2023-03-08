package kr.codesquad.controller;

import kr.codesquad.domain.InputParser;
import kr.codesquad.domain.Ladder;
import kr.codesquad.view.InputHandler;
import kr.codesquad.view.OutputHandler;

import java.io.IOException;
import java.util.ArrayList;

public class InputOutputController {

    private OutputHandler outputHandler;
    private InputHandler inputHandler;
    private InputParser inputParser;

    public InputOutputController(){
        inputHandler = new InputHandler();
        outputHandler = new OutputHandler();
        inputParser = new InputParser();
    }

    public ArrayList getNameAndHeightFromUser() throws IOException {
        ArrayList listForNameAndHeight = new ArrayList();
        outputHandler.outputParticipantNamePrompt();
        AddNameToList(listForNameAndHeight);

        outputHandler.outputLadderHeightPrompt();
        listForNameAndHeight.add(inputHandler.getInput());
        return listForNameAndHeight;
    }

    private void AddNameToList(ArrayList listForNameAndHeight) throws IOException {
        while(true){
            if(inputParser.parseAndValidate(listForNameAndHeight,inputHandler.getInput()))
                break;
        }
    }

    public void printLadder(Ladder ladder){
        outputHandler.printLadder(ladder);
    }
}
