package kr.codesquad.controller;

import kr.codesquad.domain.Ladder;
import kr.codesquad.domain.LadderHeight;
import kr.codesquad.domain.Player;
import kr.codesquad.domain.Result;

import java.io.IOException;
import java.util.ArrayList;

public class LadderGameController {
    InputOutputController controller;
    private Player player;
    private LadderHeight ladderheight;
    private Result result;

    public LadderGameController(){
        this.controller = new InputOutputController();
    }
    public void startLadderGame(){
        getNameFromController();
        getResultFromController();
        getLadderHeightFromController();
        Ladder ladder = getLadder();
        printLadder(ladder);
    }

    private void getNameFromController(){
        player = controller.getName();
    }
    private void getLadderHeightFromController(){
        ladderheight = controller.getHeight();
    }
    private void getResultFromController(){
        result = controller.getResult(player.getNameList().size());
    }

    private Ladder getLadder(){
        return new Ladder(player.getNameList(), ladderheight.getLadderHeight());
    }

    private void printLadder(Ladder ladder){
        controller.printLadder(ladder);
    }
    private void getExcutionResult() throws IOException {
        controller.getExcutionResult();
    }
}
