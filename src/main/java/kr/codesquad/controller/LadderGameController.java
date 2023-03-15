package kr.codesquad.controller;

import kr.codesquad.domain.*;

import java.io.IOException;

public class LadderGameController {
    private final InputOutputController ioController;
    private final Players players;
    private final LadderHeight ladderHeight;
    private final Results result;

    public LadderGameController() {
        this.ioController = new InputOutputController();
        this.players = new Players();
        this.result = new Results();
        this.ladderHeight = new LadderHeight();
    }

    public void startLadderGame() throws IOException {
        ioController.setupGame(players,ladderHeight,result);
        Ladder ladder = new Ladder(players.getPlayersList(), ladderHeight.getLadderHeight());
        ioController.printLadder(ladder,players,result);
        ExecutionResultGenerator excutionResultGenerator = new ExecutionResultGenerator(ladder,players,result);
        ioController.getExecutionResult(excutionResultGenerator.getResultMap());
    }
}