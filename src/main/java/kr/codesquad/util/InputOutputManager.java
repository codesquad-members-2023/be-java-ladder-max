package kr.codesquad.util;

import kr.codesquad.Ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputOutputManager {

    OutputHandler outputHandler = new OutputHandler();
    InputHandler inputHandler = new InputHandler();

    public ArrayList getNameAndHeightFromUser() throws IOException {
        ArrayList listForNameAndHeight = new ArrayList();
        outputHandler.outputParticipantNamePrompt();
        inputHandler.getName(listForNameAndHeight);
        outputHandler.outputLadderHeightPrompt();
        listForNameAndHeight.add(inputHandler.getHeight());
        return listForNameAndHeight;
    }

    public void printLadder(Ladder ladder){
        outputHandler.printLadder(ladder);
    }
}
