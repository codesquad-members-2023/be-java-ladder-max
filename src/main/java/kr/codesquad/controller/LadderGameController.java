package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;

import java.io.IOException;
import java.util.ArrayList;

public class LadderGameController {
    InputOutputController inputOutputcontroller;

    public LadderGameController(){
        this.inputOutputcontroller = new InputOutputController();
    }
    public void startLadderGame(){
        Ladder ladder = getLadder(getNameAndHeightFromInputOutputController());
        printLadder(ladder);
    }

    private ArrayList getNameAndHeightFromInputOutputController(){
        return inputOutputcontroller.getNameAndHeightFromUser();
    }

    private Ladder getLadder(ArrayList listForNameAndHeight){
        return new Ladder(listForNameAndHeight);
    }

    private void printLadder(Ladder ladder){
        inputOutputcontroller.printLadder(ladder);
    }
}
