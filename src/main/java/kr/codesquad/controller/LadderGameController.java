package kr.codesquad.controller;

import kr.codesquad.domain.*;

import java.io.IOException;

public class LadderGameController {
    private final InputOutputController ioController;
    private final Players players;
    private final LadderHeight ladderHeight;
    private final Result result;

    public LadderGameController() {
        this.ioController = new InputOutputController();
        this.players = new Players();
        this.result = new Result();
        this.ladderHeight = new LadderHeight();
    }

    public void startLadderGame() throws IOException {
        ioController.setupGame(players,ladderHeight,result);
        Ladder ladder = new Ladder(players.getNameList(), ladderHeight.getLadderHeight());
        ioController.printLadder(ladder,players,result);
        ExcutionResultGenerator excutionResultGenerator = new ExcutionResultGenerator(ladder,players,result);
        ioController.getExcutionResult(excutionResultGenerator.getResultMap());
    }
}