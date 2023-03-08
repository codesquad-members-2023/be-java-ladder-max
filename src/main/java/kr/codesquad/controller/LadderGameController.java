package kr.codesquad.controller;

import kr.codesquad.controller.InputOutputController;
import kr.codesquad.domain.Ladder;

import java.io.IOException;
import java.util.ArrayList;

public class LadderGameController {
    InputOutputController manager;

    public LadderGameController(){
        this.manager = new InputOutputController();
    }
    public void startLadderGame() throws IOException {
        Ladder ladder = getLadder(getNameAndHeightFromManager());
        printLadder(ladder);
    }

    private Ladder getLadder(ArrayList listForNameAndHeight){
        return new Ladder(listForNameAndHeight);
    }

    private ArrayList getNameAndHeightFromManager() throws IOException {
        return manager.getNameAndHeightFromUser();
    }

    private void printLadder(Ladder ladder){
        manager.printLadder(ladder);
    }
}
