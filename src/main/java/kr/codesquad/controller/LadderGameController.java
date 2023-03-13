package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;

import java.util.ArrayList;

public class LadderGameController {
    InputOutputController controller;
    private ArrayList nameList;
    private int ladderHeight;
    private ArrayList result;

    public LadderGameController(){
        this.controller = new InputOutputController();
        nameList = new ArrayList();
        result = new ArrayList();
    }
    public void startLadderGame(){
        getNameFromController();
        getLadderHeightFromController();
        getResultFromController();
        Ladder ladder = getLadder();
        printLadder(ladder);
    }

    private void getNameFromController(){
        controller.getName(nameList);
    }
    private void getLadderHeightFromController(){
        controller.getHeight(ladderHeight);
    }
    private void getResultFromController(){
        controller.getResult(result,nameList.size());
    }

    private Ladder getLadder(){
        return new Ladder(nameList,ladderHeight);
    }

    private void printLadder(Ladder ladder){
        controller.printLadder(ladder);
    }
}
