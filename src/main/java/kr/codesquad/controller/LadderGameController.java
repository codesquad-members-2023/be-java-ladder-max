package kr.codesquad.controller;

import kr.codesquad.domain.*;

import java.util.HashMap;

public class LadderGameController {
    private final InputOutputController ioController;
    private final Players players;
    private final LadderHeight ladderHeight;
    private final Result result;
    HashMap<String,String> resultMap;

    public LadderGameController() {
        this.ioController = new InputOutputController();
        this.players = ioController.getName();
        this.result = ioController.getResult(players.getNameList().size());
        this.ladderHeight = ioController.getHeight();
    }

    public void startLadderGame() {
        Ladder ladder = new Ladder(players.getNameList(), ladderHeight.getLadderHeight());
        ioController.printLadder(ladder, result);
//        ioController.getExcutionResult();
        System.out.println(ladder.resultMap);
    }
}