package kr.codesquad.controller;

import kr.codesquad.controller.InputOutputController;
import kr.codesquad.domain.Ladder;

import java.io.IOException;
import java.util.ArrayList;

public class LadderGameController {
    InputOutputController controller;

    public LadderGameController(){
        this.controller = new InputOutputController();
    }
    public void startLadderGame() throws IOException {
        Ladder ladder = getLadder(getNameAndHeightFromManager());
        printLadder(ladder);
    }

    private Ladder getLadder(ArrayList listForNameAndHeight){
        return new Ladder(listForNameAndHeight);
    }

    private ArrayList getNameAndHeightFromManager(){
        return controller.getNameAndHeightFromUser();
    }

    private void printLadder(Ladder ladder){
        controller.printLadder(ladder);
    }
}
